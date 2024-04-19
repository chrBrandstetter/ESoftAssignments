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
        Out.print("\nDer Kehrwert von " + n + " ist " + reciprocial);

        // sayDigit()
        int digit = 3;
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
        double numberInRange = inputInRangeOnly(1,5);
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

    static boolean isDividor(int n, int d){
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
        if (n < 0 || n == 0){
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
        if (pos <= 0 || numberDigits(n) < pos){
            return -1;
        }

        while (pos >= 1){
            n /= 10;
            pos --;
        }
        return n % 10;
    }

    static double reciprocial(double n){
        double reciprocial = 0.0;
        if (n == 0){
            return reciprocial;
        }
        reciprocial = 1 / n;
        return reciprocial;
    }
}
