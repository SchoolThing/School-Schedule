package schedule;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {

	private int classNumber;
	private List<Group> classGroups;

	public SchoolClass(int classNumber) {
		super();
		this.classNumber = classNumber;
		this.classGroups = new ArrayList<Group>();
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public List<Group> getClassGroups() {
		return classGroups;
	}

	public void setClassGroups(List<Group> classGroups) {
		this.classGroups = classGroups;
	}

	public void addGroup(Group group) {
		classGroups.add(group);
	}

	public Group getGroup(char c){
		for(Group tmpGrp : classGroups){
			if(tmpGrp.getGroupID() == c){
				return tmpGrp;
			}
		}
		return null;
	}
}
