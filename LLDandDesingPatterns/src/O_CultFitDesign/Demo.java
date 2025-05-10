package O_CultFitDesign;

import O_CultFitDesign.User.User;
import O_CultFitDesign.User.UserType;
import O_CultFitDesign.WorkOuts.WorkOutType;

public class Demo {

    public static void main(String[] args) {
        CultFit cultFit = CultFit.getInstance();

        System.out.println("-----------------------DEMO Starting----------------------------");
        // booking a slot from customer
        User avinash = new User(1,"Avinash D",232323, UserType.CUSTOMER);
        int bookingId = cultFit.bookSlot(112, WorkOutType.GYM,1,2,avinash);
        if(bookingId == 0){
            System.out.println("Booking was not due to different reasons");
        }

        System.out.println("---------------------Cancelling Booked Slot---------------------");
        // cancelling a booked slot from customer
        cultFit.cancelBookedSlot(112,WorkOutType.GYM,bookingId,avinash);


        System.out.println("---------------------Adding a new Slot--------------------------");
        // adding a slot from admin
        User snehith = new User(2,"Snehith",1213232, UserType.ADMIN);
        Slot slot = new Slot(4,5,1);
        cultFit.addSlot(snehith,slot,112,WorkOutType.YOGA);


        System.out.println("--------------------Booking to new Slot-------------------------");
        // created a slot with only capacity 1
        // booking slot under snehith name
        int snehithBookingId = cultFit.bookSlot(112,WorkOutType.YOGA,4,5,snehith);

        System.out.println("--------------------One more Booking to new Slot-------------------------");

        // avinash will try to book a session in the same slot, now he will be added into waiting queue
        int avinashBookingId = cultFit.bookSlot(112,WorkOutType.YOGA,4,5,avinash);

        System.out.println("---------------------Cancelling booking"+snehithBookingId+" ---------------");

        // cancelling slot from snehith, so that avinash who is waiting in the queue will get booking
        cultFit.cancelBookedSlot(112,WorkOutType.YOGA,snehithBookingId,snehith);
    }
}
