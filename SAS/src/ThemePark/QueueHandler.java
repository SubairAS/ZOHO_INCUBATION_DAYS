package ThemePark;

import java.time.LocalTime;
import java.util.ArrayList;

public class QueueHandler {
	private RidesStation ridesObj;

	public QueueHandler(RidesStation ridesObj) {
		this.ridesObj = ridesObj;
	}

	public ArrayList<Visitor> queueArrangement(ArrayList<Visitor> ridersList) {
		ridesObj.resetAvailableSpace();
		ArrayList<Visitor> validRidersList = new ArrayList<Visitor>();
		for (int i = 0; i < ridersList.size() && !ridesObj.isFull(); i++) {
			Visitor currentVisitor = ridersList.get(i);
			if (ridesObj.canVisitorRide(currentVisitor)) {
				ridersList.remove(currentVisitor);
				validRidersList.add(currentVisitor);
				ridesObj.updateAvailableSpace();
			} else {
				ridersList.remove(currentVisitor);
				currentVisitor.updateFreeTime(LocalTime.now());
			}
		}
		return validRidersList;
	}
}
