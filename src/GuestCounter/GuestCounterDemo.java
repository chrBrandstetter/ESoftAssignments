package GuestCounter;

public class GuestCounterDemo {
    public static void main(String [] args) {
        GuestCounter fineDine = new GuestCounter("Restaurant Fine Dining", 60);
        GuestCounter miniBeisl = new GuestCounter("ums Eck", 8);
        miniBeisl.print(); // "ums Eck (max. 8 Personen, im Lokal: 8 frei: 0)"
        for (int i = 0; i < 8; i++) { // 7 Personen betreten das Lokal
            if (miniBeisl.enter()) Out.print("\nEine Person kann rein!");
        }
        miniBeisl.print(); // "ums Eck (max. 8 Personen, im Lokal: 8 frei: 0)"
        if(!miniBeisl.enter()) Out.print("\nDie Person kann nicht mehr rein!");
        miniBeisl.leave(); // eine Person verlaesst das Lokal
        miniBeisl.print(); // "ums Eck (max. 8 Personen, im Lokal: 7 frei: 1)"
        if(!miniBeisl.enter()) Out.print("\nDie Person kann nun rein!");
        miniBeisl.print(); // "ums Eck (max. 8 Personen, im Lokal: 8 frei: 0)"
        miniBeisl.leave(); // eine Person verlaesst das Lokal
        miniBeisl.leave(); // eine Person verlaesst das Lokal
        miniBeisl.print(); // "ums Eck (max. 8 Personen, im Lokal: 6 frei: 2)"
    } // end main()

}
