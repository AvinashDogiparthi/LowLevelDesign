package Q_SwiggyDesign.Restaurant;

import Q_SwiggyDesign.FoodItem;
import Q_SwiggyDesign.FoodItemRequestObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestaurantService {

    public void increaseItemCount(Restaurant restaurant, FoodItemRequestObject foodItemRequestObject){

        if(restaurant.getAvailableFoodItems().containsKey(foodItemRequestObject.getName())){
            System.out.println("RestaurantService::increaseItemCount -- similar kind of item entity already exist so updating the count");
            FoodItem foodItem = restaurant.getAvailableFoodItems().get(foodItemRequestObject.getName());
            int updatedItemCount = foodItem.getCount();
            System.out.println("RestaurantService::increaseItemCount -- count before updating for "+foodItem.getName()+" is : "+updatedItemCount);
            updatedItemCount = updatedItemCount + foodItemRequestObject.getCount();
            foodItem.setCount(updatedItemCount);
            restaurant.getAvailableFoodItems().put(foodItem.getName(),foodItem);
            System.out.println("RestaurantService::increaseItemCount -- updated "+foodItem.getName()+" to count : "+updatedItemCount);
        } else {
            System.out.println("RestaurantService::increaseItemCount -- currently this kind of item doesn't exist so please create a new one");
        }
    }

    public void addItem(Restaurant restaurant, FoodItemRequestObject foodItemRequestObject) {

        if(restaurant.getAvailableFoodItems().containsKey(foodItemRequestObject.getName())){
            System.out.println("RestaurantService::addItem -- entity already available so updating it");
            increaseItemCount(restaurant,foodItemRequestObject);
        } else {
            System.out.println("RestaurantService::addItem -- creating a new entity");
            FoodItem foodItem = new FoodItem.FoodItemBuilder()
                    .withName(foodItemRequestObject.getName())
                    .withCount(foodItemRequestObject.getCount())
                    .withDescription(foodItemRequestObject.getDescription())
                    .withPrice(foodItemRequestObject.getPrice())
                    .build();
            restaurant.getAvailableFoodItems().put(foodItem.getName(),foodItem);
            System.out.println("RestaurantService::addItem -- created a new entity");
        }
    }

    public void removeItem(Restaurant restaurant, FoodItemRequestObject foodItemRequestObject){

        if(restaurant.getAvailableFoodItems().containsKey(foodItemRequestObject.getName())){
            System.out.println("RestaurantService::removeItem -- removing item : "+foodItemRequestObject.getName()+" from restaurant menu");
            restaurant.getAvailableFoodItems().remove(foodItemRequestObject.getName());
            System.out.println("RestaurantService::removeItem -- removed item : "+foodItemRequestObject.getName()+" from restaurant menu");
        } else {
            System.out.println("RestaurantService::removeItem -- current Item doesn't exist in restaurant");
        }
    }

    public List<FoodItem> getAllFoodItems(Restaurant restaurant){
        List<FoodItem> availableFoodItems = new ArrayList<>();
        Map<String, FoodItem> availableFoodItemsInRestaurant = restaurant.getAvailableFoodItems();
        availableFoodItems.addAll(availableFoodItemsInRestaurant.values());
        System.out.println("RestaurantService::getAllFoodItems -- available food items count : "+restaurant.getAvailableFoodItems().size());
        return availableFoodItems;
    }
}
