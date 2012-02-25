package schoolschedule;

import java.util.List;

public class Schedule {

	List<SchoolClass> classes;
	List<Subject> subjects;
	List<Room> rooms;
	List<Teacher> teachers;
	
	public Schedule(List<SchoolClass> classes,
			List<Subject> subjects, List<Room> rooms, List<Teacher> teachers) {
		super();
		this.classes = classes;
		this.teachers = teachers;
		this.subjects = subjects;
		this.rooms = rooms;
	}
	public List<SchoolClass> getClasses() {
		return classes;
	}
	public void setClasses(List<SchoolClass> classes) {
		this.classes = classes;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void print(){
		//TODO create a print method
	}

}
