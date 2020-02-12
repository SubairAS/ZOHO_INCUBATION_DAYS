package ThemePark;

public class Food {
	private String foodName;
	private int foodPrice, foodLoad;

	public Food(String foodName, int foodPrice, int foodLoad) {
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodLoad = foodLoad;
	}

	public String getFoodName() {
		return foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public int getFoodLoad() {
		return foodLoad;
	}

	public void updateFoodLoad(int foodLoad) {
		this.foodLoad += foodLoad;
	}
}
