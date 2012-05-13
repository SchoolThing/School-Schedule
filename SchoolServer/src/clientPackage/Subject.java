package schedule;

public class Subject {

	private String name;
	private String teacher;
	private int room;
	private int from;
	private int to;
	private int day;

	public Subject(String name, String teacher, int room, int from, int to,
			int day) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.room = room;
		this.from = from;
		this.to = to;
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}