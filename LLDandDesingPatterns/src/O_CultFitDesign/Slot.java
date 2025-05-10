package O_CultFitDesign;

import O_CultFitDesign.User.User;

import java.util.*;

public class Slot {

    private int slotId;
    private int startTime;
    private int endTime;
    private int currentCapacity;
    private int availableCapacity;
    private List<User> registeredUsers;
    private Queue<User> waitListQueue;

    public Slot(int id, int startTime, int endTime, int capacity) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.currentCapacity = 0;
        this.availableCapacity = capacity;
        this.waitListQueue = new LinkedList<>();
        this.registeredUsers = new ArrayList<>();
        this.slotId = id;
    }

    public Queue<User> getWaitListQueue() {
        return waitListQueue;
    }

    public void addUserInQueue(User user){
        this.waitListQueue.add(user);
        System.out.println("Slot::addUserInQueue - Due to un-availability user registration was on-hold");
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public void addRegisteredUser(User user){

        if(currentCapacity == availableCapacity){
            System.out.println("Slot::addRegisteredUser - Capacity is full, please wait or check for another slot");
            return;
        }

        this.registeredUsers.add(user);
        this.currentCapacity = currentCapacity + 1;
        System.out.println("Slot::addRegisteredUser - Added registered user into slot");
    }

    public void removeRegisteredUser(User user){
        this.registeredUsers.remove(user);
        this.currentCapacity = currentCapacity - 1;
        System.out.println("Slot::removeRegisteredUser - removed registered user from slot");
    }

    public User removeUserFromQueue(){
        User removedUser = waitListQueue.poll();
        System.out.println("Slot::removeUserFromQueue - Removed user from the waitingList queue for further processing");
        return removedUser;
    }

    public void setWaitListQueue(Queue<User> waitListQueue) {
        this.waitListQueue = waitListQueue;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", currentCapacity=" + currentCapacity +
                ", availableCapacity=" + availableCapacity +
                ", registeredUsers=" + registeredUsers +
                ", waitListQueue=" + waitListQueue +
                '}';
    }
}
