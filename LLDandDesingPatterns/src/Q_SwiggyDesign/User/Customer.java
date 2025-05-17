package Q_SwiggyDesign.User;

import Q_SwiggyDesign.Order.Order;

import java.util.HashMap;
import java.util.Map;

public class Customer extends User{

    private Map<Integer, Order> userOrders;

    private UserCart userCart;

    public Customer(int userId, String userName) {
        super(userId,userName,UserType.CUSTOMER);
        this.userOrders = new HashMap<>();
        this.userCart = new UserCart();
    }

    public Map<Integer, Order> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(Map<Integer, Order> userOrders) {
        this.userOrders = userOrders;
    }

    public UserCart getUserCart() {
        return userCart;
    }

    public void removeItemsFromCart(){
        this.userCart = new UserCart();
    }

    public void setUserCart(UserCart userCart) {
        this.userCart = userCart;
    }

    public void addOrder(Order order){
        userOrders.put(order.getOrderId(),order);
    }

    public void removeOrder(int orderId){
        userOrders.remove(orderId);
    }
}
