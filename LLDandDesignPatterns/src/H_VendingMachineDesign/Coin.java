package H_VendingMachineDesign;

public enum Coin {
    ONE_RUPEE(1),
    TWO_RUPEE(2),
    THREE_RUPEE(3),
    FOUR_RUPEE(4),
    FIVE_RUPEE(5),
    SIX_RUPEE(6),
    SEVEN_RUPEE(7),
    EIGHT_RUPEE(8),
    NINE_RUPEE(9),
    TEN_RUPEE(10);

    public int value;

    Coin(int value){
        this.value = value;
    }
}
