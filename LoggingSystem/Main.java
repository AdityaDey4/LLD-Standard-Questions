package LoggingSystem;

import java.util.ArrayList;
import java.util.List;

import LoggingSystem.Enum.LogLevel;
import LoggingSystem.Output.ConsoleDestination;
import LoggingSystem.Output.FileDestination;
import LoggingSystem.Output.OutputDestination;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        List<OutputDestination> list = new ArrayList<>();
        list.add(new ConsoleDestination());
        list.add(new FileDestination("xyz.txt"));

        LogManager logManager = new LogManager(LogLevel.WARNING, list);
        logManager.log("Testing Logging System", LogLevel.DEBUG);
        logManager.log("Hello, How are you", LogLevel.WARNING);
        logManager.log("Thank You", LogLevel.FATAL);

        logManager.changeCurrentLogLevel(LogLevel.DEBUG);
        logManager.log("Testing Logging System", LogLevel.DEBUG);
        logManager.log("Hello, How are you", LogLevel.WARNING);
        logManager.log("Thank You", LogLevel.FATAL);
    }
}
