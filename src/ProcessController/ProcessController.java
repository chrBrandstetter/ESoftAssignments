package ProcessController;

public class ProcessController {
    private ProcessQueue hiqhPrio;
    private ProcessQueue lowPrio;

    private static final int PROCESS_SIZE = 4;

    public ProcessController(){
        this.hiqhPrio = new ProcessQueue("hochpriorisierte Prozesse", PROCESS_SIZE);
        this.lowPrio = new ProcessQueue("niedrigpriorisierte Prozesse", PROCESS_SIZE * 2);
    }

    public int nrProcesses(){
        return hiqhPrio.nrProcesses() + lowPrio.nrProcesses();
    }

    public boolean contains(int processNo){
        return hiqhPrio.getProcess(processNo) != null || lowPrio.getProcess(processNo) != null;
    }

    public boolean schedule(Process p, boolean high){
        if(high){
            hiqhPrio.schedule(p);
            return true;
        }
        else {
            insertLow(p);
            return false;
        }
    }
    public boolean insertLow(Process p) {
        return lowPrio.schedule(p);
    }

    public Process processNext() {
        Process nextProcess = hiqhPrio.processNext();
        if (nextProcess == null) {
            nextProcess = lowPrio.processNext();
        }
        return nextProcess;
    }

    public int duration() {
        return hiqhPrio.duration() + lowPrio.duration();
    }

    public String toString()  {
        StringBuffer s = new StringBuffer();
        s.append("PROCESS CONTROLLER " + " --- " +(hiqhPrio.nrProcesses()+lowPrio.nrProcesses()) + " processes ");
        s.append("--- duration: " + (hiqhPrio.duration()+lowPrio.duration())+"\n");
        s.append(">"+hiqhPrio);
        s.append(">"+lowPrio);
        return s.toString();
    }
}
