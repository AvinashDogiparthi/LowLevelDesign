package X_LibraryManagementSystem.Book;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Book {

    private String bookId;
    private String bookName;
    private String authorName;
    private boolean isAvailable;
    private Queue<String> userWaitingQueue;
    private int perDayPrice;

    public Book(String bookId, String bookName, String authorName,int perDayPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.isAvailable = true;
        this.userWaitingQueue = new LinkedList<>();
        this.perDayPrice = perDayPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<String> getUserWaitingQueue() {
        return userWaitingQueue.stream().toList();
    }

    public void addUserIntoQueue(String userID) {
        this.userWaitingQueue.add(userID);
    }

    public int getPerDayPrice() {
        return perDayPrice;
    }

    public void setPerDayPrice(int perDayPrice) {
        this.perDayPrice = perDayPrice;
    }

    public void setUserWaitingQueue(Queue<String> userWaitingQueue) {
        this.userWaitingQueue = userWaitingQueue;
    }
}
