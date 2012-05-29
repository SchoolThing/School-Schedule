package serverPackage;

import java.util.ArrayList;
import java.util.HashMap;

import clientPackage.ConflictOccuredException;
import clientPackage.Group;
import clientPackage.Schedule;
import clientPackage.School;
import clientPackage.SchoolClass;
import clientPackage.Subject;

import databasePackage.AbstConnect;
import databasePackage.GroupConnect;
import databasePackage.ScheduleConnect;
import databasePackage.SchoolClassConnect;
import databasePackage.SubjectConnect;

public class StructureBuilder {
	public static void buildStructure() {
		try {
			AbstConnect
			.setDbURL("jdbc:derby:C:\\Users\\Lumnatiq\\Desktop\\db-derby-10.8.1.2-bin\\bin\\SchoolSchedule");
			AbstConnect.createConnection();
			ArrayList<HashMap<String, String>> dbClasses = SchoolClassConnect
					.selectClasses();

			for (HashMap<String, String> dbClass : dbClasses) {
				if (dbClass.get("number").equals(null)) {
					continue;
				}
				SchoolClass currentClass = new SchoolClass(
						Integer.valueOf(dbClass.get("number")));

				ArrayList<HashMap<String, String>> dbGroups = GroupConnect
						.selectGroup(Integer.valueOf(dbClass.get("id")));

				for (HashMap<String, String> dbGroup : dbGroups) {
					Schedule currentSchedule = new Schedule();
					if (dbGroup.get("id").equals(null)) {
						continue;
					}
					HashMap<String, String> dbSchedule = ScheduleConnect
							.selectSchedule(Integer.valueOf(dbGroup.get("id")));
					if (dbSchedule.get("id").equals(null)) {
						continue;
					}
					ArrayList<HashMap<String, String>> dbSubjects = SubjectConnect
							.selectSubjects(Integer.valueOf(dbSchedule
									.get("id")));

					for (HashMap<String, String> dbSubject : dbSubjects) {
						try {//TODO ADD ROOM
							currentSchedule.addSubject(new Subject(Integer.valueOf(dbSubject.get("id")), dbSubject
									.get("name"), "Teacher", 100, Integer
									.valueOf(dbSubject.get("fromhour")),
									Integer.valueOf(dbSubject.get("tohour")),
									Integer.valueOf(dbSubject.get("day"))));
						} catch (Exception e) {							
							e.printStackTrace();
						}
					}

					currentSchedule
							.setID(Integer.valueOf(dbSchedule.get("id")));
					Group currentGroup = new Group(dbGroup.get("name")
							.charAt(0), currentSchedule);
					currentClass.addGroup(currentGroup);
					School.addClass(currentClass);
				}
			}
			AbstConnect.shutdown();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
