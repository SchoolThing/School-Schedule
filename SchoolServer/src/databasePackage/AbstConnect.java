package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstConnect {

	protected static String dbURL = "jdbc:derby:/home/brym/Desktop/derby/bin/SchoolSchedule";
	protected static String tableName = "teachers";

	protected static Connection conn = null;
	protected static Statement stmt = null;


	public static void createConnection() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

			conn = DriverManager.getConnection(dbURL);
		} catch (Exception except) {
			except.printStackTrace();
		}
	}

	public static void shutdown() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				DriverManager.getConnection(dbURL + ";shutdown=true");
				conn.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}

	public static String getDbURL() {
		return dbURL;
	}

	public static void setDbURL(String dbURL) {
		AbstConnect.dbURL = dbURL;
	}

	public static String getTableName() {
		return tableName;
	}

	public static void setTableName(String tableName) {
		AbstConnect.tableName = tableName;
	}

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		AbstConnect.conn = conn;
	}

	public static Statement getStmt() {
		return stmt;
	}

	public static void setStmt(Statement stmt) {
		AbstConnect.stmt = stmt;
	}
	
}
