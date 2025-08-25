package LoggingSystem2.Log;

import LoggingSystem2.Enum.LogLevel;

public class DebugLog extends Log {

    public DebugLog() {
        super(LogLevel.DEBUG);
    }

    @Override
    public Log getNextLogLevel() {
        return new InfoLog();
    }
}
