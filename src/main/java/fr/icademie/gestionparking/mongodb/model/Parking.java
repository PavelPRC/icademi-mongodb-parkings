package fr.icademie.gestionparking.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
@Document(collection="parkings")
public class Parking {

	@Id
	private String id;
	
	private String emplacement;
	
	private int hauteur;
	private int surface;
	private String ville;
	private String rue;
	private String code_postale;
	private String latitude;
	private String longtitude;
	private boolean couvert;
	//private String idUser;

	@DBRef
	private Utilisateur idUser;
	
	@DBRef
	//@Field("disponibilites")
	//private DisponibiliteDate disponibilite;
	private List<DisponibiliteDate> disponibilites;
}
