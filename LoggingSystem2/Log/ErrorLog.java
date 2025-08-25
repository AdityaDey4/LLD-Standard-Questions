package LoggingSystem2.Log;

import LoggingSystem2.Enum.LogLevel;

public class ErrorLog extends Log {

    public ErrorLog() {
        super(LogLevel.ERROR);
    }

    @Override
    public Log getNextLogLevel() {
        return new FatalLog();
    }
    
}
