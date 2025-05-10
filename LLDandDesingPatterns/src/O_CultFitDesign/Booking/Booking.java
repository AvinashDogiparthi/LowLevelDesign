package O_CultFitDesign.Booking;

import O_CultFitDesign.Slot;
import O_CultFitDesign.WorkOuts.WorkOutType;

public class Booking {
    private int bookingId;
    private Slot bookedSlot;
    private BookingTypeEnum bookingTypeEnum;
    private int gymId;
    private WorkOutType workOutTypeEnum;

    public Booking(int bookingId, Slot bookedSlot, BookingTypeEnum bookingTypeEnum, int gymId, WorkOutType workOutTypeEnum) {
        this.bookingId = bookingId;
        this.bookedSlot = bookedSlot;
        this.bookingTypeEnum = bookingTypeEnum;
        this.gymId = gymId;
        this.workOutTypeEnum = workOutTypeEnum;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Slot getBookedSlot() {
        return bookedSlot;
    }

    public void setBookedSlot(Slot bookedSlot) {
        this.bookedSlot = bookedSlot;
    }

    public BookingTypeEnum getBookingTypeEnum() {
        return bookingTypeEnum;
    }

    public void setBookingTypeEnum(BookingTypeEnum bookingTypeEnum) {
        this.bookingTypeEnum = bookingTypeEnum;
    }

    public void updateBookingType(BookingTypeEnum bookingTypeEnum){
        this.bookingTypeEnum = bookingTypeEnum;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public WorkOutType getWorkOutTypeEnum() {
        return workOutTypeEnum;
    }

    public void setWorkOutTypeEnum(WorkOutType workOutTypeEnum) {
        this.workOutTypeEnum = workOutTypeEnum;
    }
}
