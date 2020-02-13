package ThemePark;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	private static Scanner scanner = new Scanner(System.in);
	private static boolean canAdminMakeChange = true;

	public static void themeParkManagement() {
		ridesHandling();
		TicketCounter.ticketVending();
		while (LocalTime.now().isBefore(LocalTime.of(20, 0))) {
			if (canAdminMakeChange) {
				checkAdmin(LocalTime.now());
			}
			if (VisitorDataBase.isAnyVisitorsFree()) {
				RidesReservation.reservationHelper();
			}
		}
	}

	private static void ridesHandling() {
		Thread rideStarterThread = new Thread(() -> {
			ArrayList<StationManager> currentRidesList = RidesManagerDataBase.getCurrentRides();
			if (currentRidesList.size() != 0) {
				for (StationManager currentRide : currentRidesList) {
					currentRide.ride();
				}
				canAdminMakeChange = true;
			}
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		rideStarterThread.start();
	}

	private static void checkAdmin(LocalTime time) {
		System.out.println("Admin Controls? 1 to enter");
		if (scanner.nextInt() == 1) {
			Admin.actionDecider();
		}
		canAdminMakeChange = false;
	}
}