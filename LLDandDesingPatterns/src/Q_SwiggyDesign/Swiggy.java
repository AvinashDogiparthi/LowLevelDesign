package Q_SwiggyDesign;

import Q_SwiggyDesign.Order.Order;
import Q_SwiggyDesign.Order.OrderStatusEnum;
import Q_SwiggyDesign.PaymentStrategy.PaymentStrategy;
import Q_SwiggyDesign.Restaurant.Restaurant;
import Q_SwiggyDesign.Restaurant.RestaurantService;
import Q_SwiggyDesign.User.Customer;
import Q_SwiggyDesign.User.CustomerService;
import Q_SwiggyDesign.User.DeliveryBoy;
import Q_SwiggyDesign.User.User;

import java.util.*;

public class Swiggy {

    private static Swiggy instance = null;

    Map<String, Map<Integer, Restaurant>> cityVsRestuarantMap;

    Map<String,Map<Integer,Restaurant>> foodItemVsRestuarantMap;

    Map<String, Map<Integer, DeliveryBoy>> cityVsDeliveryBoyMap;

    RestaurantService restaurantService = new RestaurantService();

    CustomerService customerService = new CustomerService();

    private Swiggy() {
        this.cityVsRestuarantMap = new HashMap<>();
        this.foodItemVsRestuarantMap = new HashMap<>();
        this.cityVsDeliveryBoyMap = new HashMap<>();
        createDeliveryBoys("banglore");
        createDeliveryBoys("chennai");
        createDeliveryBoys("kyoto");
    }

    public synchronized static Swiggy getInstance(){
        if(instance == null){
            instance = new Swiggy();
        }

        return instance;
    }

    public void registerANewRestaurant(String cityName, Restaurant restaurant){
        System.out.println("Swiggy::registerANewRestaurant -- registering a new restaurant");

        if(Objects.nonNull(cityVsRestuarantMap.get(cityName))){
            cityVsRestuarantMap.get(cityName).put(restaurant.getRestaurantId(),restaurant);
        } else {
            Map<Integer,Restaurant> newRestaurantMap = new HashMap<>();
            newRestaurantMap.put(restaurant.getRestaurantId(),restaurant);
            cityVsRestuarantMap.put(cityName,newRestaurantMap);
        }

        for(FoodItem item : restaurant.getAvailableFoodItems().values()){
            if(foodItemVsRestuarantMap.containsKey(item.getName())){
                Map<Integer,Restaurant> availableFoodItemMap = foodItemVsRestuarantMap.get(item.getName());
                availableFoodItemMap.put(restaurant.getRestaurantId(),restaurant);
            } else {
                Map<Integer,Restaurant> newRestaurantMap = new HashMap<>();
                newRestaurantMap.put(restaurant.getRestaurantId(),restaurant);
                foodItemVsRestuarantMap.put(item.getName(),newRestaurantMap);
            }
        }
        System.out.println("Swiggy::registerANewRestaurant -- registering a new restaurant is done");
    }

    public void increaseItemCount(String cityName, int restaurantId, int count, String foodItem){
        System.out.println("Swiggy::increaseItemCount -- increasing count of item : "+foodItem+" in city : "+cityName+" in restaurant : "+restaurantId);
        FoodItemRequestObject foodItemRequestObject = new FoodItemRequestObject.FoodItemRequestBuilder()
                .withCount(count)
                .withName(foodItem)
                .build();

        Restaurant restaurant = cityVsRestuarantMap.get(cityName).get(restaurantId);

        restaurantService.increaseItemCount(restaurant,foodItemRequestObject);

        if(!foodItemVsRestuarantMap.containsKey(foodItem)){
            HashMap<Integer,Restaurant> newFoodItemMap = new HashMap<>();
            newFoodItemMap.put(restaurant.getRestaurantId(),restaurant);
            foodItemVsRestuarantMap.put(foodItem,newFoodItemMap);
        }

        System.out.println("Swiggy::increaseItemCount -- DONE with increasing count of item : "+foodItem+" in city : "+cityName+" in restaurant : "+restaurantId);
    }

    public void addNewItem(String cityName, int restaurantId, FoodItem foodItemObject){

        System.out.println("Swiggy::increaseItemCount -- adding a new item : "+foodItemObject.getName()+" in city : "+cityName+" in restaurant : "+restaurantId);
        FoodItemRequestObject foodItemRequestObject = new FoodItemRequestObject.FoodItemRequestBuilder()
                .withCount(foodItemObject.getCount())
                .withName(foodItemObject.getName())
                .withDescription(foodItemObject.getDescription())
                .withPrice(foodItemObject.getPrice())
                .build();

        Restaurant restaurant = cityVsRestuarantMap.get(cityName).get(restaurantId);

        RestaurantService restaurantService = new RestaurantService();
        restaurantService.addItem(restaurant,foodItemRequestObject);

        if(!foodItemVsRestuarantMap.containsKey(foodItemObject.getName())){
            HashMap<Integer,Restaurant> newFoodItemMap = new HashMap<>();
            newFoodItemMap.put(restaurant.getRestaurantId(),restaurant);
            foodItemVsRestuarantMap.put(foodItemObject.getName(),newFoodItemMap);
        }

        System.out.println("Swiggy::increaseItemCount -- DONE with adding a new item : "+foodItemObject.getName()+" in city : "+cityName+" in restaurant : "+restaurantId);
    }

    public void removeItem(String cityName, int restaurantId, String itemName){

        System.out.println("Swiggy::increaseItemCount -- removing an item : "+itemName+" in city : "+cityName+" in restaurant : "+restaurantId);
        FoodItemRequestObject foodItemRequestObject = new FoodItemRequestObject.FoodItemRequestBuilder()
                .withName(itemName)
                .build();

        Restaurant restaurant = cityVsRestuarantMap.get(cityName).get(restaurantId);
        restaurantService.removeItem(restaurant,foodItemRequestObject);

        if(foodItemVsRestuarantMap.containsKey(itemName)){
            HashMap<Integer,Restaurant> restaurantMap = new HashMap<>();
            restaurantMap.remove(restaurantId);
        }

        System.out.println("Swiggy::increaseItemCount -- DONE with removing an item : "+itemName+" in city : "+cityName+" in restaurant : "+restaurantId);
    }

    public List<FoodItem> getAvailableItems(String cityName, int restaurantId){
        Restaurant restaurant = cityVsRestuarantMap.get(cityName).get(restaurantId);
        return restaurantService.getAllFoodItems(restaurant);
    }

    public User registerNewUser(int userId, String userName){
        User customer = customerService.createUser(userId,userName);
        System.out.println("Swiggy::registerNewUser -- successfully registered a new user");
        return customer;
    }

    public void addItemsToUserCart(FoodItem foodItem, int userId){
        customerService.addItemToCart(foodItem, userId);
        System.out.println("Swiggy::addItemsToUserCart -- adding food items to user cart");
    }

    public void placeOrder(String cityName, int restaurantId, Customer customer, PaymentStrategy paymentStrategy){
        Restaurant restaurant = cityVsRestuarantMap.get(cityName).get(restaurantId);
        if(Objects.nonNull(restaurant)){
            System.out.println("Swiggy::placeOrder -- restaurant is available, moving further for next level processing");
            boolean isAvailable = validateAvailabilityOfFoodItems(customer, restaurant);

            if(isAvailable){
                for(FoodItem foodItem : customer.getUserCart().retrieveItemsInCart()){
                    FoodItem restaurantFoodItem = restaurant.getAvailableFoodItems().get(foodItem.getName());
                    restaurant.getAvailableFoodItems().get(foodItem.getName()).setCount(restaurantFoodItem.getCount() - foodItem.getCount());
                }

                paymentStrategy.pay();

                int orderId = new Random().nextInt(1_000_000);
                Order order = new Order(orderId, paymentStrategy, OrderStatusEnum.ON_THE_WAY,customer);
                customer.addOrder(order);

                Random random = new Random();
                List<DeliveryBoy> deliveryBoys = new ArrayList<>(cityVsDeliveryBoyMap.get(cityName).values());
                DeliveryBoy deliveryBoy = deliveryBoys.get(random.nextInt(deliveryBoys.size()));
                deliveryBoy.addOrder(order);

                customer.removeItemsFromCart();
                System.out.println("Swiggy::placeOrder -- order placed successfully with orderId: " + orderId);                System.out.println("Swiggy::placeOrder -- order placed successfully with orderId: " + orderId);
            } else {
                System.out.println("Swiggy::placeOrder --- items are not available please remove items from your cart or choose another restaurant");
            }
        } else {
            System.out.println("Swiggy::placeOrder -- order CANNOT be places as restaurant is un-available");
        }
    }

    private boolean validateAvailabilityOfFoodItems(Customer customer, Restaurant restaurant) {
        for(FoodItem foodItem : customer.getUserCart().retrieveItemsInCart()){
            if(! (foodItem.getCount() >= restaurant.getAvailableFoodItems().get(foodItem.getName()).getCount())){
                System.out.println("Swiggy::validateAvailabilityOfFoodItems ------------ WARNING ----------- count of food items in user cart are not available in restaurant : "+ restaurant.getRestaurantId());
                return false;
            }
        }
        System.out.println("Swiggy::validateAvailabilityOfFoodItems ------------- SUCCESS ------------- all items available, you proceed further");
        return true;
    }

    public void createDeliveryBoys(String cityName) {
        Map<Integer, DeliveryBoy> deliveryBoyMap = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            DeliveryBoy deliveryBoy = new DeliveryBoy(i, "DeliveryBoy_" + i);
            deliveryBoyMap.put(i, deliveryBoy);
        }
        cityVsDeliveryBoyMap.put(cityName, deliveryBoyMap);
    }
}
