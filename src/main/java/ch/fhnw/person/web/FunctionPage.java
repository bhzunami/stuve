package ch.fhnw.person.web;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DualListModel;

import ch.fhnw.person.model.Function;
import ch.fhnw.person.service.FunctionService;

public class FunctionPage {
	
	private FunctionService functionService;
//	private Function function;
//	private List<Function> functions;
	
	private DualListModel<String> functions;
	
	public FunctionPage() {
//		List<Function> source = functionService.getFunctions();
//		System.out.println("Functions: " +source);
		List<String> source = new ArrayList<String>();
		List<String> target = new ArrayList<String>();

		source.add("Chef");
		source.add("Assistent");
		source.add("Mitarbeiter");
		source.add("Lehrling");
		
		
		functions = new DualListModel<String>(source, target);
	}
	
	
	public void setFunctions(DualListModel<String> functions) {
		this.functions = functions;
	}
	
	public DualListModel<String> getFunctions() {
		return functions;
	}
	
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}


	public FunctionService getFunctionService() {
		return functionService;
	}

}
