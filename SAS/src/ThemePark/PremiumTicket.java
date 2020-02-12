package ThemePark;

import java.time.*;

public class PremiumTicket extends Ticket {
	private int ticketPrice=900, priority=7;
	private String ticketType="PREMIUM";

	public PremiumTicket(int id, String personType) {
		super.setDate(LocalDate.now());
		super.setId(id);
		super.setTime(LocalTime.now());
		super.setTicketPrice(this.ticketPrice);
		super.setPersonType(personType);
		super.setPriority(this.priority);
		super.setTicketType(this.ticketType);
	}
}
