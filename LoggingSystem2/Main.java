package LoggingSystem2;

import LoggingSystem2.Log.InfoLog;
import LoggingSystem2.Log.WarningLog;
import LoggingSystem2.Output.ConsoleDestination;
import LoggingSystem2.Output.FileDestination;
import LoggingSystem2.Output.OutputDestination;

public class Main {
    public static void main(String[] args) {

        LogManager manager = LogManager.getInstance();
        Logger logger1 = manager.createLogger(new WarningLog());
        
        OutputDestination od1 = new ConsoleDestination();
        OutputDestination od2 = new FileDestination("a.txt");
        OutputDestination od3 = new FileDestination("b.txt");

        logger1.addObserver(od1);
        logger1.addObserver(od2);
        

        logger1.notifyObserver("This is a warning message");

        logger1.addObserver(od3);
        logger1.changeLogLevel("");
        logger1.changeLogLevel("New Fatal occured");

        Logger logger2 = manager.createLogger(new InfoLog());
        logger2.addObserver(od2);
        logger2.notifyObserver("Info log at Main.java");
    }
}
