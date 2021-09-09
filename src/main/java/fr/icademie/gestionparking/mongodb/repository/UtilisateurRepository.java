package fr.icademie.gestionparking.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.icademie.gestionparking.mongodb.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {

}
