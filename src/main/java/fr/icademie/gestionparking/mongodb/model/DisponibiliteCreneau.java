package fr.icademie.gestionparking.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DisponibiliteCreneau {

	private int id;
	
	private String heureDebut;
	private String heureFin;
	
}
