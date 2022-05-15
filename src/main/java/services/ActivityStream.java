package services;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ActivityStream {
    private static ActivityStream instance = new ActivityStream();
    private FileWriter csvWriter;

    private ActivityStream() {
        try{
            csvWriter = new FileWriter("src/main/resources/DateActivitate.csv", true);
        }
        catch(IOException e)
        {
            e.fillInStackTrace();
        }
    }
    public static ActivityStream getInstance(){
        return instance;
    }
    public void AddActivity(String name) {
        try {
            csvWriter.append(name + ",");
            csvWriter.append(LocalDateTime.now() + "\n");
            csvWriter.flush();
        }
        catch (IOException e)
        {
            e.fillInStackTrace();
        }
    }
}
