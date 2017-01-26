import ant.Ant;
import ant.PhermoneMatrix;
import instance.Reader;
import instance.Writer;
import machine.Maintenance;
import machine.Solution;
import machine.Task;
import instance.Creator;
import settings.Settings;
import utils.Timer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class ACS {
    private static ArrayList<Task> tasks;
    private static ArrayList<Maintenance> maintenances;
    private static int solutionBestTime;
    // Used between phermone matrix resets to allow more time for search for improvements
    private static int localBestTime;
    private static int localIteration;
    private static int lastLocalImprovedIteration;
    private static int lastImprovedIteration;
    private static boolean createNewInstances = false;
    private static Solution bestSolution;

    public static void main(String[] args) {
        parseArgs(args);
        try {
            if(createNewInstances){
                Creator.main(null);
            }
            tasks = Reader.readTasks(Settings.readInstancesFileName);
            PhermoneMatrix.initializeMatrix();
            maintenances = Reader.readMaintences(Settings.readInstancesFileName);

            Timer timer = new Timer();
            int i=0;
            localIteration = 0;
            lastLocalImprovedIteration = 0;
            lastImprovedIteration = 0;
            Writer.clearFileToWriteSolution();

            while(timer.hasTimeLeft()){
                runAnts(i);
                PhermoneMatrix.decreasePheromoneLevel();
                i++;
                localIteration++;
            }


        } catch (IOException e) {
            System.err.println(e.getMessage());
            StackTraceElement[] trace = e.getStackTrace();
            for(StackTraceElement element: trace)
                System.err.println(element.toString());
            System.exit(1);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    private static void parseArgs(String[] args){
        System.out.println(args.length);
        if(args.length > 0){
            Settings.readInstancesFileName = args[0];
            Settings.writeResultToFileName = args[1];
        }
        if(args.length == 3){
            if(args[2].equals("create")){
                createNewInstances = true;
            }
        }
    }


    private static void runAnts(int iteration) throws Exception{
        // TODO Saving best solution per iteration
        for (int i = 0; i < Settings.numberOfAntsPerIteration; i++) {
            Ant ant = new Ant(tasks);
            Solution solution = new Solution();
            putMaintenanceIntoSolution(solution);
            ant.putTasksIntoSolution(solution);
            // In first iteration we need to save solution time to have time to compare to
            if(iteration == 0 && i == 0){
                solutionBestTime = solution.getEntireSolutionDuration();
                bestSolution = solution;
                Writer.writeFirstSolutionTime(solution);
                localBestTime = solutionBestTime = solution.getEntireSolutionDuration();
            }
            if(localIteration == 0){
                localBestTime = solution.getEntireSolutionDuration();
            }
            updatePhermoneMatrix(solution, iteration);
            updateBestSolution(solution, iteration);
            resetPhermoneMatrixIfNoImprovementAreMade(iteration);
        }
    }

    private static void updatePhermoneMatrix(Solution solution, int iteration){
        if (solutionDurationIsWithinLimitsForSavingPhermone(solution))
            PhermoneMatrix.addNewPheromoneToTheMatrix(solution, iteration);
    }

    private static void updateBestSolution(Solution solution, int iteration){
        if (solutionImproved(solution)) {
            lastImprovedIteration = iteration;
            lastLocalImprovedIteration = localIteration;
            localBestTime = solutionBestTime = solution.getEntireSolutionDuration();
            System.out.println(solutionBestTime + "\t" + iteration );
            Writer.writeSolutions(solution);
        }
        else if(localSolutionImproved(solution)){
            lastLocalImprovedIteration = localIteration;
            localBestTime = solution.getEntireSolutionDuration();
        }
    }

    private static boolean solutionImproved(Solution solution){
        return solution.getEntireSolutionDuration() < solutionBestTime;
    }

    private static boolean localSolutionImproved(Solution solution){
        return solution.getEntireSolutionDuration() < localBestTime;
    }

    private static boolean solutionDurationIsWithinLimitsForSavingPhermone(Solution solution){
        return solution.getEntireSolutionDuration() < solutionBestTime * Settings.gammaParameter;
    }

    // reset matrix:
    // if no local improvements appear after Settings.maximumIterationsForImprovement local iterations
    // if no global improvements appear, after 2xmaximumIterations... global iterations
    private static void resetPhermoneMatrixIfNoImprovementAreMade(int currentIteration){
        if(lastLocalImprovedIteration + Settings.maximumIterationsForImprovment < localIteration) {
            localIteration = 0;
            lastLocalImprovedIteration = 0;
            lastImprovedIteration = currentIteration;
            PhermoneMatrix.initializeMatrix();
            // System.out.println("Local reset at: " + currentIteration);
        }
        if (lastImprovedIteration + 2*Settings.maximumIterationsForImprovment < currentIteration) {
            PhermoneMatrix.initializeMatrix();
            PhermoneMatrix.initializeMatrix();
            localIteration = 0;
            lastImprovedIteration = currentIteration;
            // System.out.println("Reset at: " + currentIteration);
        }
    }

    private static void putMaintenanceIntoSolution(Solution solution){
        ArrayList <Maintenance> machineOneMaintenance = new ArrayList<>();
        ArrayList <Maintenance> machineTwoMaintenance = new ArrayList<>();

        divideMaintenanceByMachines(machineOneMaintenance, machineTwoMaintenance);
        sortMachineMaintenances(machineOneMaintenance, machineTwoMaintenance);
        for (Maintenance m: machineOneMaintenance){
            solution.addMachineOneJob(m);
        }
        for (Maintenance m: machineTwoMaintenance){
            solution.addMachineTwoJob(m);
        }
    }

    private static void divideMaintenanceByMachines(ArrayList<Maintenance> m1, ArrayList<Maintenance> m2){
        for(Maintenance m : maintenances){
            if(m.getMachineNumber() == 1)
                m1.add(m);
            else
                m2.add(m);
        }
    }

    private static void sortMachineMaintenances(ArrayList<Maintenance> m1, ArrayList<Maintenance> m2){
        Collections.sort(m1);
        Collections.sort(m2);
    }

}
