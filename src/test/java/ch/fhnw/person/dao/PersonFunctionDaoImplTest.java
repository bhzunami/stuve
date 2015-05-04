package ch.fhnw.person.dao;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;

import junit.framework.Assert;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import ch.fhnw.person.model.Address;
import ch.fhnw.person.model.Function;
import ch.fhnw.person.model.Person;

@ContextConfiguration(locations={"/test-properties.xml",
								"/person-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonFunctionDaoImplTest {
	
	@Resource
	FunctionDao functionDao;
	
	@Resource
	PersonDao personDao;
	
	@Resource
	AddressDao addressDao;
	
	@Resource
	private DataSource dataSource;
	
	private DatabaseConnection conn;
		
	@BeforeTransaction
	public void onSetUpInTransaction() throws Exception {
		IDataSet dataSet = getDataSet() ;
		conn = new DatabaseConnection(dataSource.getConnection() ) ;
		DatabaseOperation.CLEAN_INSERT.execute(conn, dataSet); 
	}

	protected IDataSet getDataSet() throws Exception{
		return new FlatXmlDataSet(new FileInputStream(
			"src/test/resources/db-export.xml"));
	}
	
	@Test
	public void addFunctionsToPerson() {
		Person person = personDao.getPerson(1L);
		Assert.assertTrue(person.getFunctions().size() == 2);
		Function function = new Function("Koenig");
		person.addFunction(function);
		personDao.save(person);
		
		Assert.assertTrue("Person size", person.getFunctions().size() == 3 );
		
	}
	
	@Test
	public void addPersonsToFunction() {
//		Function function = functionDao.getFunction(1L);
		Function function2 = new Function("Test_function");
//		Assert.assertTrue(function.getPersons().size() == 2);
		
		Address address = addressDao.getAddress(4103);
		Person person = new Person("BlaBla", "Mauchle", address);
		
		personDao.save(person);
		functionDao.save(function2);

		function2.addPerson(person);
		person.addFunction(function2);
		
		ArrayList functionList = new ArrayList( person.getFunctions());
		System.out.println(functionList.get(0));

//		functionDao.save(function);
		System.out.println("Function id: "+function2.getId() );
		
//		Assert.assertTrue("Functionsize", function.getPersons().size() == 3 );
		
		List<Person> personList = personDao.searchPerson("BlaBla");
		System.out.println(personList.size());
		
		
//		Person person2 = personDao.getPersonByFirstName("Blabla");
//		System.out.println("Person2: " +person2.getId());
//		Assert.assertTrue(function.getPersons().size() == 3);
//		Set<Person> persons = function.getPersons();
//		List<Person> listOfPersons = new ArrayList<Person>(persons);
//		System.out.println("Person: " +personList.get(0).getFirstName() +" id: "+personList.get(0).getId());
	
	}
}
