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
import databasePackage.ScheduleConnect;

public class ScheduleConnectTest {
	protected static Connection conn = null;
	protected static Statement stmt = null;
	private String tableName = "schedule";

	@Test
	public void testInsertSchedule() {
		AbstConnect.createConnection();
		AbstConnect.setTableName(tableName);
		ScheduleConnect.insertSchedule(2);
		HashMap<String,String> hs = ScheduleConnect.getSchedule(2);
		assertEquals("2",hs.get("groupID"));
	}
	@Test
	public void testSelectSchedule(){
		AbstConnect.createConnection();
		AbstConnect.setTableName(tableName);
		ArrayList<HashMap<String,String>> arr = ScheduleConnect.selectSchedule();
		String str = arr.get(0).get("groupID");
		assertEquals("3", str);
	}
	@Test
	public void testUpdateSchedule() throws SQLException{
		AbstConnect.createConnection();
		ScheduleConnect.updateSchedule(1, 3);
		stmt = AbstConnect.getConn().createStatement();
		ResultSet res = stmt.executeQuery("Select * from " + tableName +" where id=1");
		stmt.close();
		assertNotNull(res);
	}

}