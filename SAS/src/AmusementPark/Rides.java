package AmusementPark;

public class Rides {
	private int maxCapacity, availableCapacity;

	public int getCapacity() {
		return maxCapacity;
	}

	public void updateAvailableCapacity() {
		availableCapacity--;
	}

	protected boolean isFull() {
		if (availableCapacity == 0) {
			return true;
		}
		return false;
	}
}
