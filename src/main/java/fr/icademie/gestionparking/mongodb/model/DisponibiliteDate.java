package fr.icademie.gestionparking.mongodb.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="disponibilites")
public class DisponibiliteDate {

	@Id
	private String id;
	
	private String dateDispo;	
	private String commentaire;	
	private boolean isStillValid ;

	private List<DisponibiliteCreneau> dispoCreneaus;
}
