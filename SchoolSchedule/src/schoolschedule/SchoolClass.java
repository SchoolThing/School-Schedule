package schoolschedule;

import java.util.ArrayList;
import java.util.List;


public class SchoolClass {

	private static int classNumber;
	private static List<Group> classGroups;

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
	
	public List<Subject> getClassSchedule() {
		List<Subject> res = new ArrayList<Subject>();
		
		res = classGroups.get(0).getSubjects();
		
		return res; 
	}

	public static void print() {
		System.out.println(classNumber);
		for(Group tmpGroup:classGroups){
			tmpGroup.print();
		}
		
	}

}
