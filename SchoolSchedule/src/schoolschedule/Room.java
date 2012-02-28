package schoolschedule;

public class Room {

	private static int number;
	
	public Room(int number) {
		super();
		this.number = number;
	}

	public static int getRoomNumber() {
		return number;
	}

	public static void setRoomNumber(int number) {
		Room.number = number;
	}

	public static void print() {
		System.out.println(number);
		
	}

}
