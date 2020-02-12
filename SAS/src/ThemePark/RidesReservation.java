package ThemePark;

import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RidesReservation {
	private static Scanner sc = new Scanner(System.in);;

	public static void reservationHelper() {
		ArrayList<Visitor> temporaryVisitorsList = VisitorDataBase.getVisitorsListAtTime();
		for (Visitor currentVisitor : temporaryVisitorsList) {
			RidesReservation.ridesBooking(currentVisitor);
		}
	}

	private static void ridesBooking(Visitor currentVisitor) {
		System.out.println("Customer ID :" + currentVisitor.getId());
		if (currentVisitor.getTicket().getTime().isBefore(LocalTime.now())) {
			int selection = getSelection(currentVisitor);
			if (selection <= RidesManagerDataBase.noOfRides()) {
				StationManager selectedRide = RidesManagerDataBase.getStationManagerOf(String.valueOf(selection));
				selectedRide.addRider(currentVisitor);
				currentVisitor.updateFreeTime(selectedRide.getEndTime());
				System.out.println("Ride booked! Go to " + selectedRide.getRideName() + " Station");
			}
			if (selection == RidesManagerDataBase.noOfRides() + 1) {
				Canteen.shopCounter(currentVisitor);
			}
		} else {
			System.out.println("You cant book rides now");
		}
	}

	private static int getSelection(Visitor currentVisitor) {
		HashMap<Integer, StationManager> availableRidesList = RidesManagerDataBase.getAvailableRides();
		int index = 1;
		for (Map.Entry<Integer, StationManager> entry : availableRidesList.entrySet()) {
			if (currentVisitor.getFreeTime().isBefore(entry.getValue().getNextRideTime())) {
				System.out.println(entry.getKey() + " " + entry.getValue().getRideName() + " at "
						+ entry.getValue().getNextRideTime());
			}
			index++;
		}
		System.out.println(index + " Canteen");
		int selection = sc.nextInt();
		return selection;
	}
}