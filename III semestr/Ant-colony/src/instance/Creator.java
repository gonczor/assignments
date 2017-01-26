package instance;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import settings.Settings;



public class Creator {

    public static void main(String[] args) {
        PrintWriter out;
        try {

            out = new PrintWriter(new FileWriter(Settings.readInstancesFileName,false));

            Random generator = new Random();
            int startMaintenanceTime = (Settings.numberOfTasks  * Settings.maxExecTime)/20;
            int numberOfMaintenance = generator.nextInt(5) + Settings.numberOfTasks / 5;

            int duration1operation, duration2operation;          //first and second operation duration
            int machine1operation, machine2operation;            //which machine to operation first and second

            out.println(Settings.numberOfTasks);
            for(int i = 0; i< Settings.numberOfTasks; i++) {

                duration1operation = generator.nextInt(Settings.maxExecTime)+1;
                machine1operation = generator.nextInt(2);
                duration2operation = generator.nextInt(Settings.maxExecTime)+1;
                machine2operation = 1-machine1operation;
                machine1operation++;
                machine2operation++;
                out.println(duration1operation + ";"
                        + duration2operation + ";"
                        + machine1operation + ";"
                        + machine2operation+";");

            }

            int start= startMaintenanceTime;
            int duration=0;

            for(int i = 0; i< numberOfMaintenance; i++) {
                start = generator.nextInt(220)+start + duration ;
                duration = generator.nextInt(Settings.maxMaintenanceTime);
                out.println(i + ";1;" + duration + ";" + start);

                start = generator.nextInt(220)+start + duration ;
                duration = generator.nextInt(Settings.maxMaintenanceTime);
                out.println((i + numberOfMaintenance) + ";2;" + duration + ";" + start);
            }

            out.close();

        }
        catch (IOException e){
            System.err.println(e.getMessage());
            StackTraceElement[] trace = e.getStackTrace();
            for(StackTraceElement element: trace)
                System.err.println(element.toString());
            System.exit(1);
        }
    }

}
