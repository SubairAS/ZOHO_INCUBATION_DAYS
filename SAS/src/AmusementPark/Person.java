package AmusementPark;

public class Person {
	private int age, height, weight, credits;
	private Ticket ticket;

	public Person(int age, int height, int weight, int credits, Ticket ticket) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.credits = credits;
		this.ticket = ticket;
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

	public int getCredits() {
		return credits;
	}

	public Ticket getTicket() {
		return ticket;
	}
}
