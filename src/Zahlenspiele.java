public class Zahlenspiele {
    public static void main(String[] args) {
        Out.print("\nZahlenspiele");
        Out.print("\n===============");

        Out.print("\nZahl: ");
        int n = In.readInt();		// Eingabe einer Zahl


        // isPositive()
        Out.print("\n"+n+" ist ");
        if(isPositive(n)) Out.print("positiv");
        else Out.print("negativ");

        // greaterOfTheTwo()
        int otherN = 10;
        int greaterOfTheTwo = greaterOfTheTwo(n, otherN);
        Out.print("\nDie groessere der beiden Zahlen " + n + " und " + otherN + " ist " + greaterOfTheTwo);

        // isDividor()
        int d = 7;
        Out.print("\n"+n+" ist durch " + d + " ");
        if(isDividor(n, d)) Out.print("teilbar");
        else Out.print("nicht teilbar");

        // numberDigits()
        int noDigits = numberDigits(n);
        Out.print("\n"+n+" hat " + noDigits + " Stellen");

        // invertNumber()
        int invertedNumber = invertNumber(n);
        Out.print("\n"+n+" invertiert ist " + invertedNumber);

        // digitAt()
        int pos = 3;
        double digitAt = digitAt(n, pos);
        Out.print("\n" + "Die " + pos + ". Stelle von " + n + " ist " + digitAt);

        // reciprocial()
        double reciprocial = reciprocial(n);
        Out.print("\nDer Kehrwert von " + n + " ist " + reciprocial);

        // reciprocial()
        double num = 123.567;
        reciprocial = reciprocial(num);
        Out.print("\nDer Kehrwert von " + num + " ist " + reciprocial);

        // sayDigit()
        int digit = 6;
        Out.print("\n" + digit + " in Worten ist " + sayDigit(digit));

        // sayDigitAt()
        pos = 2;
        Out.print("\nDie " + pos + ". Stelle von " + n + " in Worten ist " + sayDigitAt(n, pos));

        // inputPositiveInt()
        Out.print("\nPositive Zahl eingeben: ");
        int positiveInt = inputPositiveInt();
        Out.print("\nDie eingegebene Zahl ist " + positiveInt);

        // inputInRangeOnly()()
        int lowerBound = -2;
        int upperBound = 5;
        Out.print("\nBitte Zahl zwischen " + lowerBound + " und " + upperBound + " eingeben: ");
        double numberInRange = inputInRangeOnly(lowerBound,upperBound);
        Out.print("\nDie eingegebene Zahl ist " + numberInRange);
    }

    static boolean isPositive(int number){
        return number >= 0;
    }

    static int greaterOfTheTwo(int n, int otherN){
        if (n > otherN || n == otherN){
            return n;
        }
        else{
            return otherN;
        }
    }

    static boolean isDividor(int n, int d)
    {
        return n % d == 0;
    }

    static int numberDigits(int n){
        int counter = 0;
        if (n == 0){
            return 1;
        }

        while (n != 0){
            n /= 10;
            counter ++;
        }
        return counter;
    }

    static int invertNumber(int n){
        if (!isPositive(n) || n == 0){
            return n;
        }

        int invertedN = 0;
        while (n != 0){
            int digit = n % 10; // get last digit
            invertedN = invertedN * 10 + digit; // add the last digit to the number
            n /= 10; // remove the last digit from original number
        }
        return invertedN;
    }

    static int digitAt(int n, int pos){ // test this thoroughly
        int numberOfDigits = numberDigits(n);
        if (pos <= 0 || numberOfDigits < pos){
            return -1;
        }

        for (int i = numberOfDigits; i > pos; i--) {
            n /= 10;
        }
        return n % 10;
    }

    static double reciprocial(double n){
        double reciprocial = 0.0;
        if (n == 0){ //try if this works
            return reciprocial;
        }
        reciprocial = 1 / n;
        return reciprocial;
    }

    static String sayDigit(int n){
        switch(n){
            case (1): return "one";
            case (2): return "two";
            case (3): return "three";
            case (4): return "four";
            case (5): return "five";
            case (6): return "six";
            case (7): return "seven";
            case (8): return "eight";
            case (9): return "nine";
            default: return "***invalid***";
        }
    }

    static String sayDigitAt(int n, int pos){
        int digit = digitAt(n, pos);
        return sayDigit(digit);
    }

    static int inputPositiveInt(){
        int number = In.readInt();
        while (!isPositive(number)){
            Out.println("Not a valid int, please try again");
            Out.print("Positive Zahl eingeben: ");
            number = In.readInt();
        }
        return number;
    }

    static double inputInRangeOnly(int lowerBound, int upperBound){
        double number = In.readDouble();
        while(number < lowerBound || number > upperBound){
            Out.println("Not a valid double, please try again");
            Out.print("Bitte Zahl zwischen " + lowerBound + " und " + upperBound + " eingeben: ");
            number = In.readDouble();
        }
        return number;
    }
}
