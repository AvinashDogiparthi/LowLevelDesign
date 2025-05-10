package O_CultFitDesign.WorkOuts;

import O_CultFitDesign.Slot;
import O_CultFitDesign.User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GymWorkOut implements WorkOut{

    public WorkOutType workOutType;

    public List<Slot> workoutSlots;

    public GymWorkOut(WorkOutType workOutType) {
        this.workOutType = WorkOutType.GYM;
        this.workoutSlots = new ArrayList<>();
    }

    @Override
    public void addSlot(Slot slot) {
        this.workoutSlots.add(slot);
        System.out.println("GymWorkOut::addSlot -  added a new slot");
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
        this.workoutSlots.remove(slot);
    }

    @Override
    public void displaySlots() {
        for(Slot availableSlot : workoutSlots){
            System.out.println("Slot : " + availableSlot);
        }
    }

    @Override
    public void bookSlot(int slotId, User user) {
        Slot slot = findSlot(slotId);
        if(Objects.nonNull(slot)){
            if(slot.getCurrentCapacity() > slot.getAvailableCapacity()){
                System.out.println("GymWorkOut::bookSlot - Slot is full, adding user into queue");
                slot.addUserInQueue(user);
            } else  {
                slot.addRegisteredUser(user);
                System.out.println("GymWorkOut::bookSlot - Slot is available, registration is successful");
                user.notifyUserRegardingRegistration(slot);
            }
        }
    }

    @Override
    public void cancelBooking(int slotId, User user) {
        Slot slot = findSlot(slotId);
        if(Objects.nonNull(slot)){
            slot.removeRegisteredUser(user);
            if(!slot.getWaitListQueue().isEmpty()){
                User queuedUser = slot.removeUserFromQueue();
                queuedUser.notifyUserRegardingRegistration(slot);
            }
        }
    }

    @Override
    public Slot findSlot(int startTime, int endTime) {
        Slot requestedTimeFrameSlot = null;
        for(Slot iterarbleSlot : workoutSlots){
            if(iterarbleSlot.getStartTime() == startTime && iterarbleSlot.getEndTime() == endTime){
                requestedTimeFrameSlot = iterarbleSlot;
            }
        }
        return requestedTimeFrameSlot;
    }

    @Override
    public List<Slot> availableSlotsList() {
        return workoutSlots;
    }

    public Slot findSlot(int slotId){
        Slot requestedSlot = null;
        for(Slot iterableSlot : workoutSlots){
            if(slotId == iterableSlot.getSlotId()){
                requestedSlot = iterableSlot;
            }
        }
        return requestedSlot;
    }


}
