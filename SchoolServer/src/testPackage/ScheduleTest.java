package testPackage;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import clientPackage.ConflictOccuredException;

import clientPackage.Group;
import clientPackage.Schedule;
import clientPackage.School;
import clientPackage.SchoolClass;
import clientPackage.Subject;

public class ScheduleTest {

	@Test
	public void addSubjectTest() throws ConflictOccuredException {
		createFixture();
		List<SchoolClass> scl = School.getClasses();
		scl.get(0)
				.getGroup('a')
				.getSchedule()
				.addSubject(
						new Subject("Math", new String("Vanq"), 13, 1, 1, 2));
		Subject sub = new Subject("Math", new String("Vanq"), 13, 1, 1, 2);
		assertTrue(scl.get(0).getGroup('a').getSchedule().getSubjects().get(0).getTeacher().equals("Vanq"));
	}

	@Test(expected = ConflictOccuredException.class)
	public void addingSubjectInOneRoomAndOneDayAndOneHour()
			throws ConflictOccuredException {
		createFixture();
		List<SchoolClass> scl = School.getClasses();
		scl.get(0)
				.getGroup('a')
				.getSchedule()
				.addSubject(
						new Subject("Math", new String("Vanq"), 13, 1, 1, 2));
		scl.get(0)
				.getGroup('b')
				.getSchedule()
				.addSubject(
						new Subject("Bel", new String("Penka"), 13, 1, 1, 2));
	}

	@Test(expected = ConflictOccuredException.class)
	public void addingSubjectInOnerRoomAndOneDayAndPartlyOverlappingHour()
			throws ConflictOccuredException {
		createFixture();
		List<SchoolClass> scl = School.getClasses();
		scl.get(0)
				.getGroup('a')
				.getSchedule()
				.addSubject(
						new Subject("Math", new String("Vanq"), 13, 3, 4, 1));
		scl.get(0)
				.getGroup('b')
				.getSchedule()
				.addSubject(
						new Subject("Bel", new String("Penka"), 13, 2, 5, 1));
	}

	private void createFixture() {
		for (int i = 0; i < 2; i++) {
			SchoolClass scl = new SchoolClass(i + 9);
			scl.addGroup(new Group('a', new Schedule()));
			scl.addGroup(new Group('b', new Schedule()));

			School.addClass(scl);
		}
	}
}
