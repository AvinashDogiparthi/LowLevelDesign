package J_ATMDesign_V2;

public enum CurrencyNotesEnum {

    TWENTY(20),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    TWO_THOUSAND(2000);

    private int price;

    CurrencyNotesEnum(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
