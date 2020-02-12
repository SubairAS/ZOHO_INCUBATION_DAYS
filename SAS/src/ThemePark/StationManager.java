package ThemePark;

import java.time.*;
import java.util.ArrayList;
import java.util.Collections;

public class StationManager {
	private ArrayList<Visitor> ridersList = new ArrayList<Visitor>();
	private QueueHandler queueHandlerObj;
	private RidesStation ridesObj;
	private LocalTime nextRideTime;

	public StationManager(RidesStation ridesObj) {
		this.ridesObj = ridesObj;
		nextRideTime = ridesObj.getStartTime();
		queueHandlerObj = new QueueHandler(ridesObj);
	}

	public void ride() {
		System.out.println("Current ride : " + ridesObj.getRideName() + " at " + nextRideTime);

		Collections.sort(ridersList, (visitor1, visitor2) -> {
			return ((visitor1.getTicket().getPriority() < visitor1.getTicket().getPriority()) ? 1 : -1);
		});

		ArrayList<Visitor> validRidersList = queueHandlerObj.queueArrangement(ridersList);

		System.out.println("Riders are :");
		for (Visitor currentRider : validRidersList) {
			System.out.print(currentRider.getId() + " ");
			currentRider.updateFreeTime(LocalTime.now().plusMinutes(ridesObj.getSingleRideTime().getMinute()));
		}

		nextRideTime = nextRideTime.plusMinutes(ridesObj.getSingleRideTime().getMinute());
		if (nextRideTime.getHour() == (ridesObj.getEndTime().getHour())
				&& nextRideTime.getMinute() == (ridesObj.getEndTime().getMinute())) {
			nextRideTime = ridesObj.getStartTime();
		}
	}

	public void addRider(Visitor visitor) {
		ridersList.add(visitor);
	}

	public LocalTime getNextRideTime() {
		return nextRideTime;
	}

	public String getRideName() {
		return ridesObj.getRideName();
	}

	public LocalTime getEndTime() {
		return ridesObj.getEndTime();
	}
}
