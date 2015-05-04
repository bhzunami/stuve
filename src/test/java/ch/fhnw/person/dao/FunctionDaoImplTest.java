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

import ch.fhnw.person.model.Function;

@ContextConfiguration(locations={"/test-properties.xml",
							"/person-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class FunctionDaoImplTest {

	@Resource
	FunctionDao functionDao;
	
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
	public void addFunction() {
		Function function = new Function();
		function.setName("Chef");
		
		functionDao.save(function);
	    Assert.assertEquals("Chef", function.getName());
	    Assert.assertNotNull(function.getId());
	}
	
	@Test
	public void selectFunction() {
		Function function = functionDao.getFunction(1L);
		Assert.assertEquals("Function_1", function.getName());
		
		function.setName("New_Function_1");
		functionDao.save(function);
		
		Assert.assertEquals("New_Function_1", functionDao.getFunction(1L).getName());
	}
}

