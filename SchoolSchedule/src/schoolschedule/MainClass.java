package schoolschedule;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {

		List<SchoolClass> classes = new ArrayList<SchoolClass>();
		for(int i=0; i<5; i++){
			SchoolClass tempClass = new SchoolClass(4, new ArrayList<Group>());
			classes.add(tempClass);
		}
		
		List<Subject> subjects = new ArrayList<Subject>();
		
		List<Room> rooms = new ArrayList<Room>();
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		for(int i=0; i<10; i++){
			Subject tempSubject = new Subject();
			subjects.add(tempSubject);
			Room tempRoom = new Room();
			rooms.add(tempRoom);
			Teacher tempTeacher = new Teacher();
			teachers.add(tempTeacher);
		}
		
		Schedule schedule = new Schedule(classes, subjects, rooms, teachers);
		schedule.print();
	}

}
