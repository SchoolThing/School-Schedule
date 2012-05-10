package clientPackage;

import java.util.ArrayList;
import java.util.List;



public class SchoolClass {

	private int classNumber;
	private List<Group> classGroups;

	public SchoolClass() {
		super();
		this.classNumber = 0;
		this.classGroups = new ArrayList<Group>();
	}

	public SchoolClass(int classNumber, List<Group> classGroups) {
		super();
		this.classNumber = classNumber;
		this.classGroups = classGroups;
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
	
	public void setGroupSubject(Subject sub, int i, int index){
		classGroups.get(i).setSubject(index, sub);
	}

	public List<Subject> getClassSchedule() {
		List<Subject> res = new ArrayList<Subject>();

		res = classGroups.get(0).getSubjects();

		return res;
	}

	public void setGroupSchedule(List<Subject> sub, int index) {
		classGroups.get(index - 1).setSubjects(sub);
	}

	public void print() {
		List<Group> tmpGrps = new ArrayList<Group>();
		System.out.println("\t\t\t     " + classNumber + "\t" + "\n");
		for (Group tmpGroup : classGroups) {
			tmpGroup.printID();
			tmpGrps.add(tmpGroup);
		}	
		for(int i=0; i<tmpGrps.get(0).getSubjects().size(); i++){
			System.out.println();
			for(int j=0; j < tmpGrps.size(); j++){
				tmpGrps.get(j).printGroupSubject(i);
			}
		}
	}


}