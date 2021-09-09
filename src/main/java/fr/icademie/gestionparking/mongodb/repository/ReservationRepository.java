package fr.icademie.gestionparking.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.icademie.gestionparking.mongodb.model.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, String> {

}
