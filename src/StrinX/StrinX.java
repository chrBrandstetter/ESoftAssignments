package StrinX;

public class StrinX {
    char[] data;

    public StrinX() {
        this.data = new char[0];
    }


    public StrinX(StrinX str) {
        if(str != null) {
            this.data = copy(str.data);
        }
    }

    public StrinX(char[] data) {
        if(data == null) {
            data = new char[0];
        }
        this.data = copy(data);
    }

    public StrinX(String str) {
        if(str != null) {
            data = new char[str.length()];
            for(int i = 0; i < str.length(); i++) {
                data[i] = str.charAt(i);
            }
        } else {
            data = new char[0];
        }
    }

    private char[] copy(char[] array) {
        char[] copy = new char[array.length];
        for(int i = 0; i < copy.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public int length() {
        if(this.data != null) {
            return this.data.length;
        }
        return this.data.length;
    }

    public String toString() {
        if(this.data.length == 0) {
            return "";
        }
        String data = new String();
        for(int i = 0; i < this.length(); i++) {
            data += this.data[i];
        }
        return data;
    }

    public StrinX substring(int beginIndex, int count) {
        if(beginIndex <= 0 || beginIndex >= this.data.length) {
            return null;
        }
        if(count <= 0 || count >= (this.data.length - beginIndex)) {
            return null;
        }
        char[] neu = new char[count];
        int i = beginIndex;
        int j = 0;
        while(i < this.data.length) {
            neu[j] = this.data[i];
            i++;
            j++;
        }

        StrinX substring = new StrinX(neu);
        return substring;
    }

    boolean endsWith(char[] suffix) {

        if(suffix == null) return true;
        if(suffix.length > this.data.length) {
            return false;
        }
        int i = suffix.length - 1;
        int j = data.length - 1;
        while(i >=  0) {
            if(this.data[j] != suffix[i]) {
                return false;
            } else {
                i--;
                j--;
            }
        }
        return true;
    }

    static public int compareTo(StrinX s1, StrinX s2) {
        if(s1 == null && s2 == null) return 0;
        if(s1 == null) return -1;
        if(s2 == null) return 1;
        for(int i = 0; i < s1.data.length && i < s2.data.length; i++) {
            if(s1.data[i] != s2.data[i]) return s1.data[i] - s2.data[i];
        }
        return (s1.data.length - s2.data.length);
    }

    public char[] toCharArray() {
        return copy(this.data);
    }
}
