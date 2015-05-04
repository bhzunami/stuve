package ch.fhnw.person.service;

import java.util.List;

import ch.fhnw.person.model.Function;

public interface FunctionService {

	/**
	 * Save a new function into the database
	 * 
	 * @param function
	 */
	void save(Function function);

	/**
	 * Get a function from the database with the given id as id
	 * 
	 * @param id
	 * @return Function
	 */
	Function getFunction(Long id);

	/**
	 * Get all functions from the database
	 * 
	 * @return List<Function>
	 */
	List<Function> getFunctions();

	/**
	 * Delete a existing function from the database
	 * 
	 * @param function
	 */
	void delFunction(Function function);

	/**
	 * Search a function with the specific name and return it
	 * 
	 * @param name
	 * @return Function
	 */
	Function searchFunctionByName(String name);

}
