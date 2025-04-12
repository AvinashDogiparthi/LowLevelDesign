package LoggerDesign.Logger;

import LoggerDesign.LoggerEnum;

public class WarningLogger extends Logger{

    private static final String WARNING = "WARNING";

    public WarningLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public boolean canHandle(LoggerEnum type) {
        return LoggerEnum.WARNING == type;
    }

    @Override
    public void write(String message) {
        System.out.println("WARNING : Writing started");
        System.out.println("WARNING : " + message);
        System.out.println("Writing ended");
    }
}
