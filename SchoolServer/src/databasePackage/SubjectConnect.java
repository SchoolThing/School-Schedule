package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SubjectConnect extends AbstConnect {
	static String tableName = "subjects";
	
	public static void insertSubject(String name, int from, int to, int day,
			int teacherID, int scheduleID) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO "
					+ tableName
					+ " (name, fromhour, tohour, day, teacherID, scheduleID) VALUES('"
					+ name + "', " + from + ", " + to + ", " + day + ", "
					+ teacherID + ", " + scheduleID + ")");
			stmt.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static HashMap<String, String> getSubject(int ID) {
		try {
			stmt = conn.createStatement();

			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName
					+ " WHERE id = " + ID);

			HashMap<String, String> row = new HashMap<String, String>();

			while (results.next()) {
				row.put("id", String.valueOf(results.getInt(1)));
				row.put("name", results.getString(2));
				row.put("fromhour", String.valueOf(results.getInt(3)));
				row.put("tohour", String.valueOf(results.getInt(4)));
				row.put("day", String.valueOf(results.getInt(5)));
				row.put("teacherID", String.valueOf(results.getInt(6)));
				row.put("schoolID", String.valueOf(results.getInt(7)));
			}

			results.close();
			stmt.close();

			return row;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ArrayList<HashMap<String, String>> selectSubjects() {
		try {
			ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
			stmt = conn.createStatement();

			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName);

			while (results.next()) {
				HashMap<String, String> row = new HashMap<String, String>();

				row.put("id", String.valueOf(results.getInt(1)));
				row.put("name", results.getString(2));
				row.put("fromhour", String.valueOf(results.getInt(3)));
				row.put("tohour", String.valueOf(results.getInt(4)));
				row.put("day", String.valueOf(results.getInt(5)));
				row.put("teacherID", String.valueOf(results.getInt(6)));
				row.put("scheduleID", String.valueOf(results.getInt(7)));

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
	
	public static HashMap<String, String> selectSubjectByHourAndDay(int hour, int day, int scheduleID) {
		try {
			stmt = conn.createStatement();

			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE "+hour+" BETWEEN fromhour AND tohour AND day="+day+" AND scheduleID="+scheduleID);

			HashMap<String, String> row = new HashMap<String, String>();
			
			while (results.next()) {			
				row.put("id", String.valueOf(results.getInt(1)));
				row.put("name", results.getString(2));
				row.put("fromhour", String.valueOf(results.getInt(3)));
				row.put("tohour", String.valueOf(results.getInt(4)));
				row.put("day", String.valueOf(results.getInt(5)));
				row.put("teacherID", String.valueOf(results.getInt(6)));
				row.put("schedulelID", String.valueOf(results.getInt(7)));
			}

			results.close();
			stmt.close();

			return row;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static void deleteSubject(int id) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id=" + id);
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void deleteAll() {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM " + tableName);
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void updateSubject(int id, String newName, int from, int to,
			int day, int teacherID, int scheduleID) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE " + tableName + " SET name='" + newName
					+ "', fromhour=" + from + ", tohour=" + to + ", day=" + day
					+ ", teacherID=" + teacherID + ", scheduleID=" + scheduleID
					+ "WHERE id=" + id);
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static ArrayList<HashMap<String, String>> selectSubjects(
			int scheduleID) {
		try {
			ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
			stmt = conn.createStatement();

			ResultSet results = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE scheduleid="+scheduleID);

			while (results.next()) {
				HashMap<String, String> row = new HashMap<String, String>();

				row.put("id", String.valueOf(results.getInt(1)));
				row.put("name", results.getString(2));
				row.put("fromhour", String.valueOf(results.getInt(3)));
				row.put("tohour", String.valueOf(results.getInt(4)));
				row.put("day", String.valueOf(results.getInt(5)));
				row.put("teacherID", String.valueOf(results.getInt(6)));
				row.put("scheduleID", String.valueOf(results.getInt(7)));

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