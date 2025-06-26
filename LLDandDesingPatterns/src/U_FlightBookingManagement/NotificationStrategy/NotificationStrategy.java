package U_FlightBookingManagement.NotificationStrategy;
import U_FlightBookingManagement.*;
import U_FlightBookingManagement.NotificationStrategy.utils.NotificationDetails;

public interface NotificationStrategy {

    void notify(User user, NotificationDetails notificationDetails);
}
