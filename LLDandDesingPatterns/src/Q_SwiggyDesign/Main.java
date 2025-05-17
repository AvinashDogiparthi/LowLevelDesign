package Q_SwiggyDesign;

import Q_SwiggyDesign.Restaurant.Restaurant;

public class Main {

    public static void main(String[] args) {
        Swiggy swiggy = Swiggy.getInstance();
        String bangloreCity = "banglore";
        String chennaiCity = "chennai";
        String kyoto = "kyoto";

        FoodItem foodItem1 = new FoodItem.FoodItemBuilder()
                .withName("vegBiryani")
                .withCount(20)
                .withDescription("This is a sample foodItem")
                .withPrice(100)
                .build();

        FoodItem foodItem2 = new FoodItem.FoodItemBuilder()
                .withName("chickenBiryani")
                .withCount(20)
                .withDescription("This is a sample chicken biryani")
                .withPrice(300)
                .build();

        FoodItem foodItem3 = new FoodItem.FoodItemBuilder()
                .withName("faluda")
                .withCount(10)
                .withDescription("This is a sample faluda")
                .withPrice(30)
                .build();

        Restaurant restaurant = new Restaurant(101);

        // setting up restaurant in banglore city
        swiggy.registerANewRestaurant(bangloreCity,restaurant);
        swiggy.addNewItem(bangloreCity,101, foodItem1);
        swiggy.increaseItemCount(bangloreCity,101,10, foodItem1.getName());
        swiggy.addNewItem(bangloreCity,101,foodItem3);
        swiggy.increaseItemCount(bangloreCity,101,100, foodItem3.getName());

        // retrieve menu
        swiggy.getAvailableItems(bangloreCity,101);
    }
}
