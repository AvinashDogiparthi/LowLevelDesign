package O_CultFitDesign;

import O_CultFitDesign.Booking.Booking;
import O_CultFitDesign.Booking.BookingTypeEnum;
import O_CultFitDesign.User.User;
import O_CultFitDesign.WorkOuts.GymWorkOut;
import O_CultFitDesign.WorkOuts.WorkOut;
import O_CultFitDesign.WorkOuts.WorkOutType;
import O_CultFitDesign.WorkOuts.YogaWorkOut;

import java.util.HashMap;
import java.util.Map;

public class Gym {

    private Map<WorkOutType, WorkOut> typeWorkOutMap;
    private String gymName;
    private int gymId;

    public Gym(String gymName, int gymId) {
        this.gymName = gymName;
        this.gymId = gymId;
        this.typeWorkOutMap = new HashMap<>();
        initializeWorkout();
    }

    public void initializeWorkout(){
        WorkOut gymWorkOutworkOut = new GymWorkOut(WorkOutType.GYM);

        Slot slot1 = new Slot(101,1,2,50);
        Slot slot2 = new Slot(102,2,3,50);
        Slot slot3 = new Slot(103,3,4,50);

        gymWorkOutworkOut.addSlot(slot1);
        gymWorkOutworkOut.addSlot(slot2);
        gymWorkOutworkOut.addSlot(slot3);
        typeWorkOutMap.put(WorkOutType.GYM,gymWorkOutworkOut);


        WorkOut yogaWorkOutworkOut = new YogaWorkOut(WorkOutType.YOGA);

        Slot slot4 = new Slot(104,1,2,50);
        Slot slot5 = new Slot(105,2,3,50);
        Slot slot6 = new Slot(106,3,4,50);

        yogaWorkOutworkOut.addSlot(slot1);
        yogaWorkOutworkOut.addSlot(slot2);
        yogaWorkOutworkOut.addSlot(slot3);

        typeWorkOutMap.put(WorkOutType.YOGA,yogaWorkOutworkOut);
    }

    public void addSlot(Slot slot, WorkOutType workOutType){
        WorkOut workOut = this.typeWorkOutMap.get(workOutType);
        workOut.addSlot(slot);
        System.out.println("GYM::addSlot - requested slot added successfully");
    }

    public void cancelSlot(Slot slot, WorkOutType workOutType){
        WorkOut workOut = this.typeWorkOutMap.get(workOutType);
        workOut.cancelSlot(slot.getSlotId());
        System.out.println("GYM::cancelSlot - requested slot cancelled successfully");
    }

    public int bookSlot(int startTime, int endTime, WorkOutType workOutType, User user){
        WorkOut workOut = typeWorkOutMap.get(workOutType);
        if(!workOut.availableSlotsList().isEmpty()){
            Slot slot = workOut.findSlot(startTime,endTime);
            boolean bookingDone = workOut.bookSlot(slot.getSlotId(),user);
            if(bookingDone){
                int bookingId = (int) ( Math.random() * 1000 );
                System.out.println("GYM::bookSlot - random generated bookingId : "+bookingId);
                Booking booking = new Booking(bookingId,slot, BookingTypeEnum.CONFIRMED,this.gymId,workOutType);
                user.addBooking(booking);
                System.out.println("GYM::bookSlot - booked the requested slot : "+slot);
                return bookingId;
            }
        }
        return 0;
    }

    public void cancelBookedSlot(Slot slot, WorkOutType workOutType, User user,int gymId){
        WorkOut workOut = this.typeWorkOutMap.get(workOutType);
        workOut.cancelBooking(slot.getSlotId(),user,gymId);
        System.out.println("GYM::cancelSlot - requested slot cancelled successfully");
    }


    public Map<WorkOutType, WorkOut> getTypeWorkOutMap() {
        return typeWorkOutMap;
    }

    public void setTypeWorkOutMap(Map<WorkOutType, WorkOut> typeWorkOutMap) {
        this.typeWorkOutMap = typeWorkOutMap;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }
}
