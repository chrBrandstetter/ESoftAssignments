package ProcessController;

public class Process {

    private static int nextProcessNumber = 0; //kontrollieren!
    private final int processNumber;
    private String description;
    private String[] processCode;

    public Process(String description, String[] processCode){

        //Eindeutig und beim Erstellen eines Processes automatisch aufsteigend
        //nicht abaenderbar weil final
        this.processNumber = nextProcessNumber++;

        //Zuweisung description wenn null
        if(description == null || description.isEmpty()){
            this.description = "Prozess #" + this.processNumber;
        }
        else{
            this.description = description;
        }

        //Zuweisung processCode wenn null hat processCode "0 Lines of code"
        if(processCode == null){
            this.processCode = new String[0];
        }
        else{
            this.processCode = new String[processCode.length];

            for(int i = 0; i < processCode.length; i++){
                if(processCode[i] == null){
                    this.processCode[i] = "NOP";
                }
                else{
                    this.processCode[i] = processCode[i];
                }
            }
        }
    }

    public int processNo(){
        return this.processNumber;
    }

    public boolean rename(String name){
        if(name != null || !name.isEmpty()){
            this.description = name;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean updateCode(int lineNo, String codeLine){
        if(lineNo >= 0 && lineNo < this.processCode.length){
            if(codeLine == null || codeLine.isEmpty()){
                this.processCode[lineNo] = "NOP";
            }
            else {
                this.processCode[lineNo] = codeLine;
            }
            return true;
        }
        return false;
    }

    public int duration(){
        return this.processCode.length; //test!
    }

    public String toString() {
        StringBuffer s = new StringBuffer("\n    #"+ this.processNumber + " --- " + "'" + this.description + "'" +" --- ("+duration()+")");
        for (int i = 0; i < this.processCode.length; i++) {
            s.append("\n       "+i+ ". " + this.processCode[i]);
        }
        return s.toString();
    }

}
