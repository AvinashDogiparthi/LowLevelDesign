package O_CultFitDesign;

import O_CultFitDesign.Booking.Booking;
import O_CultFitDesign.Booking.BookingTypeEnum;
import O_CultFitDesign.User.User;
import O_CultFitDesign.User.UserType;
import O_CultFitDesign.WorkOuts.WorkOutType;

import java.util.*;

public class CultFit {
    private Map<Integer, Gym> gymList;
    public static CultFit instance = null;

    private CultFit() {
        this.gymList = new HashMap<>();
        initializeGyms();
    }

    public static synchronized CultFit getInstance() {
        if (instance == null) {
            instance = new CultFit();
        }

        return instance;
    }

    public void initializeGyms() {
        Gym marathahalliGym = new Gym("Marathahalli gym", 12);
        gymList.put(112, marathahalliGym);

        Gym panathurGym = new Gym("Old panathur gym", 143);
        gymList.put(143, panathurGym);

        Gym kadubeesanahalliGym = new Gym("Kadubeesanahalli Gym", 183);
        gymList.put(183, kadubeesanahalliGym);
    }

    public void registerGym(Gym gym) {
        gymList.put(gym.getGymId(), gym);
    }

    public int bookSlot(int gymID, WorkOutType workOutType, int startTime, int endTime, User user) {
        Gym requestedGym = this.gymList.get(gymID);
        int bookingId = 0;
        if (Objects.nonNull(requestedGym)) {
            bookingId = requestedGym.bookSlot(startTime, endTime, workOutType, user);
            return bookingId;
        } else {
            System.out.println("CultFit::bookSlot - requested gym id doesn't exist in the system");
            System.out.println("Available gym's : " + this.gymList);
        }
        return bookingId;
    }

    public void cancelBookedSlot(int gymId, WorkOutType workOutType, int bookingID, User user) {
        Gym requestedGym = this.gymList.get(gymId);
        Booking booking = findBooking(bookingID, user);
        requestedGym.cancelBookedSlot(booking.getBookedSlot(), workOutType, user, gymId);
        booking.updateBookingType(BookingTypeEnum.CANCELLED);
    }

    public void addSlot(User user, Slot slot, int gymId, WorkOutType workOutType) {
        if (user.getUserType() == UserType.ADMIN) {
            Gym gym = gymList.get(gymId);
            gym.addSlot(slot, workOutType);
        } else {
            System.out.println("User is not authorized to perform requested operation");
        }
    }

    public void removeSlot(User user, Slot slot, int gymId, WorkOutType workOutType) {
        if (user.getUserType() == UserType.ADMIN) {
            Gym gym = gymList.get(gymId);
            gym.cancelSlot(slot, workOutType);
        } else {
            System.out.println("User is not authorized to perform requested operation");
        }
    }

    public Booking findBooking(int bookingId, User user) {
        Booking bookingDetails = null;

        if (bookingId == 0) {
            System.out.println("Booking was not successful");
        }
        for (Booking booking : user.bookingList) {
            if (booking.getBookingId() == bookingId) {
                bookingDetails = booking;
            }
        }
        return bookingDetails;
    }
}
