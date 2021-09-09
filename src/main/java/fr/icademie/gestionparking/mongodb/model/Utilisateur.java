package fr.icademie.gestionparking.mongodb.model;

import java.util.List;

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
@Document(collection="utilisateurs")
public class Utilisateur {
	
	@Id
	private String id;	
	private String username;	
	private String telephone;	
	private String codePostale;	
	private String ville;	
}
