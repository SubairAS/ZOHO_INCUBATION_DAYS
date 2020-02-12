package ThemePark;

import java.time.LocalTime;

public class RollerCoasterStation extends RidesStation {
	private int age = 15, height = 150, weight = 60, maxCapacity = 20;
	private LocalTime startTime = LocalTime.of(15, 00), endTime = LocalTime.of(20, 00),
			singleRideTime = LocalTime.of(0, 30);

	public RollerCoasterStation() {
		super.setMaxCapacity(this.maxCapacity);
		super.setStartTime(this.startTime);
		super.setEndTime(this.endTime);
		super.setSingleRideTime(this.singleRideTime);
		super.setRideName("Roller Coaster");
	}

	public boolean canVisitorRide(Visitor currentVisitor) {
		if (age < currentVisitor.getAge() && height < currentVisitor.getHeight()
				&& weight > currentVisitor.getWeight()) {
			return true;
		}
		return false;
	}
}