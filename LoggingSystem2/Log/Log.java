package LoggingSystem2.Log;

import LoggingSystem2.Enum.LogLevel;

public abstract class Log {

    private LogLevel logLevel;
    Log(LogLevel level) {
        this.logLevel = level;
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public abstract Log getNextLogLevel();
}
