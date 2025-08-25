package LoggingSystem2.Log;

import LoggingSystem2.Enum.LogLevel;

public class InfoLog extends Log {

    public InfoLog() {
        super(LogLevel.INFO);
    }

    @Override
    public Log getNextLogLevel() {
        return new WarningLog();
    }
}
