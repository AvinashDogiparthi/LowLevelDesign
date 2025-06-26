package U_FlightBookingManagement.NotificationStrategy;
import U_FlightBookingManagement.NotificationStrategy.utils.NotificationDetails;
import U_FlightBookingManagement.User.User;

public interface NotificationStrategy {

    void notify(User user, NotificationDetails notificationDetails);
}
