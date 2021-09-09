package fr.icademie.gestionparking.mongodb.service;

import java.util.Date;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.icademie.gestionparking.mongodb.exception.EntityCollectionException;
import fr.icademie.gestionparking.mongodb.model.Reservation;
import fr.icademie.gestionparking.mongodb.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepo;

	@Override
	public void createReservation(Reservation reservation) throws ConstraintViolationException, EntityCollectionException {
		Optional<Reservation> reservationOptional = reservationRepo.findById(reservation.getId());
		if(reservationOptional.isPresent()) {
			throw new EntityCollectionException(EntityCollectionException.EntityAlreadyExists());
		}else {
			Date dateNow = new Date(System.currentTimeMillis());
			reservation.setHeureCreation(dateNow.toString());		
		}
	}
}
