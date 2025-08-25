package LoggingSystem2;

import LoggingSystem2.Log.Log;

public class LogManager {
    
    private static volatile LogManager instance;
    private LogManager() {}

    public static LogManager getInstance() {
        if (instance == null) {
            synchronized (LogManager.class) {
                if (instance == null) instance = new LogManager();
            }
        }
        return instance;
    }

    public Logger createLogger(Log log) {
        Logger logger = new Logger(log);
        return logger;
    }
}
