package schoolschedule;

import java.util.List;

public class Group {
	
	private List<Subject> subjects;
	private static char groupID;
	
	public Group(char groupID, List<Subject> subjects) {
		super();
		this.groupID = groupID;
		this.subjects = subjects;
	}
	
	public static char getGroupID() {
		return groupID;
	}
	
	public static void setGroupID(char groupID) {
		Group.groupID = groupID;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public static void print() {
		System.out.println(groupID);
		
	}
}
