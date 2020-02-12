package AmusementPark;

public interface RidesStation{
	public void setRideStartTime(int startTime);
	public void setRideEndTime(int endTime);
	public void updateCurrentTime();
	public void setRideRequirements(int age,int height,int weight);
	public boolean canPersonRide(Person person);
}
