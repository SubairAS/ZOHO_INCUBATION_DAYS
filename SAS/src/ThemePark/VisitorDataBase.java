package ThemePark;

import java.util.ArrayList;

public class VisitorDataBase {
	private static ArrayList<Visitor> visitorsList = new ArrayList<Visitor>();

	public static void addVisitor(Visitor visitor) {

		visitorsList.add(visitor);
	}

	public static ArrayList<Visitor> getVisitorsList() {
		return visitorsList;
	}
}
