package ThemePark;

import java.util.Scanner;

public class TicketCounter {
	private static Scanner scanner = new Scanner(System.in);
	private static int id = 1;

	public static void ticketVending() {
		System.out.println("Age");
		int age = scanner.nextInt();
		System.out.println("Height");
		int height = scanner.nextInt();
		System.out.println("Weight");
		int weight = scanner.nextInt();
		System.out.println("Credits");
		int credits = scanner.nextInt();
		System.out.println("Ticket type?\n1.Usual Ticket\n2.Premium Ticket\n3.Free Coupon\n4.VIP Ticket");
		String ticketType = "";
		label: {
			int selection = scanner.nextInt();
			switch (selection) {
			case 1:
				ticketType = "USUAL";
				break label;
			case 2:
				ticketType = "PREMIUM";
				break label;
			case 3:
				ticketType = "FREE";
				break label;
			case 4:
				ticketType = "VIP";
				break label;
			default:
				System.out.println("Invalid Selection!");
			}
		}
		String personType = (age >= 15 || height >= 150) ? "ADULT" : "CHILDREN";
		System.out.println("Your Ticket ID is: " + id);
		VisitorDataBase.addVisitor(new Visitor.VisitorBuilder(id++).setAge(age).setCredits(credits).setHeight(height)
				.setWeight(weight).setTicket(personType, ticketType).getVisitor());
	}
}
