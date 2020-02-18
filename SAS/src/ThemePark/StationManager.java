package ThemePark;

import java.time.*;
import java.util.*;

public class StationManager {
	private ArrayList<Visitor> ridersList = new ArrayList<Visitor>();
	private QueueHandler queueHandlerObj;
	private RidesStation ridesObj;
	private LocalTime nextRideTime;
	private Scanner sc = new Scanner(System.in);

	public StationManager(RidesStation ridesObj) {
		this.ridesObj = ridesObj;
		nextRideTime = ridesObj.getStartTime();
		queueHandlerObj = new QueueHandler(ridesObj);
		if (nextRideTime.isBefore(LocalTime.now())) {
			nextRideTimeInitializer();
		}
	}

	public void ride() {
		System.out.print("\nCurrent ride : " + ridesObj.getRideName() + " at " + nextRideTime);
		setNextRideTime();
		if (ridersList.isEmpty()) {
			System.out.print(" is cancelled");
			return;
		}
		sortByPriority();

		ArrayList<Visitor> validRidersList = queueHandlerObj.queueArrangement(ridersList);

		System.out.println("\nRiders are :");
		for (Visitor currentRider : validRidersList) {
			System.out.print(currentRider.getId() + " ");
			currentRider.updateFreeTime(LocalTime.now().plusMinutes(ridesObj.getSingleRideTime().getMinute()));
		}
		System.out.println();
	}

	private void sortByPriority() {
		Collections.sort(ridersList, (visitor1, visitor2) -> {
			return ((visitor1.getTicket().getPriority() < visitor1.getTicket().getPriority()) ? 1 : -1);
		});

	}

	private void setNextRideTime() {
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

	public int availableSpace() {
		return ridesObj.getAvailableSpace();
	}

	public void configureThisRide() {
		configureLabel: {
			System.out.println("1.Maximum Capacity\n2.Min Age Alloted\n3.Min Height Alloted\n"
					+ "4.Max Weight Alloted\n5.Start Time\n6.End Time\n7.Single Ride Time\n8.Exit");
			int selection = sc.nextInt();
			selectionLabel: {
				switch (selection) {
				case 1:
					System.out.println("Enter New Capacity!");
					int newCapacity = sc.nextInt();
					ridesObj.setMaxCapacity(newCapacity);
					break selectionLabel;
				case 2:
					System.out.println("Enter restrictions for age!");
					int newAge = sc.nextInt();
					ridesObj.setAge(newAge);
					break selectionLabel;
				case 3:
					System.out.println("Enter restrictions for height!");
					int newHeight = sc.nextInt();
					ridesObj.setHeight(newHeight);
					break selectionLabel;
				case 4:
					System.out.println("Enter restrictions for weight!");
					int newWeight = sc.nextInt();
					ridesObj.setWeight(newWeight);
					break selectionLabel;
				case 5:
					System.out.println("Enter start time!");
					while(true) {
					try {
						int time=sc.nextInt();
						LocalTime startTime=LocalTime.of(time/100,time%100);
						ridesObj.setStartTime(startTime);
						break selectionLabel;
					}
					catch(Exception e) {
						System.out.println("Invalid Time Input! Try Again!");
					}
					}
				case 6:
					System.out.println("Enter end time!");
					while(true) {
					try {
						int time=sc.nextInt();
						LocalTime endTime=LocalTime.of(time/100,time%100);
						ridesObj.setStartTime(endTime);
						break selectionLabel;
					}
					catch(Exception e) {
						System.out.println("Invalid Time Input! Try Again!");
					}
					}
				case 7:
					System.out.println("Enter single ride time!");
					while(true) {
					try {
						int time=sc.nextInt();
						LocalTime singleRideTime=LocalTime.of(time/100,time%100);
						ridesObj.setStartTime(singleRideTime);
						break selectionLabel;
					}
					catch(Exception e) {
						System.out.println("Invalid Time Input! Try Again!");
					}
					}
				case 8:
					break configureLabel;
				}
			}
		}

	}

	private void nextRideTimeInitializer() {
		while (nextRideTime.isBefore(LocalTime.now()) && (nextRideTime
				.plusMinutes(ridesObj.getSingleRideTime().getMinute()).isBefore(ridesObj.getEndTime()))) {
			nextRideTime = nextRideTime.plusMinutes(ridesObj.getSingleRideTime().getMinute());

		}
	}

	public String toString() {
		return ridesObj.toString() + "\n and Next Ride Time :" + nextRideTime;
	}
}
