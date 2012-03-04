package schoolschedule;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		List<Subject> subjects = new ArrayList<Subject>();

		
			Room tmpRoom1 = new Room(11);
			Room tmpRoom2 = new Room(12);
			Teacher tmpTeacher1 = new Teacher("Janet");
			Teacher tmpTeacher2 = new Teacher("Mitova");
			Subject tmpSub = new Subject("Math", tmpRoom1, tmpTeacher1);
			Subject tmpSub = new Subject("BEL", tmpRoom2, tmpTeacher2);
			subjects.add(tmpSub1);
			subjects.add(tmpSub2);

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
		schedule.generate(subjects);
		schedule.classes.get(0).setGroupSchedule(subjects, 1);
		schedule.print();
	}
}
