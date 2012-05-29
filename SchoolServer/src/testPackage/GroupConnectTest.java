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
import databasePackage.SubjectConnect;

public class GroupConnectTest {
	protected static Connection conn = null;
	protected static Statement stmt = null;
	private String tableName = "groups";

	@Test
	public void testInsertGroup() {
		AbstConnect.createConnection();
		AbstConnect.setTableName(tableName);
		GroupConnect.insertGroup("A", 1);
		HashMap<String,String> hs = GroupConnect.getGroup(3);
		assertEquals("A",hs.get("name"));
	}
	@Test
	public void testSelectGroup(){
		AbstConnect.createConnection();
		AbstConnect.setTableName(tableName);
		ArrayList<HashMap<String,String>> arr = GroupConnect.selectGroups();
		String str = arr.get(0).get("name");
		assertEquals("B", str);
	}
	@Test
	public void testUpdateGroup() throws SQLException{
		AbstConnect.createConnection();
		GroupConnect.updateGroup(1, "B", 9);
		stmt = AbstConnect.getConn().createStatement();
		ResultSet res = stmt.executeQuery("Select * from " + tableName +" where id=1");
		stmt.close();
		assertNotNull(res);
	}

}