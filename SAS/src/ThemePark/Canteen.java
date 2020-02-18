package ThemePark;

import java.util.ArrayList;
import java.util.Scanner;

public class Canteen {
	private static int canteenRevenue;
	private static Scanner sc = new Scanner(System.in);

	public static int getRevenue() {
		return canteenRevenue;
	}

	public static void shopCounter(Visitor visitor) {
		while (true) {
			checkFoodLoads();
			ArrayList<Food> foodsList = CanteenDataBase.getFoodsList();
			System.out.println("Select Food");
			int index = 1;
			for (Food currentFood : foodsList) {
				System.out.println((index++) + " " + currentFood.getFoodName() + " - Rs." + currentFood.getFoodPrice()
						+ " Available Qty " + currentFood.getFoodLoad());
			}
			int selection = sc.nextInt() - 1;
			label: {
				while (true) {
					if (selection <= foodsList.size()) {
						break label;
					} else {
						System.out.println("Invalid Selection");
					}
				}
			}
			int size = 0;
			while (true) {
				System.out.println("How Many?");
				int temp = sc.nextInt();
				if (temp <= foodsList.get(selection).getFoodLoad()) {
					size = temp;
					break;
				} else {
					System.out.println("Choose Lesser than " + foodsList.get(selection).getFoodLoad());
				}
			}
			int bill = foodsList.get(selection).getFoodPrice() * size;
			if (visitor.payment(bill)) {
				CanteenDataBase.deccreaseFoodLoad(selection, size);
				canteenRevenue += bill;
			}
			sc.nextLine();
			System.out.println("Want to buy more? N to cancel");
			char temp = sc.nextLine().charAt(0);
			if (temp == 'N' || temp == 'n') {
				break;
			}
		}
		System.out.println("Visitor Exit Time?");
		int exitTime = sc.nextInt();
		visitor.updateFreeTime(visitor.getFreeTime().plusMinutes(exitTime));
	}

	private static void checkFoodLoads() {
		ArrayList<Food> foodsList = CanteenDataBase.getFoodsList();
		int index = 0;
		for (Food currentFood : foodsList) {
			if (currentFood.getFoodLoad() < 10) {
				CanteenDataBase.increaseFoodLoad(index);
				canteenRevenue -= (currentFood.getFoodPrice() * 0.9) * 10;
			}
		}
	}
}
