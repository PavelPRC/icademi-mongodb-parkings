package fr.icademie.gestionparking.mongodb.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import fr.icademie.gestionparking.mongodb.exception.EntityCollectionException;
import fr.icademie.gestionparking.mongodb.model.Utilisateur;

public interface UtilisateurService {
	public void createUtilisateur(Utilisateur user) throws ConstraintViolationException, EntityCollectionException;
	public List<Utilisateur> getAllUsers();
	public Utilisateur getUser(String idUser) throws EntityCollectionException;
}
