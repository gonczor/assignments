package instance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import machine.Maintenance;
import machine.Task;
import settings.Settings;

public class Reader {
    public static ArrayList<Task> readTasks(String fileName) throws IOException {
        String[] tempSplitArray ;
        int tasksQuantity;
        ArrayList<Task> returnedTaskList = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine;

        textLine = bufferedReader.readLine();
        tasksQuantity = Integer.parseInt(textLine);

        for(int i=0;i<tasksQuantity;i++) {
            textLine = bufferedReader.readLine();
            tempSplitArray = textLine.split(";");
                Task task = new Task();
                task.addFirstOperation(i,
                        Integer.parseInt(tempSplitArray[0]),
                        Integer.parseInt(tempSplitArray[2]));
                task.addSecondOperation(i + tasksQuantity,
                        Integer.parseInt(tempSplitArray[1]),
                        Integer.parseInt(tempSplitArray[3]));
                returnedTaskList.add(task);
        }

        bufferedReader.close();

        return returnedTaskList;
    }

    public static ArrayList<Maintenance> readMaintences(String fileName) throws IOException {
        String[] tempSplitArray ;
        int tasksQuantity;
        ArrayList<Maintenance> returnedMaintenanceList = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine;

        textLine = bufferedReader.readLine();
        tasksQuantity = Integer.parseInt(textLine);

        // Skip tasks
        for(int i=0; i<tasksQuantity; i++) {
            textLine = bufferedReader.readLine();
        }

        textLine = bufferedReader.readLine();
        do {
            tempSplitArray = textLine.split(";");
            Maintenance maintenance = new Maintenance(Integer.parseInt(tempSplitArray[0]),
                    Integer.parseInt(tempSplitArray[3]),
                    Integer.parseInt(tempSplitArray[2]),
                    Integer.parseInt(tempSplitArray[1]));

            returnedMaintenanceList.add(maintenance);

            textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();

        return returnedMaintenanceList;
    }

}
