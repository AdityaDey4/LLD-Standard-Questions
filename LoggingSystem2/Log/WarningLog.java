package LoggingSystem2.Log;

import LoggingSystem2.Enum.LogLevel;

public class WarningLog extends Log {
    
    public WarningLog() {
        super(LogLevel.WARNING);
    }
    @Override
    public Log getNextLogLevel() {
        return new ErrorLog();
    }
}
