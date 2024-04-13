public class Pruefziffernberechnung {
    public static void main(String[] args) {

        Out.print("ISBN: ");
        char isbn = In.read(); // In.read() -> wandelt char um in ASCII
        int sum = 0;

        for (int i = 1; i <= 9 && isbn != '\n'; i++) { // isbn != '\n' -> solange Zeichen im Puffer
            int num = isbn - '0'; // pars in int | minus 0 damit nicht ASCII sondern wirklich der char verwendet wird
            sum = sum + (num * i);

            isbn = In.read(); // Zeichenfolge wird nacheinander abgearbeitet und danach wird das aktuelle Zeichen eliminiert
        }
        // nach Schleifendurchlauf bleibt die letzte Stelle im Puffer
        int digit = isbn - '0';

        if (sum % 11 == digit) {
            Out.println("korrekt!");
        } else if (sum % 11 == digit - 30) {
            Out.print("korrekt!");
        } else {
            Out.println("nicht korrekt");
        }
    }
}
