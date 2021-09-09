package fr.icademie.gestionparking.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="reservations")
public class Reservation {
	@Id
	private String id;
	
	private String heuredebutRes;
	
	private String heurefinRes;
	
	private String heureCreation;
	
	private String demandeRes;
	
	private boolean activeRes;

	private String emailRequester;
	
	//private Utilisateur user;
	
	private Utilisateur user;
	private DisponibiliteDate dispoDate;
}
