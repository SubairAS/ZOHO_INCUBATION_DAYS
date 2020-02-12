package ThemePark;

import java.time.LocalTime;
import java.util.Scanner;

public class Visitor {
	private int id, age, height, weight, credits;
	private Ticket ticket;
	private LocalTime freeTime;
	private Scanner sc = new Scanner(System.in);

	private Visitor(int id, int age, int height, int weight, int credits, Ticket ticket) {
		this.id = id;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.credits = credits;
		this.ticket = ticket;
		freeTime = LocalTime.now();
	}

	public boolean payment(int bill) {
		System.out.println("Visitor ID " + id + "\nAvailable Credits : " + credits);
		if (bill <= credits) {
			System.out.println("Bill Amount is " + bill + "\nWould you like to pay the bill [Y/N]?");
			char temp = sc.nextLine().charAt(0);
			if (temp == 'y' || temp == 'Y') {
				credits -= bill;
				return true;
			}
		}
		System.out.println("Payment Failed");
		return false;
	}

	public void updateFreeTime(LocalTime time) {
		freeTime = time;
	}

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public LocalTime getFreeTime() {
		return freeTime;
	}

	static class VisitorBuilder {
		private int id, age, height, weight, credits;
		private Ticket ticket;

		public VisitorBuilder(int id) {
			this.id = id;
		}

		public VisitorBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public VisitorBuilder setHeight(int height) {
			this.height = height;
			return this;
		}

		public VisitorBuilder setWeight(int weight) {
			this.weight = weight;
			return this;
		}

		public VisitorBuilder setCredits(int credits) {
			this.credits = credits;
			return this;
		}

		public VisitorBuilder setTicket(String personType, String ticketType) {
			this.ticket = TicketFactory.getTicket(this.id, personType, ticketType);
			return this;
		}

		public Visitor getVisitor() {
			return new Visitor(id, age, height, weight, credits, ticket);
		}
	}
}