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
				Group tmpGroup1 = tmpGrps.get(j);
				Group tmpGroup2 = tmpGrps.get(j + 1);

				List<Subject> subs = tmpGroup1.getSubjects();
				List<Subject> subs2 = tmpGroup2.getSubjects();

				Subject tmp = subs.get(i);
				Subject tmp2 = subs2.get(i);

				if (tmp == tmp2) {

					Subject tmp3 = subs2.get(i + 1);
					Subject tmp4 = tmp3;
					tmp3 = tmp2;
					tmp2 = tmp4;

					subs2.set(i, tmp2);
					subs2.set(i + 1, tmp3);

					tmpGroup2.setSubjects(subs2);
				}

				List<Group> tmpGrps2 = new ArrayList<Group>();
				tmpGrps2.add(tmpGroup1);
				tmpGrps2.add(tmpGroup2);

				scl.setClassGroups(tmpGrps2);

			}
		}
	}
}
