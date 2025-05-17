package Q_SwiggyDesign;

import Q_SwiggyDesign.CouponsDecarator.BasePriceCalculator;
import Q_SwiggyDesign.CouponsDecarator.CouponDecorator;
import Q_SwiggyDesign.CouponsDecarator.FlatDiscountCoupon;
import Q_SwiggyDesign.CouponsDecarator.PercentangeDiscountCoupon;
import Q_SwiggyDesign.PaymentStrategy.CashOnDelivery;
import Q_SwiggyDesign.PaymentStrategy.CreditCardPayment;
import Q_SwiggyDesign.PaymentStrategy.PaymentStrategy;
import Q_SwiggyDesign.PaymentStrategy.PhonePay;
import Q_SwiggyDesign.Restaurant.Restaurant;
import Q_SwiggyDesign.User.Customer;
import Q_SwiggyDesign.User.CustomerService;
import Q_SwiggyDesign.User.User;

import java.util.ArrayList;
import java.util.List;

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

        Customer customer1 = swiggy.registerNewUser(1,"Avinash");
        swiggy.addItemsToUserCart(foodItem3,1);
        swiggy.addItemsToUserCart(foodItem3,1);
        swiggy.addItemsToUserCart(foodItem3,1);
        swiggy.addItemsToUserCart(foodItem3,1);

        PaymentStrategy cashOnDelivery = new CashOnDelivery();
        PaymentStrategy creditCard = new CreditCardPayment();
        PaymentStrategy phonePay = new PhonePay();

        // Create a list of coupons
        List<CouponDecorator> coupons = new ArrayList<>();
        coupons.add(new FlatDiscountCoupon(new BasePriceCalculator(customer1), 50)); // Flat discount of 50
        coupons.add(new PercentangeDiscountCoupon(new BasePriceCalculator(customer1), 10)); // 10% discount
        swiggy.placeOrder(bangloreCity,101, customer1,cashOnDelivery,coupons);
    }
}
