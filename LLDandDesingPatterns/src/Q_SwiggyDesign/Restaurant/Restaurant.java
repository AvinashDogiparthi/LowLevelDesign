package Q_SwiggyDesign.Restaurant;

import Q_SwiggyDesign.FoodItem;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {

    private int restaurantId;
    private Map<String, FoodItem> availableFoodItems;

    public Restaurant(int restaurantId) {
        this.restaurantId = restaurantId;
        this.availableFoodItems = new HashMap<>();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Map<String, FoodItem> getAvailableFoodItems() {
        return availableFoodItems;
    }

    public void setAvailableFoodItems(Map<String, FoodItem> availableFoodItems) {
        this.availableFoodItems = availableFoodItems;
    }
}
