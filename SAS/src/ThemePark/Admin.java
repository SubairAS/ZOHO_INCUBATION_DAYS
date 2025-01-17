package ThemePark;

import java.time.LocalTime;
import java.util.*;

public class Admin {
	private static Scanner sc = new Scanner(System.in);

	public static void actionDecider() {
		adminlabel: {
			while (true) {
				label: {
					while (true) {
						System.out.println("1.Add new rider(s)\n2.Add new Ride?\n"
								+ "3.Check - Revenue for the day\n4.Rides Details\n" + "5.Configure Rides\n6.Exit");
						int selection = sc.nextInt();
						switch (selection) {
						case 1:
							addNewRider();
							break label;
						case 2:
							addRide();
							break label;
						case 3:
							checkRevenue();
							break label;
						case 4:
							getRidesDetails();
							break label;
						case 5:
							configureRides();
							break label;
						case 6:
							break adminlabel;
						default:
							System.out.println("Invalid Selection");
						}
					}
				}
			}
		}
	}

	private static void configureRides() {
		ArrayList<StationManager> managersList = RidesManagerDataBase.getManagersList();
		System.out.println("Which ride you want to configure?");
		for (StationManager currentManager : managersList) {
			System.out.println("Enter " + managersList.indexOf(currentManager) + " for " + currentManager.getRideName());
		}
		int selection = sc.nextInt();
		StationManager selectedRide = managersList.get(selection);
		selectedRide.configureThisRide();
	}

	private static void addNewRider() {
		System.out.println("How many riders?");
		int newRidersSize = sc.nextInt();
		for (int i = 0; i < newRidersSize; i++) {
			TicketCounter.ticketVending();
		}
	}

	private static void getRidesDetails() {
		ArrayList<StationManager> managersList = RidesManagerDataBase.getManagersList();
		for (StationManager currentManager : managersList) {
			System.out.println(currentManager + "\n");
		}
	}

	private static void checkRevenue() {
		System.out.println("1.Ticket Counter\n2.Canteen\n3.Overall");
		switch (sc.nextInt()) {
		case 1:
			System.out.println(TicketCounter.getRevenue());
			break;
		case 2:
			System.out.println(Canteen.getRevenue());
			break;
		case 3:
			System.out.println("Counter Revenue " + TicketCounter.getRevenue() + "\nCanteen Revenue "
					+ Canteen.getRevenue() + "\nTotal Revenue " + (Canteen.getRevenue() + TicketCounter.getRevenue()));
			break;
		}
	}

	private static void addRide() {
		System.out.println("1.RollerCoaster Station\n2.FlashTower Station\n3.New Station");
		int selection = sc.nextInt();
		System.out.println("Max Capacity?");
		int maxCapacity = sc.nextInt();
		switch (selection) {
		case 1:
			RidesManagerDataBase.addNewRide(new RollerCoasterStation(maxCapacity));
			break;
		case 2:
			RidesManagerDataBase.addNewRide(new FlashTowerStation(maxCapacity));
			break;
		case 3:
			label:{
			while(true) {
			sc.nextLine();
			System.out.println("Ride Name?");
			String rideName = sc.nextLine();
			System.out.println("Min age alloted");
			int age = sc.nextInt();
			System.out.println("Min height alloted");
			int height = sc.nextInt();
			System.out.println("Max weight alloted");
			int weight = sc.nextInt();
			System.out.println("Start time? eg: for 1PM - 1300");
			int startTime = sc.nextInt();
			System.out.println("End Time?");
			int endTime = sc.nextInt();
			System.out.println("Single Ride Time?");
			int singleRideTime = sc.nextInt();
			try {
			RidesManagerDataBase.addNewRide(new NewStation.NewStationBuilder().setAge(age).setHeight(height)
					.setStartTime(LocalTime.of(startTime / 100, startTime % 100))
					.setEndTime(LocalTime.of(endTime / 100, endTime % 100))
					.setSingleRideTime(LocalTime.of(singleRideTime / 100, singleRideTime % 100)).setWeight(weight)
					.setMaxCapacity(maxCapacity).setRideName(rideName).getNewStationInstance());
			System.out.println("New Ride " + rideName + "added");
			break label;
			}
			catch(Exception e){
				System.out.println("Invalid Time Input! Try Again!");
			}
			}
		}
		break;
		}
	}
}
