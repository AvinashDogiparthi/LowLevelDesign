package LoggerDesign.Logger;

import LoggerDesign.LoggerEnum;

public class DebugLogger extends Logger{

    public DebugLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public boolean canHandle(LoggerEnum type) {
        return LoggerEnum.DEBUG == type;
    }

    @Override
    public void write(String message) {
        System.out.println("DEBUG : Writing started");
        System.out.println("DEBUG : "+message);

        System.out.println("Writing ended");
    }
}
