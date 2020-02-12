package ThemePark;

import java.util.ArrayList;

public class CanteenDataBase {
	private static ArrayList<Food> foodsList = new ArrayList<Food>();
	static {
		foodsList.add(new Food("Cake", 10, 50));
		foodsList.add(new Food("Pizza", 150, 10));
		foodsList.add(new Food("Meals", 100, 30));
		foodsList.add(new Food("Soft Drink", 20, 50));
	}

	public static ArrayList<Food> getFoodsList() {
		return foodsList;
	}

	public static void increaseFoodLoad(int foodIndex) {
		foodsList.get(foodIndex).updateFoodLoad(10);
	}

	public static void deccreaseFoodLoad(int foodIndex,int foodLoad) {
		foodsList.get(foodIndex).updateFoodLoad(-foodLoad);
	}
}
