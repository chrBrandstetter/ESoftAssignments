public class Zahleneingabe {
    public static void main(String [] args) {

        Out.print("Number input only with In.read()\n");

        double number = 0.0; 	// number to be extracted from user input
        boolean valid = true;	// indicates whether number given is valid

        Out.print("Input: ");
        char c = In.read();  	// here comes the user input

        int counter = 0; //counter for decimal point
        int divider = 10; // divider for decimal places

        while (c != '\n') { // read every character in buffer
            if(c != 46 && counter < 1 ){
                number = (number * 10) +  c - '0';
            }
            if(counter == 1){
                double placeholder = (double)(c - '0') / divider;
                number = number + placeholder;
                divider *= 10;
            }
            if(c == '.'){
                counter ++;
            }
            if(c > 57 || c == 47 || c < 46 || counter > 1) {
                valid = false;
                break;
            }

            c = In.read();		// read next character from buffer
        } // end while

        if (valid)
            System.out.printf(java.util.Locale.US, "Number: %10.5f", number);
        else Out.print("Invalid input!");
    } // end main()
}
