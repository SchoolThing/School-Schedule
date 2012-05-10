package clientPackage;

import java.util.ArrayList;
import java.util.List;



public class MainClass {

	public static void main(String[] args) {
		List<Subject> subjects = new ArrayList<Subject>();

		Room tmpRoom1 = new Room(11);
		Room tmpRoom2 = new Room(12);
		Room tmpRoom3 = new Room(13);
		Room tmpRoom4 = new Room(14);
		Teacher tmpTeacher1 = new Teacher("Janet");
		Teacher tmpTeacher2 = new Teacher("Mitova");
		Teacher tmpTeacher3 = new Teacher("Daskalova");
		Teacher tmpTeacher4 = new Teacher("Mitov");
		Subject tmpSub1 = new Subject("Math", tmpRoom1, tmpTeacher1);
		Subject tmpSub2 = new Subject("BEL", tmpRoom2, tmpTeacher2);
		Subject tmpSub3 = new Subject("Biology", tmpRoom3, tmpTeacher3);
		Subject tmpSub4 = new Subject("TP", tmpRoom4, tmpTeacher4);
		subjects.add(tmpSub1);
		subjects.add(tmpSub2);
		subjects.add(tmpSub3);
		subjects.add(tmpSub4);

		List<Group> groups = new ArrayList<Group>();

		for (int i = 0; i < 2; i++) {
			int c = (int) 'A' + i;
			char b = (char) c;
			Group tmpGroup = new Group(b, subjects);
			groups.add(tmpGroup);
		}

		List<SchoolClass> classes = new ArrayList<SchoolClass>();

		SchoolClass tmpSchoolClass = new SchoolClass(8, groups);
		classes.add(tmpSchoolClass);

		Schedule schedule = new Schedule(classes);
		schedule.classes.get(0).getClassSchedule();
		schedule.generate(classes.get(0), subjects);
		schedule.classes.get(0).setGroupSchedule(subjects, 1);
		schedule.print();
	}
}