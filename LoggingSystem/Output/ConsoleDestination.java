package LoggingSystem.Output;

import LoggingSystem.LogMessage;

public class ConsoleDestination implements OutputDestination {

    @Override
    public void append(LogMessage lm) {
        System.out.println(lm.printLogMessage());
         System.out.println("Successfully wrote to the console.");
    }
    
}
