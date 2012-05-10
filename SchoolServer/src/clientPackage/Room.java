package clientPackage;

public class Room {

	private int number;
	
	public Room(int number) {
		super();
		this.number = number;
	}

	public int getRoomNumber() {
		return number;
	}

	public void setRoomNumber(int number) {
		this.number = number;
	}

	public void print() {
		System.out.print(number);
		
	}

}
