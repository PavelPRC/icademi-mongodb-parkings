package fr.icademie.gestionparking.mongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.icademie.gestionparking.mongodb.exception.EntityCollectionException;
import fr.icademie.gestionparking.mongodb.model.Parking;
import fr.icademie.gestionparking.mongodb.repository.ParkingRepository;

@Service
public class ParkingServiceImpl implements ParkingService {
	
	@Autowired
	private ParkingRepository parkingRepo;

	@Override
	public void createParking(Parking parking) throws ConstraintViolationException, EntityCollectionException{
		Optional<Parking> parkingOptional = parkingRepo.findById(parking.getId());
		if(parkingOptional.isPresent()) {
			throw new EntityCollectionException(EntityCollectionException.EntityAlreadyExists());
		}
	}

	@Override
	public List<Parking> getAllParkings() {
		List<Parking> parkings = parkingRepo.findAll();
		if(parkings.size() > 0) {
			return parkings;
		}else {
			return new ArrayList<Parking>();
		}
	}
}
