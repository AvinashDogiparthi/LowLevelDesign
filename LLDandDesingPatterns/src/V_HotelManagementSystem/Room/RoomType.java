package V_HotelManagementSystem.Room;

public enum RoomType {

    SINGLE_BED("Single Bed",1000),
    DOUBLE_BED("Double Bed",2000),
    SUITE("Suite",5000),
    SEA_FACED("SeaFaced", 4000);

    private String type;
    private int price;

    private RoomType(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
