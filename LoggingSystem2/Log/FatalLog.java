package LoggingSystem2.Log;

import LoggingSystem2.Enum.LogLevel;

public class FatalLog extends Log {

    public FatalLog() {
        super(LogLevel.FATAL);
    }

    @Override
    public Log getNextLogLevel() {
        return null;
    }
}
