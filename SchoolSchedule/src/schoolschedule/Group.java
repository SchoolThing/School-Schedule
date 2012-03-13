package schoolschedule;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private List<Subject> subjects;
	private char groupID;

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

	public void setSubjects(List<Subject> subs) {
		this.subjects = (List<Subject>) new ArrayList<Subject>(subs);
	}

	public void setSubject(int index, Subject sub) {
		subjects.set(index, sub);
	}

	public void printID() {
		System.out.print(groupID + "\t\t	");
	}

	public void printGroupSubject(int index) {
		Subject tmpSub = subjects.get(index);
		tmpSub.print();
	}
}
