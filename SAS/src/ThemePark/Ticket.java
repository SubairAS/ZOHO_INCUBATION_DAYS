package ThemePark;

import java.time.*;

abstract public class Ticket {
	private LocalDate date;
	private LocalTime time;
	private int ticketPrice, priority, id;
	private String ticketType, personType;

	protected int getPriority() {
		return priority;
	}

	protected void setPriority(int priority) {
		this.priority = priority;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getPersonType() {
		return personType;
	}

	protected void setPersonType(String personType) {
		this.personType = personType;
	}

	protected LocalDate getDate() {
		return date;
	}

	protected void setDate(LocalDate date) {
		this.date = date;
	}

	protected LocalTime getTime() {
		return time;
	}

	protected void setTime(LocalTime time) {
		this.time = time;
	}

	protected int getTicketPrice() {
		return ticketPrice;
	}

	protected void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	protected String getTicketType() {
		return ticketType;
	}

	protected void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
}
