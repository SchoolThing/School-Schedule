package testPackage;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import databasePackage.AbstConnect;
import databasePackage.SchoolClassConnect;
import databasePackage.TeacherConnect;

public class SchoolClassConnectTest {
	protected static Connection conn = null;
	protected static Statement stmt = null;
	private String tableName = "classes";
	
	@Test
	public void testInsertClass() {
		AbstConnect.createConnection();
		AbstConnect.setTableName(tableName);
		SchoolClassConnect.insertClass(9);
		HashMap<String,String> hs = SchoolClassConnect.getClass(2);
		assertEquals("9",hs.get("number"));
	}
	@Test
	public void testSelectClasses(){
		AbstConnect.createConnection();
		AbstConnect.setTableName(tableName);
		ArrayList<HashMap<String,String>> arr = SchoolClassConnect.selectClasses();
		String str = arr.get(0).get("number");
		assertEquals("10", str);
	}
	@Test
	public void testUpdateClasses() throws SQLException{
		AbstConnect.createConnection();
		SchoolClassConnect.updateClass(1, 10);
		stmt = AbstConnect.getConn().createStatement();
		ResultSet res = stmt.executeQuery("Select * from " + tableName +" where id=1");
		stmt.close();
		assertNotNull(res);
	}

}
