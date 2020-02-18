package ThemePark;

import java.time.LocalTime;

public class NewStation extends RidesStation {
	private int age, height, weight;

	public NewStation(int age, int height, int weight, int maxCapacity, LocalTime startTime, LocalTime endTime,
			LocalTime singleRideTime, String rideName) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		super.setMaxCapacity(maxCapacity);
		super.setStartTime(startTime);
		super.setEndTime(endTime);
		super.setSingleRideTime(singleRideTime);
		super.setRideName(rideName);
	}

	public void setStartTime(LocalTime startTime) {
		super.setStartTime(startTime);
	}

	public void setEndTime(LocalTime endTime) {
		super.setEndTime(endTime);
	}

	public void setSingleRideTime(LocalTime singleRideTime) {
		super.setSingleRideTime(singleRideTime);
	}

	public void setMaxCapacity(int maxCapacity) {
		super.setMaxCapacity(maxCapacity);
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

	public boolean canVisitorRide(Visitor currentVisitor) {
		if (age < currentVisitor.getAge() && height < currentVisitor.getHeight()
				&& weight > currentVisitor.getWeight()) {
			return true;
		}
		return false;
	}

	public static class NewStationBuilder {
		private int age, height, weight, maxCapacity;
		private LocalTime startTime, endTime, singleRideTime;
		private String rideName;

		public NewStationBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public NewStationBuilder setHeight(int height) {
			this.height = height;
			return this;
		}

		public NewStationBuilder setWeight(int weight) {
			this.weight = weight;
			return this;
		}

		public NewStationBuilder setMaxCapacity(int maxCapacity) {
			this.maxCapacity = maxCapacity;
			return this;
		}

		public NewStationBuilder setStartTime(LocalTime startTime) {
			this.startTime = startTime;
			return this;
		}

		public NewStationBuilder setEndTime(LocalTime endTime) {
			this.endTime = endTime;
			return this;
		}

		public NewStationBuilder setSingleRideTime(LocalTime singleRideTime) {
			this.singleRideTime = singleRideTime;
			return this;
		}

		public NewStationBuilder setRideName(String rideName) {
			this.rideName = rideName;
			return this;
		}

		public NewStation getNewStationInstance() {
			return new NewStation(age, height, weight, maxCapacity, startTime, endTime, singleRideTime, rideName);
		}
	}

	public String toString() {
		return "Ride Name : " + getRideName() + "\nRide Start Time : " + getStartTime() + " || Ride End Time : "
				+ getEndTime() + " || Ride Single Ride Time : " + getSingleRideTime() + "\nMaximumCapacity : "
				+ getMaxCapacity() + " || Available Space : " + getAvailableSpace() + "\nMin age alloted : " + age
				+ " || Min Height Alloted : " + height + " || Min Weight Alloted : " + weight;
	}
}
