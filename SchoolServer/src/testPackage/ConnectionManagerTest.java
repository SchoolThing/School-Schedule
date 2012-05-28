package testPackage;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import serverPackage.ConnectionManager;

public class ConnectionManagerTest{
	String url = "jdbc:derby:/home/desi/Desktop/derby/bin/users";
	
	@Test
	public void testConnecion() throws InstantiationException, IllegalAccessException, SQLException{
		Connection con = ConnectionManager.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users");
		assertNotNull(rs);
		
	}
	
	@Test (expected = SQLException.class)
	public void testSQLExceptionIsThrown() throws InstantiationException, IllegalAccessException, SQLException{
		Connection con = ConnectionManager.getConnection();
		Statement stmt = con.createStatement();
		

			ResultSet rs = stmt.executeQuery("select * from usering");

		
		
		
	}
	
	
}