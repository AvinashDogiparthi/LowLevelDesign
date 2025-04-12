package LoggerDesign.Logger;

import LoggerDesign.LoggerEnum;

public class ErrorLogger extends Logger{

    private static final String ERROR = "ERROR";

    public ErrorLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public boolean canHandle(LoggerEnum type) {
        return LoggerEnum.ERROR == type;
    }

    @Override
    public void write(String message) {
        System.out.println("ERROR : Writing started");
        System.out.print("ERROR : "+message);

        System.out.println("Writing ended");
    }
}
