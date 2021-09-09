package fr.icademie.gestionparking.mongodb.service;

import javax.validation.ConstraintViolationException;

import fr.icademie.gestionparking.mongodb.exception.EntityCollectionException;
import fr.icademie.gestionparking.mongodb.model.Reservation;

public interface ReservationService {
	public void createReservation(Reservation reservation)throws ConstraintViolationException,EntityCollectionException;
}
