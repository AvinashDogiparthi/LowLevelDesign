package X_LibraryManagementSystem;

import X_LibraryManagementSystem.Book.Book;
import X_LibraryManagementSystem.Order.Order;
import X_LibraryManagementSystem.Order.OrderBuilder;
import X_LibraryManagementSystem.Order.OrderTypeEnum;
import X_LibraryManagementSystem.User.User;
import X_LibraryManagementSystem.User.UserManagementService;
import X_LibraryManagementSystem.User.UserTypeEnum;

import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Library {

    private static Library instance = null;
    private Map<String, Book> bookMap;
    private Map<String,Order> orderMap;
    private UserManagementService userManagementService;

    private Library(){
        this.bookMap = new HashMap<>();
        userManagementService = new UserManagementService();
        orderMap = new HashMap<>();
    }

    public static Library getInstance(){
        if(instance == null){
            instance = new Library();
        }

        return instance;
    }

    public void addBook(String userID, String bookId, String bookName, String authorName, int perDayPrice){

        if(userManagementService.isUserAlreadyARegisteredOne(userID)){

            User user = userManagementService.getUser(userID);
            if(user.getUserTypeEnum().equals(UserTypeEnum.ADMIN)){
                if(this.bookMap.containsKey(bookId)){
                    System.out.println("Library::addBook -- Book "+bookId+"-"+bookName+" is already into the library system, please update");
                } else {
                    Book book = new Book(bookId,bookName,authorName,perDayPrice);
                    this.bookMap.put(bookId,book);
                    System.out.println("Library::addBook -- successful in adding a new book into library");
                }
            }
        } else {
            System.out.println("Library::addBook -- In valid user actions");
        }
    }

    public Order borrowBook(String userID, String bookID){

        Order order = null;
        if(userManagementService.isUserAlreadyARegisteredOne(userID)){
            if(bookMap.containsKey(bookID)){
                Book book = bookMap.get(bookID);
                if(book.isAvailable()){
                   order =  doRequiredLogistics(userID, bookID, book);
                } else {
                    System.out.println("Library::borrowBook -- book is not available, so adding user into queue");
                    book.addUserIntoQueue(userID);
                }
            } else {
                System.out.println("Library::borrowBook -- no book found with the sent book id");
            }
        } else {
            System.out.println("Library::borrowBook -- ");
        }

        return order;
    }

    public void handOverBook(String userId, String bookId,String orderID){
        if(userManagementService.isUserAlreadyARegisteredOne(userId)){

            User user = userManagementService.getUser(userId);

            Order order = orderMap.get(orderID);

            if (order != null) {
                order.setOrderStatus(OrderTypeEnum.COMPLETED);
                order.setEndTime(Instant.now().toEpochMilli());

                Book book = bookMap.get(bookId);
                userManagementService.notifyUsers(book,book.getUserWaitingQueue());

                book.setAvailable(true);
                user.setElgibile(true);
                book.setUserWaitingQueue(new LinkedList<>());

                System.out.println("Library::handOverBook -- succesfully handed over book");
            } else {
                System.out.println("Library::handOverBook -- no matching order found for bookId: " + bookId);
            }


        } else {
            System.out.println("Library::handOverBook -- no such user found");
        }
    }

    private Order doRequiredLogistics(String userID, String bookID, Book book) {
        User user = userManagementService.getUser(userID);
        Order order = null;

        if(user.isElgibile()){
            long randomID = (long) (Math.random() * 100);
            order = new OrderBuilder()
                    .withOrderId(randomID)
                    .withBookID(bookID)
                    .withStartTime(Instant.now().toEpochMilli())
                    .withStatus(OrderTypeEnum.IN_PROGRESS).build();

            user.addOrderIntoUserBorrowHistory(order);
            this.orderMap.put(String.valueOf(randomID),order);

            book.setAvailable(false);

            System.out.println("Library::doRequiredLogistics -- successful in borrowing book");

        } else {
            System.out.println("Library::doRequiredLogistics -- AT_MAX user can only borrow one book");
        }

        return order;
    }

    public void registerUser(String userId, String userName, long phoneNumber, UserTypeEnum userTypeEnum){
        this.userManagementService.registerANewUser(userId,userName, phoneNumber, userTypeEnum);
    }
}
