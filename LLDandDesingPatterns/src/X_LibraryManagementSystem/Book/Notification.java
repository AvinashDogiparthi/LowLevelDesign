package X_LibraryManagementSystem.Book;

public class Notification {

    private String bookID;
    private String message;
    private long timestamp;

    public Notification(String bookID, String message, long timestamp) {
        this.bookID = bookID;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
