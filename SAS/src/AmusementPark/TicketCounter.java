package AmusementPark;

import java.util.ArrayList;
import java.util.Scanner;

public class TicketCounter {
	private Scanner sc;
	private int ticketPrice = 600, premiumTicketPrice = 900;

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public void setPremiumTicketPrice(int premiumTicketPrice) {
		this.premiumTicketPrice = premiumTicketPrice;
	}

	public ArrayList<Person> eachPerson() {
		sc = new Scanner(System.in);
		ArrayList<Person> personsList = new ArrayList<Person>();
		System.out.println("No of peoples");
		int peoples = sc.nextInt();
		for (int i = 0; i < peoples; i++) {
			System.out.println("Date? [DDMMYY]");
			int date = sc.nextInt();
			System.out.println("Time? [HHMM]");
			int time = sc.nextInt();
			System.out.println("Age of the person?");
			int age = sc.nextInt();
			System.out.println("Height of the person?");
			int height = sc.nextInt();
			System.out.println("Weight of the person?");
			int weight = sc.nextInt();
			System.out.println("Credits? [You cant use it in Canteen and Shops");
			int credits = sc.nextInt();
			int priority = 5;
			int ticketPrice = 0;
			System.out.println(
					"Ticket Type?\n1.Usual(Priority-5)\n2.Free Coupon(Priority-5)\n3.VIP(Priority-10)\n4.Premium");
			label: {
				do {
					switch (sc.nextInt()) {
					case 1:
						break label;
					case 2:
						ticketPrice = this.ticketPrice;
						break label;
					case 3:
						ticketPrice = 0;
						priority = 10;
						break label;
					case 4:
						priority = 7;
						ticketPrice = premiumTicketPrice;
						break label;
					default:
						System.out.println("Invalid Selection");
						break;
					}
				} while (true);
			}
			String ticketType = "";
			if (age > 14.0 || height > 149.0) {
				ticketType = "ADULT";
				System.out.println("Ticket Type : Adult");
			} else {
				ticketType = "CHILDREN";
				System.out.println("Ticket Type : Children");
				ticketPrice = (ticketPrice / 2);
			}
			Ticket ticketObj = new Ticket(i + 1, time, date, priority, ticketType);
			Person personObj = new Person(age, height, weight, credits, ticketObj);
			System.out.println("Ticket Rate for the person " + ticketPrice + "\n");
			personsList.add(personObj);
		}
		return personsList;
	}
}