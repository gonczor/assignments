package machine;

import java.util.ArrayList;

public class Solution {

    public ArrayList<MachineJob> machine1Jobs;
    public ArrayList<MachineJob> machine2Jobs;


    public Solution(){
        machine2Jobs = new ArrayList<>();
        machine1Jobs = new ArrayList<>();
    }

    public int getMaintenance1MachineQuantity() {
        int maintenenceQuantity = 0;
        for (MachineJob machine1Job : machine1Jobs) {
            if (machine1Job.isMaintenance()) {
                maintenenceQuantity++;
            }
        }
        return maintenenceQuantity;
    }

    public int getMaintenance2MachineQuantity() {
        int maintenenceQuantity = 0;
        for (MachineJob machine2Job : machine2Jobs) {
            if (machine2Job.isMaintenance()) {
                maintenenceQuantity++;
            }
        }
        return maintenenceQuantity;
    }


    public int getMaintenance1MachineDuration() {
        int maintenenceQuantity = 0;
        for (MachineJob machine1Job : machine1Jobs) {
            if (machine1Job.isMaintenance()) {
                maintenenceQuantity += machine1Job.getDuration();
            }
        }
        return maintenenceQuantity;

    }
    public int getMaintenance2MachineDuration() {
        int maintenenceQuantity = 0;
        for (MachineJob machine2Job : machine2Jobs) {
            if (machine2Job.isMaintenance()) {
                maintenenceQuantity += machine2Job.getDuration();
            }
        }
        return maintenenceQuantity;

    }

    public ArrayList<MachineJob> getMachine1Jobs() {
        return machine1Jobs;
    }

    public ArrayList<MachineJob> getMachine2Jobs() {
        return machine2Jobs;
    }

    public void addMachineOneJob(MachineJob job){
        machine1Jobs.add(job);
    }

    public void addMachineTwoJob(MachineJob job){
        machine2Jobs.add(job);
    }

    public void addMachineOneJobAtPosition(MachineJob job, int position){
        machine1Jobs.add(position, job);
    }

    public void addMachineTwoJobAtPosition(MachineJob job, int position){
        machine2Jobs.add(position, job);
    }

    public int getEntireSolutionDuration(){
        return this.getSolutionDurationTime1Machine() + this.getSolutionDurationTime2Machine();
    }

    public int getSolutionDurationTime1MachineLastOperation(){
        int lastIndex = machine1Jobs.size()-1;
        while(machine1Jobs.get(lastIndex).isMaintenance()){
            lastIndex --;
        }
        return machine1Jobs.get(lastIndex).getStartTime() + machine1Jobs.get(lastIndex).getDuration();

    }

    public int getSolutionDurationTime2MachineLastOperation(){
        int lastIndex = machine2Jobs.size()-1;
        while(machine2Jobs.get(lastIndex).isMaintenance()){
            lastIndex --;
        }
        return machine2Jobs.get(lastIndex).getStartTime() + machine2Jobs.get(lastIndex).getDuration();

    }


    public int getSolutionDurationTime1Machine(){
        int sum = 0;
        for(int i=0 ; i<machine1Jobs.size();i++){
            if(machine1Jobs.get(i).isMaintenance()==false){
                sum += machine1Jobs.get(i).getStartTime() + machine1Jobs.get(i).getDuration();
            }
        }
        return sum;
    }

    public int getSolutionDurationTime2Machine(){
        int sum = 0;
        for(int i=0 ; i<machine2Jobs.size();i++){
            if(machine2Jobs.get(i).isMaintenance()==false){
                sum += machine2Jobs.get(i).getStartTime() + machine2Jobs.get(i).getDuration();
            }
        }
        return sum;

    }

    public int getOperationsDuration1Machine(){
        int sum =0;
        for (MachineJob machine1Job : machine1Jobs) {
            if (!machine1Job.isMaintenance()) {
                sum += machine1Job.getDuration();
            }
        }
        return sum;
    }

    private int getOperationsDuration2Machine(){
        int sum =0;
        for (MachineJob machine2Job : machine2Jobs) {
            if (!machine2Job.isMaintenance()) {
                sum += machine2Job.getDuration();
            }
        }
        return sum;
    }

    public int getIdleTime1Machine(){
        return getSolutionDurationTime1MachineLastOperation()- getMaintenance1MachineDuration() - getOperationsDuration1Machine();
    }
    public int getIdleTime2Machine(){
        return getSolutionDurationTime2MachineLastOperation()- getMaintenance2MachineDuration() - getOperationsDuration2Machine();
    }

    public int getIdleQuantity1Machine(){
        int quantity =0;
        for(int i=0;i< machine1Jobs.size()-1;i++){
            if(machine1Jobs.get(i).getStartTime()+machine1Jobs.get(i).getDuration()+1 != machine1Jobs.get(i+1).getStartTime())
            {
                quantity++;
            }
        }
        return  quantity;
    }

    public int getIdleQuantity2Machine(){
        int quantity =0;
        for(int i=0;i< machine2Jobs.size()-1;i++){
            if(machine2Jobs.get(i).getStartTime()+machine2Jobs.get(i).getDuration()+1 != machine2Jobs.get(i+1).getStartTime()) {
                quantity++;
            }
        }
        return  quantity;
    }

    private void sort1Machine(){
       for (int k = 0; k < machine1Jobs.size(); k++) {
            for (int i = 0; i < machine1Jobs.size()-1; i++) {
                if (machine1Jobs.get(i).getStartTime() > machine1Jobs.get(i + 1).getStartTime()) {
                    MachineJob first = machine1Jobs.get(i);
                    MachineJob second = machine1Jobs.get(i+1);
                    machine1Jobs.remove(i);
                    machine1Jobs.remove(i);
                    machine1Jobs.add(i,second);
                    machine1Jobs.add(i+1,first);
                }
            }
        }
    }

    private void sort2Machine(){
        for (int k = 0; k < machine2Jobs.size(); k++) {
            for (int i = 0; i < machine2Jobs.size()-1; i++) {
                if (machine2Jobs.get(i).getStartTime() > machine2Jobs.get(i + 1).getStartTime()) {
                    MachineJob first = machine2Jobs.get(i);
                    MachineJob second = machine2Jobs.get(i+1);
                    machine2Jobs.remove(i);
                    machine2Jobs.remove(i);
                    machine2Jobs.add(i,second);
                    machine2Jobs.add(i+1,first);
                }
            }
        }
    }
    public void sortSolution(){
        sort1Machine();
        sort2Machine();
    }
}
