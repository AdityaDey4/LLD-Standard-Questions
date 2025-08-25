package LoggingSystem2.Output;

import LoggingSystem2.LogMessage;

public interface OutputDestination {
    void append(LogMessage lm);
}
