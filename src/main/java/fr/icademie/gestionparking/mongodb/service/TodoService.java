package fr.icademie.gestionparking.mongodb.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import fr.icademie.gestionparking.mongodb.exception.TodoCollectionException;
import fr.icademie.gestionparking.mongodb.model.TodoDTO;

public interface TodoService {
	
	public void createTodo(TodoDTO todo) throws ConstraintViolationException, TodoCollectionException;
	
	public List<TodoDTO> getAllTodos();
	
	public TodoDTO getSingleTodo(String todo) throws TodoCollectionException;
	
	public void updateTodo(String id, TodoDTO todo) throws TodoCollectionException;
	
	public void deleteTodoById(String id) throws TodoCollectionException;
}
