package GuestCounter;
public class GuestCounter {
    String name;
    int capacity;
    int currentGuests;

    public GuestCounter(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.currentGuests = 0;
    }

    boolean enter() {
        if (currentGuests < capacity) {
            currentGuests++;
            return true;
        } else {
            return false;
        }
    }

    boolean leave() {
        if (currentGuests > 0) {
            currentGuests--;
            return true;
        } else {
            return false;
        }
    }

    int numberGuests() {
        return currentGuests;
    }

    int freeSpace() {
        return capacity - currentGuests;
    }

    int capacity() {
        return capacity;
    }

    void print() {
        System.out.println(name + "\n(max. " + capacity + " Personen, im Lokal: " + currentGuests + " frei: " + freeSpace() + ")");
    }
}
