package ThemePark;

import java.time.LocalTime;

public class FlashTowerStation extends RidesStation {
	private int age = 12, height = 100, maxCapacity = 10;
	private LocalTime startTime = LocalTime.of(16,00), endTime = LocalTime.of(18, 00),
			singleRideTime = LocalTime.of(0, 20);

	public FlashTowerStation() {
		super.setMaxCapacity(this.maxCapacity);
		super.setStartTime(this.startTime);
		super.setEndTime(this.endTime);
		super.setSingleRideTime(this.singleRideTime);
		super.setRideName("Flash Tower");
	}

	public boolean canVisitorRide(Visitor currentVisitor) {
		if (age < currentVisitor.getAge() && height < currentVisitor.getHeight()) {
			return true;
		}
		return false;
	}
}
