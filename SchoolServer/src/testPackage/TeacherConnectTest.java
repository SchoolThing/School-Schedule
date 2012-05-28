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
import databasePackage.GroupConnect;
import databasePackage.TeacherConnect;

public class TeacherConnectTest {
	protected static Connection conn = null;
	protected static Statement stmt = null;
	private String tableName = "teachers";
	
	@Test
	public void testInsertTeacher() {
		AbstConnect.createConnection();
		AbstConnect.setTableName(tableName);
		TeacherConnect.insertTeacher("Abramovich");
		HashMap<String,String> hs = TeacherConnect.getTeacher(15);
		assertEquals("Abramovich",hs.get("name"));
	}
	@Test
	public void testSelectTeacher(){
		AbstConnect.createConnection();
		AbstConnect.setTableName(tableName);
		ArrayList<HashMap<String,String>> arr = TeacherConnect.selectTeachers();
		String str = arr.get(0).get("name");
		assertEquals("Pesho", str);
	}
	@Test
	public void testUpdateTeacher() throws SQLException{
		AbstConnect.createConnection();
		TeacherConnect.updateTeacher(1, "Mitova");
		stmt = AbstConnect.getConn().createStatement();
		ResultSet res = stmt.executeQuery("Select * from " + tableName +" where id=1");
		stmt.close();
		assertNotNull(res);
	} 
	
}
