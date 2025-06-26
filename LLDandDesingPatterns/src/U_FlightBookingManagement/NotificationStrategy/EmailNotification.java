package U_FlightBookingManagement.NotificationStrategy;

import U_FlightBookingManagement.NotificationStrategy.utils.NotificationDetails;
import U_FlightBookingManagement.User.User;

public class EmailNotification implements NotificationStrategy{

    @Override
    public void notify(User user, NotificationDetails notificationDetails) {
        System.out.println("EmailNotification::notify --- notification process initiated for "+user.getUserID());

        if(notificationDetails.isBookingStatus()){
            System.out.println("EmailNotification::notify --- booking is done by user "+ user.getUserID()+ " for seat number : "+notificationDetails.getSeatID());
            System.out.println("EmailNotification::notify --- user wallet money has reduced");
        }

        if(notificationDetails.isCancellationStatus()){
            System.out.println("EmailNotification::notify --- cancellation was done by user "+ user.getUserID()+ " for seat number : "+notificationDetails.getSeatID());
            System.out.println("EmailNotification::notify --- credited refund money in user wallet money");
        }
    }
}
