package databasePackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ScheduleConnect extends AbstConnect{

	public static void insertSchedule(int groupID)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO "+tableName+" (groupID) VALUES("+groupID+")");
			stmt.close();
			
		} catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	public static HashMap<String, String> getSchedule(int ID)
	{		
		try {
			stmt = conn.createStatement();			
			
			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = "+ID);
			
			HashMap<String, String> row = new HashMap<String, String>();
			
			while (results.next()) {
				row.put("id", String.valueOf(results.getInt(1)));
				row.put("groupID", String.valueOf(results.getInt(2)));
			}		
			
			results.close();
			stmt.close();
			
			return row;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<HashMap<String, String>> selectSchedule() {
		try {
			ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
			stmt = conn.createStatement();			
			
			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName);				
			
			while (results.next()) {
				HashMap<String, String> row = new HashMap<String, String>();
				
				row.put("id", String.valueOf(results.getInt(1)));
				row.put("groupID", String.valueOf(results.getInt(2)));
				
				rows.add(row);
			}		
			
			results.close();
			stmt.close();
			
			return rows;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public static void deleteSchedule(int id)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM "+tableName+" WHERE id="+id);
			stmt.close();
		} catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void updateSchedule(int id, int newgroupID)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE "+tableName+" SET groupID="+newgroupID+" WHERE id="+id);
			stmt.close();
		} catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
}