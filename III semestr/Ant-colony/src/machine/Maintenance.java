package machine;

public class Maintenance extends MachineJob
        implements Comparable<Maintenance> {
    public Maintenance(int id, int startTime, int duration, int machineNumber) {
            this.id = id;
            this.startTime = startTime;
            this.duration = duration;
            this.machineNumber = machineNumber;
    }

    @Override
    public boolean isMaintenance(){
        return true;
    }

    @Override
    public int compareTo(Maintenance other) {
        return startTime.compareTo(other.startTime);
    }
}
