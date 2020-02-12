package ThemePark;

import java.time.*;

public class UsualTicket extends Ticket {
	private int ticketPrice=600, priority=5;
	private String ticketType="USUAL";

	public UsualTicket(int id, String personType) {
		super.setDate(LocalDate.now());
		super.setId(id);
		super.setTime(LocalTime.now());
		super.setTicketPrice(this.ticketPrice);
		super.setPersonType(personType);
		super.setPriority(this.priority);
		super.setTicketType(this.ticketType);
	}
}
