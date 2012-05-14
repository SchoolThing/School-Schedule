package clientPackage;

import java.util.ArrayList;
import java.util.List;

public class School {
	private static List<SchoolClass> classes = new ArrayList<SchoolClass>();

	public static void addClass(SchoolClass scl){
		classes.add(scl);
	}

	public static List<SchoolClass> getClasses() {
		return classes;
	}
}