package Q_SwiggyDesign.User;

import Q_SwiggyDesign.FoodItem;
import Q_SwiggyDesign.Order.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomerService {

    Map<Integer, Customer> registeredCustomers;

    public CustomerService(){
        this.registeredCustomers = new HashMap<>();
    }

    public Customer createUser(int userId, String userName){
        Customer customer = new Customer(userId,userName);
        registeredCustomers.put(userId,customer);
        return customer;
    }

    public void deleteUser(int userId){
        registeredCustomers.remove(userId);
    }

    public User getUserInfo(int userId){
        if(registeredCustomers.containsKey(userId)){
            return registeredCustomers.get(userId);
        }
        return null;
    }

    public void addOrder(Order order, int userId){
        Customer customer = registeredCustomers.get(userId);
        if(Objects.nonNull(customer)){
            customer.addOrder(order);
        }
    }

    public void cancelOrder(int orderId, int userId){
        Customer customer = registeredCustomers.get(userId);
        if(Objects.nonNull(customer)){
            customer.removeOrder(orderId);
        }
    }

    public void addItemToCart(FoodItem foodItem, int userId){
        Customer customer = registeredCustomers.get(userId);
        customer.getUserCart().addItem(foodItem);
    }

    public void removeItemFromCart(String foodItem, int userId){
        Customer customer = registeredCustomers.get(userId);
        customer.getUserCart().removeItem(foodItem);
    }
}
