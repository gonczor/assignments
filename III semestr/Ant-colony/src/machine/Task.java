package machine;

public class Task{
    /**
     * Two operations, where operation1 is always done before operation 2
     */
    private Operation operation1;
    private Operation operation2;
    public void addFirstOperation(int id , int duration, int machineNumber) {
        operation1 = new Operation(1, id, duration, machineNumber);
    }
    public void addSecondOperation(int id , int duration, int machineNumber) {
        operation2 = new Operation(2, id, duration, machineNumber);
    }

    public Operation getOperation1(){
        return operation1;
    }

    public Operation getOperation2(){
        return operation2;
    }

    public int getFirstOperationMachineNumber(){
        return operation1.getMachineNumber();
    }

    public int getSecondOperationMachineNumber(){
        return operation2.getMachineNumber();
    }
}
