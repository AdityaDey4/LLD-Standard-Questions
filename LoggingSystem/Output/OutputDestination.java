package LoggingSystem.Output;

import LoggingSystem.LogMessage;

public interface OutputDestination {
    void append(LogMessage lm);
}
