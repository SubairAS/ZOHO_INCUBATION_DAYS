package AmusementPark;

public class Ticket {
	private int id, enteredTime, Date, priority;
	private String ticketType, ridesHistory;

	public Ticket(int id, int enteredTime, int date, int priority, String ticketType) {
		this.id = id;
		this.priority = priority;
		this.enteredTime = enteredTime;
		Date = date;
	}

	public int getId() {
		return id;
	}

	public int getEnteredTime() {
		return enteredTime;
	}

	public int getDate() {
		return Date;
	}

	public int getPriority() {
		return priority;
	}

	public String getTicketType() {
		return ticketType;
	}

	public String getRidesHistory() {
		return ridesHistory;
	}

	public void updateRidesHistory(String ridesHistory) {
		this.ridesHistory += ridesHistory;
	}
}
