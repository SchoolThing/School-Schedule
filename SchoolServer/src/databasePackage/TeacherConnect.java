package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

public class TeacherConnect extends AbstConnect{
	static String tableName = "teachers";
	
	public static void insertTeacher(String name)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO "+tableName+" (name) VALUES('"+name+"')");
			stmt.close();
			
		} catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	public static HashMap<String, String> getTeacher(int ID)
	{		
		try {
			stmt = conn.createStatement();			
			
			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = "+ID);
			
			HashMap<String, String> row = new HashMap<String, String>();
			
			while (results.next()) {
				row.put("id", String.valueOf(results.getInt(1)));
				row.put("name", results.getString(2));
			}		
			
			results.close();
			stmt.close();
			
			return row;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<HashMap<String, String>> selectTeachers() {
		try {
			ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
			stmt = conn.createStatement();			
			
			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName);				
			
			while (results.next()) {
				HashMap<String, String> row = new HashMap<String, String>();
				
				row.put("id", String.valueOf(results.getInt(1)));
				row.put("name", results.getString(2));
				
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
	
	public static void deleteTeacher(int id)
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
	
	public static void updateTeacher(int id, String newName)
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



/*
 * class Teacher
 * {
 *  selectAll();
 *  get(id);
 * 	delete(id);
 *  insert(value1, value2, value3);
 *  update(id, value1, value2, value3);  
 * }
 */
public static void main(String[] args) {
		createConnection();
		for (int i = 0; i < 10; i++)
		insertTeacher("Pesho");
		HashMap<String, String> teacher5 = getTeacher(5);
		HashMap<String, String> teacher6 = getTeacher(6);		
		System.out.println(teacher5.get("name"));
		System.out.println(teacher6.get("id"));
		updateTeacher(8, "Gosho");
		ArrayList<HashMap<String, String>> teachers = selectTeachers();
		System.out.println("ID:" + teachers.get(1).get("id"));
		System.out.println("Name:" + teachers.get(1).get("name"));
		
		
		shutdown();
	}
}
