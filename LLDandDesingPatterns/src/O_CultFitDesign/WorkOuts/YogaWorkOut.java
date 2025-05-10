package O_CultFitDesign.WorkOuts;

import O_CultFitDesign.Booking.Booking;
import O_CultFitDesign.Booking.BookingTypeEnum;
import O_CultFitDesign.Slot;
import O_CultFitDesign.User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class YogaWorkOut implements WorkOut{

    public WorkOutType workOutType;

    public List<Slot> workOutSlots;

    public YogaWorkOut(WorkOutType workOutType) {
        this.workOutType = WorkOutType.YOGA;
        this.workOutSlots = new ArrayList<>();
    }

    @Override
    public void addSlot(Slot slot) {
        this.workOutSlots.add(slot);
        System.out.println("YogaWorkOut::addSlot -  added a new slot");
    }

    @Override
    public void cancelSlot(int slotId) {
        Slot slot = findSlot(slotId);
        if(Objects.nonNull(slot)){
            List<User> userList = slot.getRegisteredUsers();
            for(User user : userList){
                user.notifyUserRegardingSlotCancellation(slot);
            }
        }
    }

    @Override
    public void displaySlots() {
        for(Slot availableSlot : workOutSlots){
            System.out.println("Slot : " + availableSlot);
        }
    }

    @Override
    public boolean bookSlot(int slotId, User user) {
        Slot slot = findSlot(slotId);
        boolean isBookingDone = false;
        if(Objects.nonNull(slot)){
            if(slot.getCurrentCapacity() >= slot.getAvailableCapacity()){
                System.out.println("YogaWorkOut::bookSlot - Slot is full, adding user into queue");
                slot.addUserInQueue(user);
            } else  {
                slot.addRegisteredUser(user);
                System.out.println("YogaWorkOut::bookSlot - Slot is available, registration is successful");
                user.notifyUserRegardingRegistration(slot);
                isBookingDone = true;
            }
        }
        return isBookingDone;
    }

    @Override
    public void cancelBooking(int slotId, User user, int gymId) {
        Slot slot = findSlot(slotId);
        if(Objects.nonNull(slot)){
            slot.removeRegisteredUser(user);
            if(!slot.getWaitListQueue().isEmpty()){
                User queuedUser = slot.removeUserFromQueue();
                queuedUser.notifyUserRegardingRegistration(slot);
                slot.addRegisteredUser(user);
                int randomBookingId = (int) Math.random()*100;
                user.bookingList.add(new Booking(randomBookingId,slot, BookingTypeEnum.CONFIRMED,gymId,WorkOutType.YOGA));
            }
        }
    }

    @Override
    public Slot findSlot(int startTime, int endTime) {
        Slot requestedTimeFrameSlot = null;
        for(Slot iterarbleSlot : workOutSlots){
            if(iterarbleSlot.getStartTime() == startTime && iterarbleSlot.getEndTime() == endTime){
                requestedTimeFrameSlot = iterarbleSlot;
            }
        }
        return requestedTimeFrameSlot;
    }

    @Override
    public List<Slot> availableSlotsList() {
        return workOutSlots;
    }

    public Slot findSlot(int slotId){
        Slot requestedSlot = null;
        for(Slot iterableSlot : workOutSlots){
            if(slotId == iterableSlot.getSlotId()){
                requestedSlot = iterableSlot;
            }
        }
        return requestedSlot;
    }
}
