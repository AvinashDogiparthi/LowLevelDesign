package Exception;

public enum DesignErrorEnum {

    VIOLATES_LISKOV_SUBSTITUTION_PRINCIPLE(1,"Current Design is violating liskov substitution principle"),
    UNKNOWN_PAYMENT_METHOD(2,"Unknown selected payment method"),
    ACCESS_DENIED(3,"User is not authorized to perform this action");

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
