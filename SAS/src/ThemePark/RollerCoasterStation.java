package ThemePark;

import java.time.LocalTime;

public class RollerCoasterStation extends RidesStation {
	private int age = 15, height = 150, weight = 60, maxCapacity = 2;
	private LocalTime startTime = LocalTime.of(8, 00), endTime = LocalTime.of(10, 00),
			singleRideTime = LocalTime.of(0, 2);

	public RollerCoasterStation() {
		super.setMaxCapacity(this.maxCapacity);
		super.setStartTime(this.startTime);
		super.setEndTime(this.endTime);
		super.setSingleRideTime(this.singleRideTime);
		super.setRideName("Roller Coaster");
	}

	public RollerCoasterStation(int maxCapacity) {
		this();
		super.setMaxCapacity(this.maxCapacity = maxCapacity);
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setStartTime(LocalTime startTime) {
		super.setStartTime(this.startTime = startTime);
	}

	public void setEndTime(LocalTime endTime) {
		super.setEndTime(this.endTime = endTime);
	}

	public void setSingleRideTime(LocalTime singleRideTime) {
		super.setSingleRideTime(this.singleRideTime = singleRideTime);
	}

	public void setMaxCapacity(int maxCapacity) {
		super.setMaxCapacity(this.maxCapacity = maxCapacity);
	}

	public boolean canVisitorRide(Visitor currentVisitor) {
		if (age <= currentVisitor.getAge() && height <= currentVisitor.getHeight()
				&& weight >= currentVisitor.getWeight()) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Ride Name : " + getRideName() + "\nRide Start Time : " + getStartTime() + " || Ride End Time : "
				+ getEndTime() + " || Ride Single Ride Time : " + getSingleRideTime() + "\nMaximumCapacity : "
				+ getMaxCapacity() + " || Available Space : " + getAvailableSpace() + "\nMin age alloted : " + age
				+ " || Min Height Alloted : " + height + " || Min Weight Alloted : " + weight;
	}
}
