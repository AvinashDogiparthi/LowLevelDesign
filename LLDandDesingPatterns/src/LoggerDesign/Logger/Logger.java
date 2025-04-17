package LoggerDesign.Logger;

import LoggerDesign.LoggerEnum;

import java.time.Instant;

public abstract class Logger {
    Logger nextLogger;

    public void printLog(LoggerEnum type, String message){
        if(canHandle(type)){
            System.out.println("Current Log Level is + "+type.getLogLevel() + " and Current Time Stamp is : "+ Instant.now());
            write(message);
        } else if(nextLogger != null){
            nextLogger.printLog(type,message);
        }
    }

    abstract boolean canHandle(LoggerEnum type);

    abstract void write(String message);
}
