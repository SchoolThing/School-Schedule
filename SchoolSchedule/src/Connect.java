
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class Connect {

	 private static String dbURL = "jdbc:derby:/home/desi/Desktop/derby/bin/Schedule";
	    private static String tableName = "Schedule";
	  
	    private static Connection conn = null;
	    private static Statement stmt = null;

	    public static void main(String[] args)
	    {
	        createConnection();
	        insertRestaurants(8, "CISCO");
	        selectRestaurants();
	        shutdown();
	    }
	    
	    private static void createConnection()
	    {
	        try
	        {
	            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
	            //Get a connection
	            conn = DriverManager.getConnection(dbURL); 
	        }
	        catch (Exception except)
	        {
	            except.printStackTrace();
	        }
	    }
	    
	    private static void insertRestaurants(int id, String cityName)
	    {
	        try
	        {
	            stmt = conn.createStatement();
	            stmt.execute(tableName + id +  cityName);
	            stmt.close();
	        }
	        catch (SQLException sqlExcept)
	        {
	            sqlExcept.printStackTrace();
	        }
	    }
	    
	    private static void selectRestaurants()
	    {
	        try
	        {
	            stmt = conn.createStatement();
	            ResultSet results = stmt.executeQuery("select * from " + tableName);
	            ResultSetMetaData rsmd = results.getMetaData();
	            int numberCols = rsmd.getColumnCount();
	            for (int i=1; i<=numberCols; i++)
	            {
	                //print Column Names
	                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
	            }

	            System.out.println("\n-------------------");

	            while(results.next())
	            {
	                int id = results.getInt(1);
	                //String restName = results.getString(2);
	                String cityName = results.getString(2);
	                System.out.println(id + "\t\t" + cityName);
	            }
	            results.close();
	            stmt.close();
	        }
	        catch (SQLException sqlExcept)
	        {
	            sqlExcept.printStackTrace();
	        }
	    }
	    
	    private static void shutdown()
	    {
	        try
	        {
	            if (stmt != null)
	            {
	                stmt.close();
	            }
	            if (conn != null)
	            {
	                DriverManager.getConnection(dbURL + ";shutdown=true");
	                conn.close();
	            }           
	        }
	        catch (SQLException sqlExcept)
	        {
	            
	        }

	    }
	
}
