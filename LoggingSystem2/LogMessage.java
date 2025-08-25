package LoggingSystem2;

import java.time.LocalDateTime;
import LoggingSystem2.Enum.LogLevel;

public class LogMessage {
    LocalDateTime timestamp;
    String threadName;
    LogLevel logLevel;
    String message;

    LogMessage(String message, LogLevel level) {
        timestamp = LocalDateTime.now();
        threadName = Thread.currentThread().getName();
        logLevel = level;
        this.message = message;
    }

    public String printLogMessage() {
        return "Date : "+timestamp+", Thread Name : "+threadName+", Log Level : "+logLevel+", Message : "+message;
    }
}
