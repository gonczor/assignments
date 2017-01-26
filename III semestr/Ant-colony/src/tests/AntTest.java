package tests;

import ant.Ant;
import ant.PhermoneMatrix;
import instance.Creator;
import instance.Reader;
import machine.MachineJob;
import machine.Maintenance;
import machine.Solution;
import machine.Task;
import org.junit.Before;
import org.junit.Test;
import settings.Settings;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class AntTest {
    private static ArrayList<Solution> solutions;
    private static ArrayList<Task> tasks;
    private static ArrayList<Maintenance> maintenances;
    private static Ant ant;
    @Before
    public void createTasksAndMaintenance(){
        try {
            Settings.readInstancesFileName = "src/tests/testdata/read.txt";
            Creator.main(null);
            tasks = Reader.readTasks("src/tests/testdata/read.txt");
            PhermoneMatrix.initializeMatrix();
            maintenances = Reader.readMaintences("src/tests/testdata/read.txt");
            ant = new Ant(tasks);
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }

    }
    @Test
    public void putTasksIntoSolutionShouldPlaceFirstOperationsBeforeSecond() throws Exception {

        Solution solution = new Solution();
        ant.putTasksIntoSolution(solution);

        for(int i = 0; i < solution.getMachine1Jobs().size(); i++){
            if(!solution.getMachine1Jobs().get(i).isMaintenance() &&
                    solution.getMachine1Jobs().get(i).getWhichOperation() == 2){

                int previousId = solution.getMachine1Jobs().get(i).getId() - Settings.numberOfTasks;
                for(MachineJob mj : solution.getMachine2Jobs()){
                    if(!mj.isMaintenance() && mj.getId() == previousId){
                        assertTrue(mj.getStartTime() + mj.getDuration() <
                                solution.getMachine1Jobs().get(i).getStartTime());
                    }
                }
            }
        }
        for(int i = 0; i < solution.getMachine2Jobs().size(); i++){
            if(!solution.getMachine2Jobs().get(i).isMaintenance() &&
                    solution.getMachine2Jobs().get(i).getWhichOperation() == 2){

                int previousId = solution.getMachine2Jobs().get(i).getId() - Settings.numberOfTasks;
                for(MachineJob mj : solution.getMachine1Jobs()){
                    if(!mj.isMaintenance() && mj.getId() == previousId){
                        assertTrue(mj.getStartTime() + mj.getDuration() <
                                solution.getMachine2Jobs().get(i).getStartTime());
                    }
                }
            }
        }
    }

    @Test
    public void putTasksIntoSolutionShouldNotPlaceJobsInSameTime() throws Exception{
        Solution solution = new Solution();
        ant.putTasksIntoSolution(solution);

        for(int i = 0; i < solution.getMachine1Jobs().size() - 1; i++){
            int firstJobEndTime = solution.getMachine1Jobs().get(i).getStartTime() +
                    solution.getMachine1Jobs().get(i).getDuration();
            int secondJobStartTime = solution.getMachine1Jobs().get(i+1).getStartTime();
            assertTrue(firstJobEndTime < secondJobStartTime);
        }

        for(int i = 0; i < solution.getMachine2Jobs().size() - 1; i++){
            int firstJobEndTime = solution.getMachine2Jobs().get(i).getStartTime() +
                    solution.getMachine2Jobs().get(i).getDuration();
            int secondJobStartTime = solution.getMachine2Jobs().get(i+1).getStartTime();
            assertTrue(firstJobEndTime < secondJobStartTime);
        }
    }

}