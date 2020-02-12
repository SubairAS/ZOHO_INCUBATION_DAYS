package ThemePark;

public class TicketFactory {
	public static Ticket getTicket(int id, String personType, String ticketType) {
		if (ticketType.equals("PREMIUM")) {
			return new PremiumTicket(id, personType);
		} else if (ticketType.equals("USUAL")) {
			return new UsualTicket(id, personType);
		} else if (ticketType.equals("FREE")) {
			return new FreeCoupon(id, personType);
		} else if (ticketType.equals("VIP")){
			return new VIPTicket(id, personType);
		}
		return null;
	}
}