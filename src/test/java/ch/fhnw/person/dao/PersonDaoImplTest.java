package ch.fhnw.person.dao;


import java.io.FileInputStream;

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

import sun.util.logging.resources.logging;

import ch.fhnw.person.dao.PersonDao;
import ch.fhnw.person.model.Address;
import ch.fhnw.person.model.Person;

@ContextConfiguration(locations={"/test-properties.xml",
								"/person-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonDaoImplTest {
	@Resource
	 PersonDao personDao;
	
	private DatabaseConnection conn;
	
	@Resource
	private DataSource dataSource;
	
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
	  public void testSimpleSavePerson() {
	    Person person = new Person();
	    person.setFirstName("firstname");
	    person.setLastName("lastname");

	    Assert.assertNull("empty pk", person.getId());
	    personDao.save(person);
	    Assert.assertNotNull("generated pk", person.getId());
	    Assert.assertEquals("firstname", person.getFirstName());
	  }
	  
	  @Test
	  public void getAndModifyStudent(){
	   // Get created Student by id
	    Long id= new Long(1);
	    Person person = personDao.getPerson(id);
	    Assert.assertEquals("firstName1", person.getFirstName());
	    
	    //Modify student
	    person.setFirstName("NewName");
	    personDao.save(person);
	    
	    //Check modified Student
	    Person new_person = personDao.getPerson(id);
	    Assert.assertEquals("NewName", new_person.getFirstName());
	  }
	  
	  @Test
	  public void newPersonWithAddress() {
		  	Long id= new Long(1);
		  	Person person = personDao.getPerson(id);
		  	Address address = new Address();
		    person.setFirstName("Nicolas");
		    person.setLastName("Mauchle");
		    person.setAdress(address);
		    
		    //Check City
		    Assert.assertNull("empty pk", person.getAddress().getPlz());
		    //Set parameters
		    person.getAddress().setCity("Oberwil");
		    
		    personDao.save(person);
		    Assert.assertEquals("Oberwil", person.getAddress().getCity());
		    
		    Person new_person = personDao.getPerson(id);
		    Assert.assertEquals("Oberwil", new_person.getAddress().getCity());
	  }
	  
	  @Test
	  public void personConstructor() {
		  Address address = new Address();
		  address.setCity("Bottmingen");
		  address.setPlz(4103);
		  
		  Person person = new Person("Hans", "Mueller", address);
		  Person new_person = personDao.save(person);

		  Assert.assertNotNull("ID", new_person.getId() );
		  Assert.assertEquals("Mueller", new_person.getLastName());
		  Assert.assertEquals("Hans", new_person.getFirstName());
		  Assert.assertEquals("Bottmingen", new_person.getAddress().getCity());
		  Assert.assertEquals(Integer.valueOf(4103), new_person.getAddress().getPlz());
		  
	  }
	  @Test
	  public void oneAddressToManyPerson() {
		  Address address = new Address("Bottmingen", 4103);
		  
		  Person person_1 = new Person("Person1_first", "Person1_last", address);
		  person_1 = personDao.save(person_1);
		  
		  Person person_2 = new Person("Person2_first", "Person2_last", address);
		  person_2 = personDao.save(person_2);
		  
		  Assert.assertEquals("Bottmingen", personDao.getPerson(person_1.getId()).getAddress().getCity());
		  Assert.assertEquals("Bottmingen", personDao.getPerson(person_2.getId()).getAddress().getCity());
	  }
}
