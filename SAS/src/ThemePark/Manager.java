package ThemePark;

import java.time.LocalTime;
import java.util.ArrayList;

public class Manager {
	public static void themeParkManagement() {
		while (LocalTime.now().isAfter(LocalTime.of(8, 00)) && LocalTime.now().isBefore(LocalTime.of(20, 0))) {
			RidesReservation.reservationHelper();
			ridesStarter();
		}
	}

	private static void ridesStarter() {
		ArrayList<StationManager> currentRidesList = RidesManagerDataBase.getCurrentRides();
		if (currentRidesList.size() != 0) {
			for (StationManager currentRide : currentRidesList) {
				currentRide.ride();
			}
		}
	}
}
