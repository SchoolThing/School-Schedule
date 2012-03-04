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

	public void generate(SchoolClass scl, List<Subject> sub) {

		for (int i = 0; i < scl.getClassGroups().size(); i++) {
			scl.getClassGroups().get(i).setSubjects(sub);
		}

		List<Group> tmpGrps = new ArrayList<Group>(scl.getClassGroups());

		for (int i = 0; i < sub.size() - 1; i++) {
			for (int j = 0; j < tmpGrps.size() - 1; j++) {
				if (tmpGrps.get(j).getSubjects().get(i) == tmpGrps.get(j + 1)
						.getSubjects().get(i)) {
					Subject tmp = tmpGrps.get(j + 1).getSubjects().get(i);
					Subject tmp2 = tmpGrps.get(j + 1).getSubjects().get(i + 1);
					tmpGrps.get(j + 1).setSubject(i, tmp2);
					tmpGrps.get(j + 1).setSubject(i + 1, tmp);
				}

			}
		}
		scl.setClassGroups(tmpGrps);
	}

}
