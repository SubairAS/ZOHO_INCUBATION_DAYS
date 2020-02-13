package ThemePark;

import java.time.LocalTime;
import java.util.ArrayList;

public class VisitorDataBase {
	private static ArrayList<Visitor> visitorsList = new ArrayList<Visitor>();

	public static void addVisitor(Visitor visitor) {

		visitorsList.add(visitor);
	}

	public static ArrayList<Visitor> getVisitorsList() {
		return visitorsList;
	}

//	public static Visitor getVisitors(int id) {
//		for (Visitor current : visitorsList) {
//			if (id == current.getId()) {
//				return current;
//			}
//		}
//		return null;
//	}
	public static boolean isAnyVisitorsFree() {
		for (Visitor currentVisitor : visitorsList) {
			if (currentVisitor.getFreeTime().getHour() == (LocalTime.now().getHour())
					&& currentVisitor.getFreeTime().getMinute() == (LocalTime.now().getMinute())) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Visitor> getVisitorsListAtTime() {
		ArrayList<Visitor> currentVisitorsList = new ArrayList<Visitor>();
		for (Visitor currentVisitor : visitorsList) {
			if (currentVisitor.getFreeTime().getHour() == (LocalTime.now().getHour())
					&& currentVisitor.getFreeTime().getMinute() == (LocalTime.now().getMinute())) {
				currentVisitorsList.add(currentVisitor);
			}
		}
		return currentVisitorsList;
	}
}
