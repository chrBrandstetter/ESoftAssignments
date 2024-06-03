package Map;

public class Map {
    private String[] keys;
    private String[] values;
    private int size;

    public Map() {
        this.keys = new String[10];
        this.values = new String[10];
        this.size = 0;
    }

    private void extendSpace() {
        int newCapacity = keys.length + 10;
        String[] newKeys = new String[newCapacity];
        String[] newValues = new String[newCapacity];
        for (int i = 0; i < keys.length; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }

    public boolean store(String key, String value) {
        if (key == null || value == null) return false;
        if (findPos(key) != -1) return false;

        if (size == keys.length) {
            extendSpace();
        }

        keys[size] = key;
        values[size] = value;
        size++;
        return true;
    }

    public String toString() {
        String s = new String();
        if(this.keys.length == 0) {
            s = "die Map ist leer";
        } else {
            for(int i = 0; i < keys.length; i++) {
                if(keys[i] == null) {
                    s = "(" + this.keys[i] + ", " + this.values[i] + ")";
                }
            }
        }
        return s;
    }

    public boolean update(String key, String value) {
        if (key == null || value == null) return false;
        int pos = findPos(key);
        if (pos == -1) return false;

        values[pos] = value;
        return true;
    }

    public boolean remove(String key) {
        if (key == null) return false;
        int pos = findPos(key);
        if (pos == -1) return false;

        keys[pos] = keys[size - 1];
        values[pos] = values[size - 1];
        keys[size - 1] = null;
        values[size - 1] = null;
        size--;
        return true;
    }

    public String value(String key) {
        int pos = findPos(key);
        if (pos == -1) return null;
        return values[pos];
    }

    public int size() {
        return size;
    }

    public String[] keys() {
        String[] result = new String[size];
        System.arraycopy(keys, 0, result, 0, size);
        return result;
    }

    private int findPos(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
