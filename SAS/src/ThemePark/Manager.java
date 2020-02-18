package ThemePark;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	private static Scanner scanner = new Scanner(System.in);
	private static boolean canAdminMakeChange = true;

	public static void themeParkManagement() {
		ridesHandling();
		while (LocalTime.now().isBefore(LocalTime.of(20, 0))) {
				RidesReservation.reservationHelper();
			if (canAdminMakeChange) {
				checkAdmin(LocalTime.now());
			}
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
			}
		}
	}

	private static void ridesHandling() {
		Thread rideStarterThread = new Thread(() -> {
			while (LocalTime.now().isBefore(LocalTime.of(20, 0))) {
				ArrayList<StationManager> currentRidesList = getCurrentRides();
				if (currentRidesList.size() != 0) {
					for (StationManager currentRide : currentRidesList) {
						currentRide.ride();
					}
					canAdminMakeChange = true;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		rideStarterThread.start();
	}
	
	private static ArrayList<StationManager> getCurrentRides() {
		ArrayList<StationManager> managersList=RidesManagerDataBase.getManagersList();
		ArrayList<StationManager> currentRidesList = new ArrayList<StationManager>();
		for (StationManager current : managersList) {
			if (current.getNextRideTime().getHour() == (LocalTime.now().getHour())
					&& current.getNextRideTime().getMinute() == (LocalTime.now().getMinute())) {
				currentRidesList.add(current);
			}
		}
		return currentRidesList;
	}
	private static void checkAdmin(LocalTime time) {
		System.out.println("\nAdmin Controls? 1 to enter");
		if (scanner.nextInt() == 1) {
			Admin.actionDecider();
		}
		canAdminMakeChange = false;
	}
}