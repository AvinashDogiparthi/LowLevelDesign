package CA_ParkingLotDesign_V2.Parking;

public class ParkingTicket {

    private int floorNo;
    private int spotNo;
    private int entryTime;
    private int exitTime;
    private int ticketID;

    public ParkingTicket(int floorNo, int spotNo, int entryTime, int exitTime, int ticketID) {
        this.floorNo = floorNo;
        this.spotNo = spotNo;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.ticketID = ticketID;
    }

    public ParkingTicket(int floorNo, int spotNo, int entryTime, int ticketID) {
        this.floorNo = floorNo;
        this.spotNo = spotNo;
        this.entryTime = entryTime;
        this.ticketID = ticketID;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }

    public int getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }

    public int getExitTime() {
        return exitTime;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
}
