package clientPackage;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private Schedule schedule;
	private char groupID;

	public Group(char groupID, Schedule schedule) {
		super();
		this.groupID = groupID;
		this.schedule = schedule;
	}

	public Schedule getSchedule() {
		return schedule;
	}
	
	public char getGroupID() {
		return groupID;
	}
}
