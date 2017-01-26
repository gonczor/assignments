package machine;

public abstract class MachineJob {
    protected Integer startTime = 0;
    protected int duration = 0;
    protected int id = 0;
    protected int machineNumber =0;
    protected int whichOperation ;

    public int getStartTime(){
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }
    public int getMachineNumber(){
        return machineNumber;
    }

    public int getWhichOperation() {
        return whichOperation;
    }

    public void setStartTime(int startTime){
        this.startTime = startTime;
    }

    public abstract boolean isMaintenance();
}
