package ch.fhnw.person.dao;

import java.util.List;

import ch.fhnw.person.model.Function;

public interface FunctionDao {
	
	/**
	 * Save a new function into the database
	 * 
	 * @param function
	 */
	public void save(Function function);
	  
	/**
	 * Get a function from the database with the given 
	 * id as id
	 * 
	 * @param id
	 * @return Function
	 */
	public Function getFunction(Long id);
  
	/**
	 * Get all functions from the database
	 * 
	 * @return List<Function>
	 */
	public List<Function> getFunctions();
  
	/**
	 * Delete a existinging function from the 
	 * database
	 * 
	 * @param function
	 */
	public void delFunction(Function function);
	
	/**
	 * Search a function with the specific name and 
	 * return it
	 * 
	 * @param name
	 * @return Function
	 */
	public Function searchFunctionByName(String name);
}
