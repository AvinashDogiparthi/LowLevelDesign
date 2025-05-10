package O_CultFitDesign.WorkOuts;

import O_CultFitDesign.Slot;
import O_CultFitDesign.User.User;

import java.util.List;

public interface WorkOut {

    void addSlot(Slot slot);

    void cancelSlot(int slotId);

    void displaySlots();

    boolean bookSlot(int slotId, User user);

    void cancelBooking(int slotId, User user, int gymId);

    Slot findSlot(int startTime, int endTime);

    List<Slot> availableSlotsList();
}
