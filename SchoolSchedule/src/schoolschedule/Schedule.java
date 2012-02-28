package schoolschedule;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

	List<SchoolClass> classes;

	public Schedule(List<SchoolClass> classes) {
		this.classes = classes;
	}

	public List<SchoolClass> getClasses() {
		return classes;
	}

	public void setClasses(List<SchoolClass> classes) {
		this.classes = classes;
	}

	public void printClasses() {
		for (SchoolClass tmpClass : classes) {
			tmpClass.print();
		}
	}

	public void print() {
		printClasses();
	}

	public void generate(List<Subject> sub) {
		int daySize = sub.size() / 5;
		int indexReached=0;
		
		List<Subject> monday = new ArrayList<Subject>();
		List<Subject> tuesday= new ArrayList<Subject>();
		List<Subject> wednesday= new ArrayList<Subject>();
		List<Subject> thursday= new ArrayList<Subject>();
		List<Subject> friday= new ArrayList<Subject>();
		for(int i=0; i<daySize; i++){
			monday.add(sub.get(indexReached));
			tuesday.add(sub.get(indexReached+2));
			wednesday.add(sub.get(indexReached+4));
			thursday.add(sub.get(indexReached+6));
			friday.add(sub.get(indexReached+8));
		}
		
	}

}
