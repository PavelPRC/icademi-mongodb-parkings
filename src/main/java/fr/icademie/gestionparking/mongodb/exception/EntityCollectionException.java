package fr.icademie.gestionparking.mongodb.exception;

public class EntityCollectionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityCollectionException(String message) {
		super(message);
	}
	public static String NotFoundException(String id) {
		return "Document with " + id + " not found!";
	}
	
	public static String EntityAlreadyExists() {
		return "Document with given id already exists";
	}
}
