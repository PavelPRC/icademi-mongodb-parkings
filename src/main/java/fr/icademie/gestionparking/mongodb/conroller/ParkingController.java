package fr.icademie.gestionparking.mongodb.conroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.icademie.gestionparking.mongodb.exception.EntityCollectionException;
import fr.icademie.gestionparking.mongodb.exception.TodoCollectionException;
import fr.icademie.gestionparking.mongodb.model.DisponibiliteDate;
import fr.icademie.gestionparking.mongodb.model.Parking;
import fr.icademie.gestionparking.mongodb.model.Utilisateur;
import fr.icademie.gestionparking.mongodb.repository.DispoRepository;
import fr.icademie.gestionparking.mongodb.repository.ParkingRepository;
import fr.icademie.gestionparking.mongodb.repository.UtilisateurRepository;
import fr.icademie.gestionparking.mongodb.service.ParkingService;

@RestController
public class ParkingController {

	@Autowired
	private ParkingRepository parkingRepo;
	
	@Autowired 
	private DispoRepository dispoRepo;
	
	@Autowired 
	private UtilisateurRepository userRepo;
	
	@Autowired
	private ParkingService parkingService;
	
	@GetMapping("/parkings")
	public ResponseEntity<?> getAllParkings(){
		//List<TodoDTO> todos = todoRepo.findAll();
		List<Parking> parkings = parkingService.getAllParkings();
		/* this condition is handled in Service layer
		 * if(todos.size()>0) { return new
		 * ResponseEntity<List<TodoDTO>>(todos,HttpStatus.OK); } else { return new
		 * ResponseEntity<>("No todos available",HttpStatus.NOT_FOUND); }
		 */
		return new ResponseEntity<>(parkings, parkings.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/parkings")
	public ResponseEntity<?> createParking(@RequestBody Parking parking){
		try {
			//todo.setCreatedAt(new Date(System.currentTimeMillis()));
			parkingService.createParking(parking); 
			parkingRepo.save(parking);
			return new ResponseEntity<Parking>(parking,HttpStatus.OK);
		//}catch(Exception e) {
		}catch(ConstraintViolationException e) {
			//return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (EntityCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}	
	}
	
	@PostMapping("/utilisateurs/{idUser}/parkings")
	public ResponseEntity<?> createParkingForUser(@PathVariable String idUser, @RequestBody Parking parking){
		Optional<Utilisateur> utilisateur = userRepo.findById(idUser);
		Optional<DisponibiliteDate> dispo = dispoRepo.findById("61360982824e123a3e0b7cf3");
		Optional<DisponibiliteDate> dispo2 = dispoRepo.findById("6136075b824e123a3e0b7cdb");
		Optional<DisponibiliteDate> dispo3 = dispoRepo.findById("6136077d824e123a3e0b7cdd");
		if(!utilisateur.isPresent()) {
			return new ResponseEntity<>("User not found with id " + idUser, HttpStatus.NOT_FOUND);
		}
		else {
			try {
				//todo.setCreatedAt(new Date(System.currentTimeMillis()));
				//parking.setIdUser(utilisateur.get().getId());
				parking.setIdUser(utilisateur.get());
				List<DisponibiliteDate> dispos = new ArrayList<>();
				dispos.add(dispo.get());
				//dispos.add(dispo2.get());
				//dispos.add(dispo3.get());
				parking.setDisponibilites(dispos);
				//parkingService.createParking(parking); 
				parkingRepo.save(parking);
				return new ResponseEntity<Parking>(parking,HttpStatus.OK);
			//}catch(Exception e) {
			}catch(ConstraintViolationException e) {
				//return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
			} 	
		}
	}
	
//	@PostMapping("/utilisateurs/{idUser}/parkings")
//	public ResponseEntity<?> loadParkingForUser(@PathVariable String idUser, @RequestBody Parking parking){
//		Optional<Utilisateur> utilisateur = userRepo.findById(idUser);
//		if(!utilisateur.isPresent()) {
//			return new ResponseEntity<>("User not found with id " + idUser, HttpStatus.NOT_FOUND);
//		}
//		else {
//			try {
//				//todo.setCreatedAt(new Date(System.currentTimeMillis()));
//				parking.setIdUser(utilisateur.get());
//
//				//parkingService.createParking(parking); 
//				parkingRepo.save(parking);
//				return new ResponseEntity<Parking>(parking,HttpStatus.OK);
//			//}catch(Exception e) {
//			}catch(ConstraintViolationException e) {
//				//return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//				return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
//			} 	
//		}
//	}
	
}
