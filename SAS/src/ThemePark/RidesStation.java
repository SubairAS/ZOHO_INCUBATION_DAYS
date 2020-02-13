package ThemePark;

import java.time.LocalTime;

public abstract class RidesStation {
	private LocalTime startTime, endTime, singleRideTime;
	private int maxCapacity, availableSpace;
	private String rideName;

	protected LocalTime getStartTime() {
		return startTime;
	}

	protected void resetAvailableSpace() {
		availableSpace = maxCapacity;
	}

	protected void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	protected LocalTime getEndTime() {
		return endTime;
	}

	protected void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	protected LocalTime getSingleRideTime() {
		return singleRideTime;
	}

	protected void setSingleRideTime(LocalTime singleRideTime) {
		this.singleRideTime = singleRideTime;
	}

	protected int getMaxCapacity() {
		return maxCapacity;
	}

	protected void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.availableSpace = maxCapacity;
	}

	public String getRideName() {
		return rideName;
	}

	public void setRideName(String rideName) {
		this.rideName = rideName;
	}

	protected boolean isFull() {
		if (availableSpace != 0) {
			return false;
		}
		return true;
	}

	protected void updateAvailableSpace() {
		availableSpace++;
	}

	abstract public boolean canVisitorRide(Visitor currentVisitor);
}
