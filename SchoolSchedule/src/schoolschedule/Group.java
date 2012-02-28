package schoolschedule;

import java.util.List;

public class Group {
	private char groupID;
	private List<Subject> subjects;

	public Group(char groupID, List<Subject> subjects) {
		super();
		this.groupID = groupID;
		this.subjects = subjects;
	}

	public char getGroupID() {
		return groupID;
	}

	public void setGroupID(char groupID) {
		this.groupID = groupID;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}
