package ant;

import machine.MachineJob;
import machine.Operation;
import machine.Solution;
import machine.Task;
import settings.Settings;

import java.util.ArrayList;
import java.util.Random;

public class Ant{
    private Random random = new Random();
    private ArrayList<Operation> operationsToAssign1Machine, operationsToAssign2Machine;
    private Operation lastOperationOnFirstMachine, lastOperationOnSecondMachine;

    public Ant(ArrayList<Task> tasks){
        operationsToAssign1Machine = new ArrayList<>();
        operationsToAssign2Machine = new ArrayList<>();
        separateTasksOnTheMachine(tasks);
    }

    private void separateTasksOnTheMachine( ArrayList<Task> tasks) {

        for (Task task : tasks) {
            if (task.getFirstOperationMachineNumber() == 1) {
                operationsToAssign1Machine.add(task.getOperation1());
            } else {
                operationsToAssign2Machine.add(task.getOperation1());
            }

            if (task.getSecondOperationMachineNumber() == 1) {
                operationsToAssign1Machine.add(task.getOperation2());
            } else {
                operationsToAssign2Machine.add(task.getOperation2());
            }
        }
    }

    private double getSumOfProbability(Operation currentOperation , ArrayList<Operation> operations) {
        double sum =0;
        for (Operation nextOperation : operations) {
            if(!currentOperation.equals(nextOperation))
                sum += PhermoneMatrix.getPhermoneLevelBetweenOperations(currentOperation.getId(), nextOperation.getId());
        }
        return sum;
    }

    private void removeOperationFromList(Operation operation, ArrayList<Operation> list){
        list.remove(operation);
    }

    private boolean firstOperationHasBeenAssigned(Operation secondOperation, Solution solution){
        int firstOperationId = secondOperation.getId() - Settings.numberOfTasks;
        for(MachineJob mj : solution.getMachine1Jobs()){
            if(!mj.isMaintenance() && mj.getId() == firstOperationId )
                return true;
        }
        for(MachineJob mj : solution.getMachine2Jobs()){
            if(!mj.isMaintenance() && mj.getId() == firstOperationId )
                return true;
        }
        return false;
    }

    private boolean minimumProbabilityReached(double minimumProbability, double currentProbability){
        return currentProbability > minimumProbability;
    }

    private double getCurrentProbabilityLevel(Operation currentOperation,
                                              Operation nextOperation,
                                              double probabilitySum){
        double pheromoneFromMatrix = PhermoneMatrix.getPhermoneLevelBetweenOperations(currentOperation.getId(),
                nextOperation.getId());
        return Settings.alphaProbability * pheromoneFromMatrix / probabilitySum;
    }

    private void addNextOperationToSolution(int machineNumber, Solution solution) {
        if (machineNumber == 1) {
            Operation operationToAssign = chooseOperationForMachineOne();
            if( operationToAssign != null ) {
                if (!(operationToAssign.getWhichOperation() == 2 &&
                        !firstOperationHasBeenAssigned(operationToAssign, solution))) {
                    insertNextOperationMachine1(operationToAssign, solution);
                }
            }
        }
        else {
            Operation operationToAssign = chooseOperationForMachineTwo();
            if( operationToAssign != null ) {
                if (!(operationToAssign.getWhichOperation() == 2 &&
                        !firstOperationHasBeenAssigned(operationToAssign, solution))) {

                    insertNextOperationMachine2(operationToAssign, solution);
                }
            }
        }
    }

    private Operation chooseOperationForMachineOne(){
        double summedProbabilityLevel = 0.0;
        double sumOfTheProbabilityList;
        double minimumProbability = random.nextDouble();
        Operation lastChosenOperation = null;

        sumOfTheProbabilityList = getSumOfProbability(lastOperationOnFirstMachine, operationsToAssign1Machine);

        for (Operation operationToAssign : operationsToAssign1Machine) {
            lastChosenOperation = operationToAssign;
            if (lastOperationOnFirstMachine.equals(operationToAssign))
                continue;

            summedProbabilityLevel += getCurrentProbabilityLevel(lastOperationOnFirstMachine,
                                                                 operationToAssign,
                                                                 sumOfTheProbabilityList);

            if (minimumProbabilityReached(minimumProbability, summedProbabilityLevel)) {
                return operationToAssign;
            }
        }

        return lastChosenOperation;
    }

    private Operation chooseOperationForMachineTwo(){
        double summedProbabilityLevel = 0.0;
        double sumOfTheProbabilityList;
        double minimumProbability = random.nextDouble();
        Operation lastChosenOperation = null;
        sumOfTheProbabilityList = getSumOfProbability(lastOperationOnSecondMachine, operationsToAssign1Machine);

        for (Operation operationToAssign2Machine : operationsToAssign2Machine) {
            lastChosenOperation = operationToAssign2Machine;
            if (lastOperationOnSecondMachine.equals(operationToAssign2Machine))
                continue;

            summedProbabilityLevel += getCurrentProbabilityLevel(lastOperationOnSecondMachine,
                                                                 operationToAssign2Machine,
                                                                 sumOfTheProbabilityList);

            if (minimumProbabilityReached(minimumProbability, summedProbabilityLevel)) {
                return operationToAssign2Machine;
            }
        }
        return lastChosenOperation;
    }

    private void insertFirstOperationToMachineOne(Operation operation, Solution solution){
        int i = 0;
        operation.setStartTime(0);
        while (i < solution.getMachine1Jobs().size() &&
                !operationFitsTimeGap(solution.getMachine1Jobs().get(i), operation)){
            operation.setStartTime(solution.getMachine1Jobs().get(i).getStartTime() +
                    solution.getMachine1Jobs().get(i).getDuration() + 1);
            i++;
        }
        solution.addMachineOneJobAtPosition(operation, i);
        removeOperationFromList(operation, operationsToAssign1Machine);
    }

    private void insertFirstOperationToMachineTwo(Operation operation, Solution solution){
        int i = 0;
        operation.setStartTime(0);
        while (i < solution.getMachine2Jobs().size() &&
                !operationFitsTimeGap(solution.getMachine2Jobs().get(i), operation)){

            operation.setStartTime(solution.getMachine2Jobs().get(i).getStartTime() +
                    solution.getMachine2Jobs().get(i).getDuration() + 1);
            i++;
        }
        solution.addMachineTwoJobAtPosition(operation, i);
        removeOperationFromList(operation, operationsToAssign2Machine);
    }

    private void insertNextOperationMachine1(Operation operationToInsert, Solution solution){
        int i = 0;

        // operation one is first operation for same task as operation 2.
        // preceding operation end time is end time for last operation on same machine
        int operationOneEndTime = 0;
        int precedingOperationEndTime = lastOperationOnFirstMachine.getStartTime() + lastOperationOnFirstMachine.getDuration();
        int minimalStartTime;
        // operation 1 from same task must have been inserted (check is in calling method), so no need to double check
        // and we can take it from already assigned operation list
        if(operationToInsert.getWhichOperation() == 2){
            for(int j = 0; j < solution.getMachine2Jobs().size(); j++){
                // get preceding operation end time
                if((solution.getMachine2Jobs().get(j).getId() == operationToInsert.getId() - Settings.numberOfTasks) &&
                        !solution.getMachine2Jobs().get(j).isMaintenance()){

                    operationOneEndTime = solution.getMachine2Jobs().get(j).getStartTime() +
                            solution.getMachine2Jobs().get(j).getDuration();
                    break;
                }
            }
        }
        minimalStartTime = Math.max(operationOneEndTime, precedingOperationEndTime);
        operationToInsert.setStartTime(minimalStartTime + 1);

        // iterate to first job that ends after minimal start time
        while(i < solution.getMachine1Jobs().size() &&
                (solution.getMachine1Jobs().get(i).getStartTime() + solution.getMachine1Jobs().get(i).getDuration() <
                        minimalStartTime)){
            i++;
        }

        while (i < solution.getMachine1Jobs().size() &&
                !operationFitsTimeGap(solution.getMachine1Jobs().get(i), operationToInsert)){

            operationToInsert.setStartTime(solution.getMachine1Jobs().get(i).getStartTime() +
                                           solution.getMachine1Jobs().get(i).getDuration() + 1);
            i++;
        }

        solution.addMachineOneJobAtPosition(operationToInsert, i);
        this.lastOperationOnFirstMachine = operationToInsert;
        removeOperationFromList(operationToInsert, operationsToAssign1Machine);
    }

    private void insertNextOperationMachine2(Operation operationToInsert,
                                             Solution solution){
        int i = 0;
        // operation one is first operation for same task as operation 2.
        // preceding operation end time is end time for last operation on same machine
        int operationOneEndTime = 0;
        int precedingOperationEndTime = lastOperationOnSecondMachine.getStartTime() + lastOperationOnSecondMachine.getDuration();
        int minimalStartTime;
        // operation 1 from same task must have been inserted (check is in calling method), so no need to double check
        // and we can take it from already assigned operation list
        if(operationToInsert.getWhichOperation() == 2){
            for(int j = 0; j < solution.getMachine1Jobs().size(); j++){
                if((solution.getMachine1Jobs().get(j).getId() == operationToInsert.getId() - Settings.numberOfTasks) &&
                        !solution.getMachine1Jobs().get(j).isMaintenance()){

                    operationOneEndTime = solution.getMachine1Jobs().get(j).getStartTime() +
                            solution.getMachine1Jobs().get(j).getDuration();
                    break;
                }
            }
        }
        minimalStartTime = Math.max(operationOneEndTime, precedingOperationEndTime);
        operationToInsert.setStartTime(minimalStartTime + 1);

        // iterate to first job that ends after minimal start time
        while(i < solution.getMachine2Jobs().size() &&
                (solution.getMachine2Jobs().get(i).getStartTime() + solution.getMachine2Jobs().get(i).getDuration() <
                minimalStartTime)){
            i++;
        }

        while (i < solution.getMachine2Jobs().size() &&
                !operationFitsTimeGap(solution.getMachine2Jobs().get(i), operationToInsert)){

            operationToInsert.setStartTime(solution.getMachine2Jobs().get(i).getStartTime() +
                                           solution.getMachine2Jobs().get(i).getDuration() + 1);
            i++;
        }

        solution.addMachineTwoJobAtPosition(operationToInsert, i);
        this.lastOperationOnSecondMachine = operationToInsert;
        removeOperationFromList(operationToInsert, operationsToAssign2Machine);
    }

    /**
     * Checks whether an operation with currently set start time finishes execution before next machine job (ie. either
     * operation or Maintenance) starts.
     * @param nextExecutedJob Maintenance or Operation that will be executed directly after currently set Operation
     * @param operationToFit operation we want to check. It needs to have startTime set.
     * @return true if operationToFit fits gap
     */
    private boolean operationFitsTimeGap(MachineJob nextExecutedJob, Operation operationToFit){
        return operationToFit.getStartTime() + operationToFit.getDuration() < nextExecutedJob.getStartTime();
    }

    public void putTasksIntoSolution(Solution solution){
        int randomIndex;

        // assign first operation to machine 1
        do{
            randomIndex = random.nextInt(Settings.numberOfTasks);
        }while (operationsToAssign1Machine.get(randomIndex).getWhichOperation()!=1);

        lastOperationOnFirstMachine = operationsToAssign1Machine.get(randomIndex);
        insertFirstOperationToMachineOne(operationsToAssign1Machine.get(randomIndex), solution);

        // assign first operation to machine 2
        do{
            randomIndex = random.nextInt(Settings.numberOfTasks);
        }while (operationsToAssign2Machine.get(randomIndex).getWhichOperation()!=1);

        lastOperationOnSecondMachine = operationsToAssign2Machine.get(randomIndex);
        insertFirstOperationToMachineTwo(operationsToAssign2Machine.get(randomIndex), solution);

        while (unassignedOperationExist()){
            addNextOperationToSolution(1, solution);
            addNextOperationToSolution(2, solution);
        }
    }

    private boolean unassignedOperationExist(){
        return operationsToAssign1Machine.size() > 0 || operationsToAssign2Machine.size() > 0;
    }
}