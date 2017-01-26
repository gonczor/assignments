package ant;

import machine.Solution;
import settings.Settings;

public class PhermoneMatrix {

    public static void initializeMatrix(){
        matrix = new double[Settings.numberOfTasks*2][Settings.numberOfTasks*2];
        for(int i = 0; i < Settings.numberOfTasks*2; i++)
            for(int j = 0; j < Settings.numberOfTasks*2; j++)
                matrix[i][j] = (double) 1 / (Settings.numberOfTasks*2);
    }
    // row number is "from" operation
    // column number is "to" operation
    private static double[][] matrix;

    private static void increasePheromone(int from , int to, int iteration){
        matrix[from][to] = matrix[from][to]+Settings.extraPheromonePerIteration *iteration;
    }

    static double getPhermoneLevelBetweenOperations(int fromOperationId, int toOperationId){
        return matrix[fromOperationId][toOperationId];
    }

    public static void addNewPheromoneToTheMatrix(Solution solution, int iteration){
        for(int k=0;k<solution.getMachine1Jobs().size()-1;k++){
            if(!solution.getMachine1Jobs().get(k).isMaintenance() && !solution.getMachine1Jobs().get(k + 1).isMaintenance()){
                int from = solution.getMachine1Jobs().get(k).getId();
                int to = solution.getMachine1Jobs().get(k+1).getId();
                increasePheromone(from,to,iteration);
            }
        }

        for(int k=0;k<solution.getMachine2Jobs().size()-1;k++){
            if(!solution.getMachine2Jobs().get(k).isMaintenance() && !solution.getMachine2Jobs().get(k + 1).isMaintenance()){
                int from = solution.getMachine2Jobs().get(k).getId();
                int to = solution.getMachine2Jobs().get(k+1).getId();
                increasePheromone(from,to,iteration);
            }
        }
    }


    public static void decreasePheromoneLevel(){
        for(int i=0; i<Settings.numberOfTasks*2;i++){
            for(int k=0;k<Settings.numberOfTasks*2;k++){
                if(matrix[i][k] > Settings.minPheromoneInPheromoneMatrix) {
                    matrix[i][k] *= Settings.phermoneVaporizationRate;
                }
            }
        }
    }
}
