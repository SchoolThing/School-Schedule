package serverPackage;

import java.sql.*; 
import java.util.*; 

public class ConnectionManager {

	static Connection con; 
	static String url; 
	
	public static Connection getConnection() throws InstantiationException, IllegalAccessException { 
		try { 
			String url = "jdbc:derby:/home/desi/Desktop/derby/bin/users"; // assuming "DataSource" is your DataSource name 
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance(); 
			try { 
				con = DriverManager.getConnection(url,"desi","admin"); // assuming your SQL Server's username is "username" // and password is "password" 
				} catch (SQLException ex) { 
					ex.printStackTrace(); 
					} 
			} catch(ClassNotFoundException e) { 
				System.out.println(e); 
				} return con; 
				}
	}

