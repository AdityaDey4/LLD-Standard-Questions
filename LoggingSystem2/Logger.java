package LoggingSystem2;

import java.util.ArrayList;
import java.util.List;

import LoggingSystem2.Log.Log;
import LoggingSystem2.Output.OutputDestination;

public class Logger {
    
    Log currLog;
    List<OutputDestination> observers;

    Logger(Log currLog) {
        this.currLog = currLog;
        observers = new ArrayList<>();
    }

    public void addObserver(OutputDestination od) {
        this.observers.add(od);
    }

    public void changeLogLevel(String message) {
        currLog = currLog.getNextLogLevel();
        notifyObserver(message);
    }

    public void notifyObserver(String message) {

        if(message.length() == 0) return;
        
        LogMessage logMessage = new LogMessage(message, currLog.getLogLevel());
        for(OutputDestination od : observers) {
            od.append(logMessage);
        }
    }
}
