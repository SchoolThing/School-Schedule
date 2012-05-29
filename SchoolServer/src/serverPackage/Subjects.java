package serverPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clientPackage.ConflictOccuredException;
import clientPackage.Group;
import clientPackage.Schedule;
import clientPackage.School;
import clientPackage.SchoolClass;
import clientPackage.Subject;
import databasePackage.AbstConnect;
import databasePackage.SubjectConnect;

@WebServlet("/change-subjects")
public class Subjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void addSubjectsByDay(Schedule newSchedule, String[] day, int schoolDay){
		try
		{
		for (int i = 0; i < 10; i++) {
			try {
				if (day[i] != null) {
					if (day[i].length() > 0) {
						if (i < 8) {
							if (day[i].equals(day[i + 1])) {
								newSchedule.addSubject(new Subject(day[i],
										"Teacher", 0, i, i + 1, schoolDay));
								i++;
								if (day[i].equals(day[i + 1])) {
									throw new ConflictOccuredException();
								}
								
								continue;
							}
						}
						
						newSchedule.addSubject(new Subject(day[i],
								"Teacher", 0, i, i, schoolDay));

					}
				}
			} catch (ConflictOccuredException ex) {
				ex.printStackTrace();				
			}
		}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		try {
			int scheduleID = Integer
					.valueOf(request.getParameter("scheduleID"));
			String[] monday = request.getParameterValues("monday");
			String[] tuesday = request.getParameterValues("tuesday");
			String[] wednesday = request.getParameterValues("wednesday");
			String[] thursday = request.getParameterValues("thursday");
			String[] friday = request.getParameterValues("friday");

			StructureBuilder.buildStructure();
			
			AbstConnect
			.setDbURL("jdbc:derby:C:\\Users\\Lumnatiq\\Desktop\\db-derby-10.8.1.2-bin\\bin\\SchoolSchedule");
			AbstConnect.createConnection();
			
			Schedule newSchedule = new Schedule(scheduleID);
			
			List<SchoolClass> classes = School.getClasses();
			for (SchoolClass currentClass : classes) {
				List<Group> groups = currentClass.getClassGroups();
				for (Group currentGroup : groups) {
					Schedule schedule = currentGroup.getSchedule();
					
					List<Subject> subjects = schedule.getSubjects();

					for (Subject currentSubject : subjects) {
						SubjectConnect.deleteSubject(currentSubject.getID());
					}
					
					if (schedule.getID() == scheduleID) {
						currentGroup.setSchedule(newSchedule);
					}
				}
			}
			
			addSubjectsByDay(newSchedule, monday, 1);
			addSubjectsByDay(newSchedule, tuesday, 2);
			addSubjectsByDay(newSchedule, wednesday, 3);
			addSubjectsByDay(newSchedule, thursday, 4);
			addSubjectsByDay(newSchedule, friday, 5);
			
			List<Subject> newScheduleSubject = newSchedule.getSubjects();
			for(Subject currentNewSubject : newScheduleSubject)
			{
				SubjectConnect.insertSubject(currentNewSubject.getName(), currentNewSubject.getFrom(), currentNewSubject.getTo(), currentNewSubject.getDay(), 100, newSchedule.getID());
			}
			
			School.clear();
			AbstConnect.shutdown();

			response.sendRedirect("mainPage.jsp");
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
