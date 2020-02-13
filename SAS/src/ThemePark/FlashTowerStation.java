package ThemePark;

import java.time.LocalTime;

public class FlashTowerStation extends RidesStation {
	private int age = 12, height = 100, maxCapacity = 10;
	private LocalTime startTime = LocalTime.of(8,0), endTime = LocalTime.of(20, 00),
			singleRideTime = LocalTime.of(0, 1);

	public FlashTowerStation() {
		super.setMaxCapacity(this.maxCapacity);
		super.setStartTime(this.startTime);
		super.setEndTime(this.endTime);
		super.setSingleRideTime(this.singleRideTime);
		super.setRideName("Flash Tower");
	}

	public FlashTowerStation(int maxCapacity) {
		this();
		super.setMaxCapacity(this.maxCapacity = maxCapacity);
	}

	public boolean canVisitorRide(Visitor currentVisitor) {
		if (age < currentVisitor.getAge() && height < currentVisitor.getHeight()) {
			return true;
		}
		return false;
	}
}
