package fr.icademie.gestionparking.mongodb.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import fr.icademie.gestionparking.mongodb.exception.EntityCollectionException;
import fr.icademie.gestionparking.mongodb.model.Parking;

public interface ParkingService {
	public void createParking (Parking parking) throws ConstraintViolationException, EntityCollectionException;
	public List<Parking> getAllParkings();
	
}
