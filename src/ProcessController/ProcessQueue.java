package ProcessController;

public class ProcessQueue {

    private String processName;
    private int processSize;
    private Process[] processes;
    private int count; //für Anzahl der Prozesse in der queue
    private static final int DEFAULT_SIZE = 10;

    public ProcessQueue(String name, int size){
        if(name == null || name.isEmpty()){
            this.processName = "unnamed";
        }
        else {
            this.processName = name;
        }

        if(size <= 0){
            this.processSize = DEFAULT_SIZE;
        }
        else {
            this.processSize = size;
        }

        //lege alle Prcesses an
        this.processes = new Process[this.processSize];
        count = 0;
    }

    public int nrProcesses(){
        return count; //testen!
    }

    public Process getProcess(int processNo){
        for(int i = 0; i < count; i++){
            if(processes[i].processNo() == processNo){
                return processes[i];
            }
        }
        return null;
    }

    public boolean schedule(Process p){
        if(this.count < this.processSize){
            processes[count++] = p;
            return true;
        }
        return false;
    }

    public Process processNext(){ //testen | kein Dunst ob das funktioniert
        if(count == 0){
            return null;
        }

        Process nextProcess = this.processes[0];
        for(int i = 1; i < count; i ++){
            processes[i - 1] = processes[i];
        }
        processes[--count] = null;

        return nextProcess;
    }

    public int duration(){
        int sumDuration = 0;
        for(int i = 0; i < count; i++){
            sumDuration += processes[i].duration();
        }
        return sumDuration;
    }

    public String toString() {
        StringBuffer s = new StringBuffer("'" + processName + "' --- " + nrProcesses() + " processes --- duration: " + duration()+"\n");
        for (int i = 0; i < count; i++) {
            if (processes[i] != null) s.append(processes[i]+"\n");
        }
        return s.append("\n").toString();
    }
}
