package Z_Exception;

public enum DesignErrorEnum {

    VIOLATES_LISKOV_SUBSTITUTION_PRINCIPLE(1,"Current Design is violating liskov substitution principle"),
    UNKNOWN_PAYMENT_METHOD(2,"Unknown selected payment method"),
    ACCESS_DENIED(3,"User is not authorized to perform this action"),
    WRONG_STATE(4,"User is not allowed to perform current operation in this staete"),
    ITEM_EXIST(5,"Current Item shelf has item"),
    ITEM_SOLD_OUT(6,"Item already sold out"),
    INVALID_CODE(7,"Invalid Code"),
    INSUFFICIENT_AMOUNT(8,"Insufficient Amount"),
    INSUFFICIENT_AMOUNT_TO_BOOK_CAB(9,"Insufficient amount to book a cab");

    private int code;
    private String errorMessage;

    private DesignErrorEnum(int code, String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
