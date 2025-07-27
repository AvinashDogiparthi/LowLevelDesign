package X_LibraryManagementSystem.Order;

public class Order {

    private long orderID;
    private long startTime;
    private long endTime;
    private String userID;
    private String bookID;
    private OrderTypeEnum orderStatus; // true for active, false for completed
    private int totalAmountToBePaid;

    protected Order(OrderBuilder orderBuilder){
        this.orderID = orderBuilder.orderID;
        this.startTime = orderBuilder.startTime;
        this.endTime = orderBuilder.endTime;
        this.userID = orderBuilder.userID;
        this.bookID = orderBuilder.bookID;
        this.orderStatus = orderBuilder.orderStatus;
        this.totalAmountToBePaid = orderBuilder.totalAmountToBePaid;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public OrderTypeEnum isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderTypeEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getTotalAmountToBePaid() {
        return totalAmountToBePaid;
    }

    public void setTotalAmountToBePaid(int totalAmountToBePaid) {
        this.totalAmountToBePaid = totalAmountToBePaid;
    }
}
