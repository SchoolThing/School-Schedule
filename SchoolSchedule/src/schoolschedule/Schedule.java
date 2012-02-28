package schoolschedule;

import java.util.List;

public class Schedule {

	List<SchoolClass> classes;
	
	public Schedule(List<SchoolClass> classes){
		this.classes=classes;
	}
	
	public List<SchoolClass> getClasses() {
		return classes;
	}
	public void setClasses(List<SchoolClass> classes) {
		this.classes = classes;
	}
		
	public void print(){
		//TODO make print
	}

	public void generate() {
		
	}

}
