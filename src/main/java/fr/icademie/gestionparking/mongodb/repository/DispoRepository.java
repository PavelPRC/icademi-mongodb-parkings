package fr.icademie.gestionparking.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.icademie.gestionparking.mongodb.model.DisponibiliteDate;

public interface DispoRepository extends MongoRepository<DisponibiliteDate, String> {

}
