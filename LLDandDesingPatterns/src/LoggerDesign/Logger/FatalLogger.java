package LoggerDesign.Logger;

import LoggerDesign.LoggerEnum;

public class FatalLogger extends Logger{

    private static final String FATAL = "FATAL";

    public FatalLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public boolean canHandle(LoggerEnum type) {
        return LoggerEnum.FATAL ==  type;
    }

    @Override
    public void write(String message) {
        System.out.println("FATAL : Writing started");
        System.out.println("FATAL : "+ message);

        System.out.println("Writing ended");
    }
}
