package Q_SwiggyDesign.User;

import Q_SwiggyDesign.FoodItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserCart {

    private Map<String, FoodItem> foodItemMap;

    public void addItem(FoodItem foodItem){
        foodItemMap.put(foodItem.getName(),foodItem);
    }

    public void removeItem(String foodItem){
        foodItemMap.remove(foodItem);
    }

    public List<FoodItem> retrieveItemsInCart(){
        List<FoodItem> listOfFoodItems = new ArrayList<>();
        listOfFoodItems.addAll(foodItemMap.values());
        return listOfFoodItems;
    }
}
