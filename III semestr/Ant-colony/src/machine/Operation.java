package machine;

public class Operation extends MachineJob{
    public Operation(int whichOperation, int id, int duration, int machineNumber) {
        this.whichOperation = whichOperation;
        this.id =id;
        this.duration = duration;
        this.machineNumber = machineNumber;
    }

    @Override
    public boolean isMaintenance(){
        return false;
    }

    public int getMachineNumber(){
        return machineNumber;
    }
    public void setStartTime(int time)
    {
        this.startTime = time;
    }
}
