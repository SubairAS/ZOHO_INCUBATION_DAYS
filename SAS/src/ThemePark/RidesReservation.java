package ThemePark;

import java.time.*;
import java.util.*;

public class RidesReservation {
	private static Scanner sc = new Scanner(System.in);;

	public static void reservationHelper() {
		ArrayList<Visitor> temporaryVisitorsList = getVisitorsListAtTime();
		for (Visitor currentVisitor : temporaryVisitorsList) {
			ridesBooking(currentVisitor);
		}
	}

	private static ArrayList<Visitor> getVisitorsListAtTime() {
		ArrayList<Visitor> visitorsList = VisitorDataBase.getVisitorsList();
		ArrayList<Visitor> currentVisitorsList = new ArrayList<Visitor>();
		for (Visitor currentVisitor : visitorsList) {
			if (currentVisitor.getFreeTime().getHour() == (LocalTime.now().getHour())
					&& (currentVisitor.getFreeTime().getMinute() == (LocalTime.now().getMinute()) || currentVisitor
							.getFreeTime().getMinute() == (LocalTime.now().plusMinutes(1).getMinute()))) {
				currentVisitorsList.add(currentVisitor);
			}
		}
		return currentVisitorsList;
	}

	private static void ridesBooking(Visitor currentVisitor) {
		System.out.println("Customer ID :" + currentVisitor.getId());
		if (currentVisitor.getTicket().getTime().isBefore(LocalTime.now())) {
			ArrayList<StationManager> managersList = RidesManagerDataBase.getManagersList();
			boolean[] availableRidesCheck = new boolean[managersList.size()];
			for (StationManager currentManager : managersList) {
				if (LocalTime.now().isBefore(currentManager.getNextRideTime())) {
					System.out.println("Enter " + (managersList.indexOf(currentManager)) + " for "
							+ currentManager.getRideName() + " at " + currentManager.getNextRideTime()
							+ " available space " + currentManager.availableSpace());
					availableRidesCheck[managersList.indexOf(currentManager)] = true;
				}
			}
			System.out.println(managersList.size() + " Canteen");
			System.out.println(managersList.size() + 1 + " No plans");
			int selection = sc.nextInt();
			tempLabel: {
				while (true) {
					if (selection >= managersList.size() && selection <= managersList.size() + 1) {
						break tempLabel;
					} else if (selection < managersList.size() && availableRidesCheck[selection]) {
						break tempLabel;
					} else {
						System.out.println("Invalid Selection. Try Again!");
						selection = sc.nextInt();
					}
				}
			}
			if (selection <= managersList.size() + 1) {
				if (selection <= managersList.size()) {
					StationManager selectedRide = managersList.get(selection);
					selectedRide.addRider(currentVisitor);
					currentVisitor.updateFreeTime(selectedRide.getEndTime());
					System.out.println("Ride booked! Go to " + selectedRide.getRideName() + " Station");
				}
				if (selection == managersList.size()) {
					Canteen.shopCounter(currentVisitor);
				}
				if (selection == managersList.size() + 1) {
					System.out.println("for? (in minutes)");
					int tempTime = sc.nextInt();
					currentVisitor.updateFreeTime(currentVisitor.getFreeTime().plusMinutes(tempTime));
				}
			}
		} else {
			System.out.println("You cant book rides now");
		}
	}
}