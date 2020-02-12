package AmusementPark;

public class RollerCoasterStation implements RidesStation {
	private int minAge = 12, minHeight = 150, maxWeight = 70;
	private int startTime = 900, endTime = 1100, rideTime = 30;
	private static int currentTime = 900;
	Rides ridesObj = new Rides();

	@Override
	public void setRideStartTime(int startTime) {
		this.startTime = startTime;
	}

	@Override
	public void setRideEndTime(int endTime) {
		this.endTime = endTime;
	}

	public void getCurrentTime(int startTime) {
		this.startTime = startTime;
	}

	@Override
	public void updateCurrentTime() {
		RollerCoasterStation.currentTime += rideTime;
	}

	@Override
	public void setRideRequirements(int age, int height, int weight) {
		minAge = age;
		minHeight = height;
		maxWeight = weight;
	}

	@Override
	public boolean canPersonRide(Person person) {
		if (person.getAge() >= minAge && person.getHeight() >= minHeight && person.getWeight() <= maxWeight) {
			return true;
		}
		return false;
	}

}
