package fr.icademie.gestionparking.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.icademie.gestionparking.mongodb.model.Parking;

public interface ParkingRepository extends MongoRepository<Parking, String> {

}