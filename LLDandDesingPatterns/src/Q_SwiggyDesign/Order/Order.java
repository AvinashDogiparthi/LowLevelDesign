package Q_SwiggyDesign.Order;

import Q_SwiggyDesign.PaymentStrategy.PaymentStrategy;
import Q_SwiggyDesign.User.Customer;

public class Order {

    private int orderId;
    private OrderStatusEnum orderStatusEnum;
    private PaymentStrategy paymentStrategy;
    private Customer customer;

    public Order(int orderId, PaymentStrategy paymentStrategy, OrderStatusEnum orderStatusEnum,Customer customer) {
        this.orderId = orderId;
        this.paymentStrategy = paymentStrategy;
        this.orderStatusEnum = orderStatusEnum;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public OrderStatusEnum getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
