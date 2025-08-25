package LoggingSystem.Output;

import java.io.FileWriter;
import java.io.IOException;

import LoggingSystem.LogMessage;

public class FileDestination implements OutputDestination {

    String fileName;
    public FileDestination(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void append(LogMessage lm) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(lm.printLogMessage()+"\n");
            writer.close(); // Important to close the writer to ensure data is flushed
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
    
}
