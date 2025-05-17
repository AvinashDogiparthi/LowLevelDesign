package Q_SwiggyDesign.User;

import Q_SwiggyDesign.Order.Order;

import java.util.HashMap;
import java.util.Map;

public class DeliveryBoy extends User{

    private Map<Integer, Order> deliveryMap;

    public DeliveryBoy(int userId, String userName) {
        super(userId,userName,UserType.DELIVERYBOY);
        this.deliveryMap = new HashMap<>();
    }

    public void addOrder(Order order){
        deliveryMap.put(order.getOrderId(),order);
    }

    public void removeOrder(int orderId){
        deliveryMap.remove(orderId);
    }

}
