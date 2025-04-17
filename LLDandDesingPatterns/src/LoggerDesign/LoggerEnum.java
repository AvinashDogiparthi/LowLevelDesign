package LoggerDesign;

public enum LoggerEnum {
    FATAL("FATAL",1),
    WARNING("WARNING",2),
    INFO("INFO",3),
    DEBUG("DEBUG",4),
    ERROR("ERROR",5),
    FILE("FILE",6),
    CONSOLE("CONSOLE",7),
    DB("DB",8);

    private String type;

    private int logLevel;

    public void setType(String type) {
        this.type = type;
    }

    public int getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
    }

    LoggerEnum(String type, int logLevel) {
        this.type = type;
        this.logLevel =  logLevel;
    }

    public String getType() {
        return type;
    }
}
