package fr.icademie.gestionparking.mongodb.conroller;

import java.util.Date;
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

import fr.icademie.gestionparking.mongodb.model.DisponibiliteDate;
import fr.icademie.gestionparking.mongodb.model.Parking;
import fr.icademie.gestionparking.mongodb.model.Reservation;
import fr.icademie.gestionparking.mongodb.model.Utilisateur;
import fr.icademie.gestionparking.mongodb.repository.DispoRepository;
import fr.icademie.gestionparking.mongodb.repository.ReservationRepository;
import fr.icademie.gestionparking.mongodb.repository.UtilisateurRepository;
import fr.icademie.gestionparking.mongodb.service.ReservationService;

@RestController
public class ReservationController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private UtilisateurRepository userRepo;
	
	@Autowired
	private DispoRepository dispoRepo;
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/utilisateurs/{idUser}/disponibilites/{idDispo}/reservations")
	public ResponseEntity<?> createReservation(@PathVariable String idUser,@PathVariable String idDispo, @RequestBody Reservation reservation){
		Optional<Utilisateur> utilisateur = userRepo.findById(idUser);
		
		Optional<DisponibiliteDate> disponibilite = dispoRepo.findById(idDispo);
		
		if(!utilisateur.isPresent()) {
			return new ResponseEntity<>("User not found with id " + idUser, HttpStatus.NOT_FOUND);
		}
		else if(!disponibilite.isPresent()) {
			return new ResponseEntity<>("Disponibilite not found with id " + idDispo, HttpStatus.NOT_FOUND);
		}		
		else {
			try {
				Utilisateur user = utilisateur.get();
				DisponibiliteDate theDispo = disponibilite.get();
				theDispo.setDispoCreneaus(null);
				reservation.setUser(user);
				reservation.setDispoDate(theDispo);	
				//reservation.setHeureCreation(idDispo);
				//reservationService.createReservation(reservation);
				Date dateNow = new Date(System.currentTimeMillis());
				reservation.setHeureCreation(dateNow.toString());
				reservationRepo.save(reservation);
				return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
			} catch (ConstraintViolationException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
			} 
		}
	}
	

	@GetMapping("/reservations")
	public ResponseEntity<?> getAllReservations(){
		//List<TodoDTO> todos = todoRepo.findAll();
		List<Reservation> reservations = reservationService.getAllReservations();
		/* this condition is handled in Service layer
		 * if(todos.size()>0) { return new
		 * ResponseEntity<List<TodoDTO>>(todos,HttpStatus.OK); } else { return new
		 * ResponseEntity<>("No todos available",HttpStatus.NOT_FOUND); }
		 */
		return new ResponseEntity<>(reservations, reservations.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
}
