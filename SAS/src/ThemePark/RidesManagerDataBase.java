package ThemePark;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class RidesManagerDataBase {
	private static ArrayList<StationManager> managersList = new ArrayList<StationManager>();

	static {
		managersList.add(new StationManager(new RollerCoasterStation()));
		managersList.add(new StationManager(new FlashTowerStation()));
	}

	public static StationManager getStationManagerOf(String selection) {
		if (selection.equals("ROLLER COASTER") || selection.equals("1")) {
			return managersList.get(0);
		}
		if (selection.equals("FLASH TOWER") || selection.equals("2")) {
			return managersList.get(1);
		}
		return null;
	}

	public static boolean isThisRideTime() {
		for (StationManager current : managersList) {
			if (current.getNextRideTime().getHour() == (LocalTime.now().getHour())
					&& current.getNextRideTime().getMinute() == (LocalTime.now().getMinute())) {
				return true;
			}
		}
		return false;
	}

	public static HashMap<Integer, StationManager> getAvailableRides() {
		HashMap<Integer, StationManager> temporaryList = new HashMap<Integer, StationManager>();
		int index = 1;
		for (StationManager current : managersList) {
			if (LocalTime.now().isBefore(current.getNextRideTime())) {
				temporaryList.put(index++, current);
			}
		}
		return temporaryList;
	}

	public static ArrayList<StationManager> getCurrentRides() {
		ArrayList<StationManager> temporaryList = new ArrayList<StationManager>();
		for (StationManager current : managersList) {
			if (current.getNextRideTime().getHour() == (LocalTime.now().getHour())
					&& current.getNextRideTime().getMinute() == (LocalTime.now().getMinute())) {
				temporaryList.add(current);
			}
		}
		return temporaryList;
	}

	public static int noOfRides() {
		return managersList.size();
	}

	public static void addNewRide(RidesStation newRidesObj) {
		managersList.add(new StationManager(newRidesObj));
	}

	//this code just for test
	public static void view() {
		for (StationManager x : managersList) {
			System.out.println("                           "+x.getRideName() + " " + x.getNextRideTime().toString());
		}
	}
}
