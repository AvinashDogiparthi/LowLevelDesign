package LoggerDesign.Logger;

import LoggerDesign.LoggerEnum;

public class InfoLogger extends Logger{

    private static final String INFO = "INFO";

    public InfoLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public boolean canHandle(LoggerEnum type) {
        return LoggerEnum.INFO == type;
    }

    @Override
    public void write(String message) {
        System.out.println("INFO : Writing started");
        System.out.println("INFO : " + message);

        System.out.println("Writing ended");
    }
}
