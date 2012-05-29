package databasePackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupConnect extends AbstConnect {
	
	static String tableName = "groups";
	
	public static void insertGroup(String name, int classID)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO "+tableName+" (name, classID) VALUES('"+name+"', "+classID+")");
			stmt.close();
			
		} catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	public static HashMap<String, String> getGroup(int ID)
	{		
		try {
			stmt = conn.createStatement();			
			
			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = "+ID);
			
			HashMap<String, String> row = new HashMap<String, String>();
			
			while (results.next()) {
				row.put("id", String.valueOf(results.getInt(1)));
				row.put("name", results.getString(2));
				row.put("classID", String.valueOf(results.getInt(3)));
			}		
			
			results.close();
			stmt.close();
			
			return row;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<HashMap<String, String>> selectGroups() {
		try {
			ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
			stmt = conn.createStatement();			
			
			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName);				
			
			while (results.next()) {
				HashMap<String, String> row = new HashMap<String, String>();
				
				row.put("id", String.valueOf(results.getInt(1)));
				row.put("name", results.getString(2));
				row.put("classID", results.getString(3));
				
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
	
	public static void deleteGroup(int id)
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
	
	public static void updateGroup(int id, String newName, int classID)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE "+tableName+" SET name='"+newName+"' WHERE id="+id);
			stmt.close();
		} catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static ArrayList<HashMap<String, String>> selectGroup(int classID) {
		try {
			ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
			stmt = conn.createStatement();			
			
			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE classid="+classID);				
			
			while (results.next()) {
				HashMap<String, String> row = new HashMap<String, String>();
				
				row.put("id", String.valueOf(results.getInt(1)));
				row.put("name", results.getString(2));
				row.put("classID", results.getString(3));
				
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

}