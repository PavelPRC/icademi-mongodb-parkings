package fr.icademie.gestionparking.mongodb.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.icademie.gestionparking.mongodb.exception.EntityCollectionException;
import fr.icademie.gestionparking.mongodb.exception.TodoCollectionException;
import fr.icademie.gestionparking.mongodb.model.Utilisateur;
import fr.icademie.gestionparking.mongodb.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepository userRepo;
	
	@Override
	public void createUtilisateur(Utilisateur user) throws ConstraintViolationException, EntityCollectionException {
		Optional<Utilisateur> userOptional = userRepo.findById(user.getId());
		if(userOptional.isPresent()) {
			throw new EntityCollectionException(EntityCollectionException.EntityAlreadyExists());
		}
	}

	@Override
	public List<Utilisateur> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getUser(String idUser) throws EntityCollectionException {
		Optional<Utilisateur> optionalUser = userRepo.findById(idUser);
		if(!optionalUser.isPresent()) {
			throw new EntityCollectionException(EntityCollectionException.NotFoundException(idUser+""));
		}else {
			return optionalUser.get();
		}
	}

}
