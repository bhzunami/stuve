package ch.fhnw.person.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ch.fhnw.person.dao.FunctionDao;
import ch.fhnw.person.model.Function;

@Transactional
public class FunctionServiceImpl implements FunctionService {
	
	FunctionDao functionDao;

	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}

	public void save(Function function) {
		functionDao.save(function);
		
	}

	public Function getFunction(Long id) {
		return functionDao.getFunction(id);
	}

	public List<Function> getFunctions() {
		return functionDao.getFunctions();
	}

	public void delFunction(Function function) {
		functionDao.delFunction(function);
		
	}

	public Function searchFunctionByName(String name) {
		return functionDao.searchFunctionByName(name);
	}

}
