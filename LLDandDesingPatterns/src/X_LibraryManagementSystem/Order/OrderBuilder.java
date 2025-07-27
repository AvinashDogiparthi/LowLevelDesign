package X_LibraryManagementSystem.Order;

import java.time.Instant;

public class OrderBuilder {

    protected long orderID;
    protected long startTime;
    protected long endTime;
    protected String userID;
    protected String bookID;
    protected OrderTypeEnum orderStatus; // true for active, false for completed
    protected int totalAmountToBePaid;

    public OrderBuilder withOrderId(long orderID){
        this.orderID = orderID;
        return this;
    }

    public OrderBuilder withStartTime(long startTime){
        this.startTime = startTime;
        return this;
    }

    public OrderBuilder withEndTime(long endTime){
        this.endTime = endTime;
        return this;
    }

    public OrderBuilder withUserID(String userID){
        this.userID = userID;
        return this;
    }

    public OrderBuilder withBookID(String bookID){
        this.bookID = bookID;
        return this;
    }

    public OrderBuilder withStatus(OrderTypeEnum orderStatus){
        this.orderStatus = orderStatus;
        return this;
    }

    public OrderBuilder withTotalAmountToBePaid(int totalAmountToBePaid){
        this.totalAmountToBePaid = totalAmountToBePaid;
        return this;
    }

    public Order build(){
        return new Order(this);
    }
}
