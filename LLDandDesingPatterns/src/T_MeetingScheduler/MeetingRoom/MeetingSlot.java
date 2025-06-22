package T_MeetingScheduler.MeetingRoom;

import T_MeetingScheduler.User;

public class MeetingSlot {

    private Integer meetingSlotID;
    private Integer fromTime;
    private Integer toTime;
    private User meetingSlotManager;
    private boolean isOccupied;

    public MeetingSlot(int fromTime, int meetingSlotID) {
        this.meetingSlotID = meetingSlotID;
        this.fromTime = fromTime;
        this.toTime = fromTime + 1;
        this.isOccupied = isOccupied;
    }

    public int getFromTime() {
        return fromTime;
    }

    public void setFromTime(int fromTime) {
        this.fromTime = fromTime;
    }

    public int getToTime() {
        return toTime;
    }

    public void setToTime(int toTime) {
        this.toTime = toTime;
    }

    public User getMeetingSlotManager() {
        return meetingSlotManager;
    }

    public void setMeetingSlotManager(User meetingSlotManager) {
        this.meetingSlotManager = meetingSlotManager;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Integer getMeetingSlotID() {
        return meetingSlotID;
    }

    public void setMeetingSlotID(Integer meetingSlotID) {
        this.meetingSlotID = meetingSlotID;
    }
}
