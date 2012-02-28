package schoolschedule;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		List<Subject> subjects = new ArrayList<Subject>();

		for (int i = 0; i < 10; i++) {
			Room tmpRoom = new Room(i + 11);
			Teacher tmpTeacher = new Teacher("PG" + i + 1);
			Subject tmpSub = new Subject("Math" + i, tmpRoom, tmpTeacher);
			subjects.add(tmpSub);
		}

		List<Group> groups = new ArrayList<Group>();

		for (int i = 0; i < 4; i++) {
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
		schedule.generate();
		schedule.print();
	}
}