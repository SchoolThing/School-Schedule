package schoolschedule;

public class Subject {
	
	private static String name;
	private static  Room room;
	private static Teacher teacher;

	public Subject(String name, Room room, Teacher teacher) {
		super();
		this.name = name;
		this.room = room;
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public static void print() {
		System.out.println(name +room.getRoomNumber()+ teacher);
		
	}

}
