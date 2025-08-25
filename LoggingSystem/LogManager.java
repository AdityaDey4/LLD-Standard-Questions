package LoggingSystem;


import java.util.List;


import LoggingSystem.Enum.LogLevel;
import LoggingSystem.Output.OutputDestination;

public class LogManager {

    List<OutputDestination> list;
    LogLevel currLogLevel;

    LogManager(LogLevel logLevel, List<OutputDestination> list) {
        this.currLogLevel = logLevel;
        this.list = list;
    }

    public void changeCurrentLogLevel(LogLevel level) {
        this.currLogLevel = level;
    }
    
    public synchronized void log(String message, LogLevel level) {
        if(level.ordinal() < currLogLevel.ordinal()) return;
        LogMessage logMessage = new LogMessage(message, level);
        for(OutputDestination od : list) {
            od.append(logMessage);
        }
    }
}
