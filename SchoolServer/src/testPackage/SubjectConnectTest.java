package testPackage;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import serverPackage.ConnectionManager;

import clientPackage.Subject;
import databasePackage.AbstConnect;
import databasePackage.SubjectConnect;

public class SubjectConnectTest {

	protected static Connection conn = null;
	protected static Statement stmt = null;
	private String tableName = "subjects";


	@Test
	public void testInsertSubjects() {
		AbstConnect.createConnection();
		AbstConnect.setTableName(tableName);
		SubjectConnect.insertSubject("math", 11, 2, 4, 3, 1);
		HashMap<String,String> hs = SubjectConnect.getSubject(49);
		assertEquals("math",hs.get("name") );
	}
	@Test
	public void testSelectSubjects(){
		AbstConnect.createConnection();
		AbstConnect.setTableName(tableName);
		ArrayList<HashMap<String,String>> arr = SubjectConnect.selectSubjects();
		String str = arr.get(0).get("name");
		assertEquals("math", str);
	}
	@Test
	public void testUpdateSubject() throws SQLException{
		AbstConnect.createConnection();
		SubjectConnect.updateSubject(25, "math", 2, 4, 2, 2, 3);
		stmt = AbstConnect.getConn().createStatement();
		ResultSet res = stmt.executeQuery("Select * from " + tableName +" where id=43");
		stmt.close();
		assertNotNull(res);
	}




}