package ThemePark;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	private static Scanner scanner = new Scanner(System.in);
	private static boolean canAdminMakeChange = true;

	public static void themeParkManagement() {
		TicketCounter.ticketVending();
		while (LocalTime.now().isBefore(LocalTime.of(20, 0))) {
			if (canAdminMakeChange) {
				checkAdmin(LocalTime.now());
			}
			if (RidesManagerDataBase.isThisRideTime()) {
				ridesStarter();
			}
			if (VisitorDataBase.isAnyVisitorsFree()) {
				RidesReservation.reservationHelper();
			}
		}
	}

	private static void ridesStarter() {
		ArrayList<StationManager> currentRidesList = RidesManagerDataBase.getCurrentRides();
		if (currentRidesList.size() != 0) {
			for (StationManager currentRide : currentRidesList) {
				currentRide.ride();
			}
			canAdminMakeChange = true;
		}
	}

	private static void checkAdmin(LocalTime time) {
		System.out.println("Admin Controls? 1 to enter");
		if (scanner.nextInt() == 1) {
			Admin.actionDecider();
		}
		canAdminMakeChange = false;
	}
}