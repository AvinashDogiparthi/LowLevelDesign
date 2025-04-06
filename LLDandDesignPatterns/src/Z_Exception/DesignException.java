package Z_Exception;

public class DesignException extends RuntimeException{
    private DesignErrorEnum designErrorEnum;
    public DesignException(DesignErrorEnum errorEnum, String errorMessage){
         super(errorMessage);
         this.designErrorEnum = errorEnum;
    }
}
