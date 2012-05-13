package schedule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.ConflictOccuredException;

public class Schedule {

	private List<Subject> subjects;

	public Schedule() {
		super();
		this.subjects = new ArrayList<Subject>();
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void addSubject(Subject sub) throws ConflictOccuredException {
		boolean isValid = true;
		for (SchoolClass groupClass : School.getClasses()) {
			for (Group grp : groupClass.getClassGroups()) {
				List<Subject> grpSubjects = grp.getSchedule().getSubjects();
				for (Subject tmpSub : grpSubjects) {
					if (tmpSub.getDay() == sub.getDay()
							&& ((tmpSub.getFrom() >= sub.getFrom() && tmpSub
									.getFrom() <= sub.getTo()) || (tmpSub
									.getTo() <= sub.getTo() && tmpSub.getTo() >= sub
									.getFrom()))
							&& (tmpSub.getTeacher() == sub.getTeacher() || tmpSub
									.getRoom() == sub.getRoom())) {
						isValid = false;
					}
				}
			}
		}		
		if (isValid) {
			subjects.add(sub);
		} else {
			throw new ConflictOccuredException();
		}
	}
}
