package ThemePark;

import java.time.*;

public class VIPTicket extends Ticket {
	private int ticketPrice=0, priority=10;
	private String ticketType="VIP";

	public VIPTicket(int id, String personType) {
		super.setDate(LocalDate.now());
		super.setId(id);
		super.setTime(LocalTime.now());
		super.setTicketPrice(this.ticketPrice);
		super.setPersonType(personType);
		super.setPriority(this.priority);
		super.setTicketType(this.ticketType);
	}
}
