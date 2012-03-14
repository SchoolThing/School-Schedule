package scheduleTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import schoolschedule.Group;
import schoolschedule.Room;
import schoolschedule.Schedule;
import schoolschedule.SchoolClass;
import schoolschedule.Subject;
import schoolschedule.Teacher;

public class ScheduleGenerateTest {

	List<Subject> subs;
	List<Group> groups;
	SchoolClass sclass;
	List<SchoolClass> classes;
	Schedule schedule;

	@Before
	public void setUp() {
		subs = createSubjects();
		groups = createGroups(subs);
		sclass = createClass(groups);
		classes = new ArrayList<SchoolClass>();
		classes.add(sclass);
		schedule = new Schedule(classes);
	}

	@After
	public void tearDown() {
		subs = null;
		groups = null;
		sclass = null;
		classes = null;
		schedule = null;
	}

	@Test
	public void testScheduleGenerate() {
		schedule.generate(sclass, subs);
		List<Group> grps = schedule.getClasses().get(0).getClassGroups();
		assertFalse(grps.get(0).equals(grps.get(1)));
	}

	private List<Subject> createSubjects() {
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

		return subjects;
	}

	private List<Group> createGroups(List<Subject> subjects) {
		List<Group> groups = new ArrayList<Group>();

		for (int i = 0; i < 2; i++) {
			int c = (int) 'A' + i;
			char b = (char) c;
			Group tmpGroup = new Group(b, subjects);
			groups.add(tmpGroup);
		}
		return groups;
	}

	private SchoolClass createClass(List<Group> grps) {
		SchoolClass scl = new SchoolClass(8, grps);

		return scl;
	}
}
