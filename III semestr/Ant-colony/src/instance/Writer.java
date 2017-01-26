package instance;

import machine.MachineJob;
import machine.Solution;
import settings.Settings;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {
    public static void clearFileToWriteSolution(){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(Settings.writeResultToFileName, false));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();

    }

    public static void writeFirstSolutionTime(Solution solution){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(Settings.writeResultToFileName, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println((solution.getSolutionDurationTime1Machine()+solution.getSolutionDurationTime2Machine()));
        out.close();

    }
    public static void writeSolutions(Solution solution) {
        writeFirstSolutionTime(solution);
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(Settings.writeResultToFileName, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
            solution.sortSolution();

            ArrayList<MachineJob> machine2Jobs = solution.getMachine2Jobs();
            ArrayList<MachineJob> machine1Jobs = solution.getMachine1Jobs();

            out.print("M1: ");
            for (int i = 0; i < machine1Jobs.size(); i++) {
                if (machine1Jobs.get(i).isMaintenance() == false) {
                    out.print("o" + machine1Jobs.get(i).getWhichOperation() + "_" + machine1Jobs.get(i).getId() + "," + machine1Jobs.get(i).getStartTime() + "," + machine1Jobs.get(i).getDuration() + ";");
                }
                if (machine1Jobs.get(i).isMaintenance() == true) {
                    out.print("m" + machine1Jobs.get(i).getId() + "_" + machine1Jobs.get(i).getStartTime() + "," + machine1Jobs.get(i).getDuration() + ";");
                }


            }
            out.println("");
            out.print("M2: ");
            for (int i = 0; i < machine2Jobs.size(); i++) {
                if (machine2Jobs.get(i).isMaintenance() == false) {
                    out.print("o" + machine2Jobs.get(i).getWhichOperation() + "_" + machine2Jobs.get(i).getId() + "," + machine2Jobs.get(i).getStartTime() + "," + machine2Jobs.get(i).getDuration() + ";");
                }
                if (machine2Jobs.get(i).isMaintenance() == true) {
                    out.print("m" + machine2Jobs.get(i).getId() + "," + machine2Jobs.get(i).getStartTime() + "," + machine2Jobs.get(i).getDuration() + ";");
                }

            }
            out.println("");
            out.println(solution.getMaintenance1MachineQuantity() + "," + solution.getMaintenance1MachineDuration());
            out.println(solution.getMaintenance2MachineQuantity() + "," + solution.getMaintenance2MachineDuration());
            out.println(solution.getIdleQuantity1Machine() + "," + Math.abs(solution.getIdleTime1Machine()));
            out.println(solution.getIdleQuantity2Machine() + "," + Math.abs(solution.getIdleTime2Machine()));


            out.close();

        }
}

