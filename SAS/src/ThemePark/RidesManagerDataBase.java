package ThemePark;

import java.util.ArrayList;

public class RidesManagerDataBase {
	private static ArrayList<StationManager> managersList = new ArrayList<StationManager>();

	static {
		managersList.add(new StationManager(new RollerCoasterStation()));
		managersList.add(new StationManager(new FlashTowerStation()));
	}

	public static ArrayList<StationManager> getManagersList() {
		return managersList;
	}

	public static void addNewRide(RidesStation newRidesObj) {
		managersList.add(new StationManager(newRidesObj));
	}

	// this code just for test
	public static void view() {
		for (StationManager x : managersList) {
			System.out.println("                           " + x.getRideName() + " " + x.getNextRideTime().toString());
		}
	}
}
