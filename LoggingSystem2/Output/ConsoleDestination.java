package LoggingSystem2.Output;

import LoggingSystem2.LogMessage;

public class ConsoleDestination implements OutputDestination {

    @Override
    public void append(LogMessage lm) {
        System.out.println(lm.printLogMessage());
    }
    
}


