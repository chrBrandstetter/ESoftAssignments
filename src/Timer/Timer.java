package Timer;

class Timer {

    long sec;
    long secsave;

    Timer() {
        sec = secsave = 0;
    }

    Timer(long h, long min, long sec) {
        if (sec < 0 || sec > 60 || min < 0 || min > 60 || h < 0) {
            this.sec = secsave = 0;

        } else {
            this.sec = secsave = h * 60 * 60 + min * 60 + sec;
        }
    }

    void reset() {
        sec = secsave;
    }

    boolean elapse(long sec) {
        if (this.sec - sec >= 0) {
            this.sec += sec;
            return true;
        }
        return false;
    }

    boolean elapse(long sec, long min) {
        if (elapse(min * 60 + sec)) return true;
        return false;
    }

    boolean elapse(long h, long min, long sec) {
        if (elapse(h * 3600 + min * 60 + sec)) return true;
        return false;
    }

    boolean elapse(Timer t) {
        if (elapse(t.sec)) return true;
        return false;
    }

    Timer diff(Timer t) {
        long secdiff = this.sec - t.sec;
        if (secdiff < 0) secdiff = secdiff * -1;

        Timer diff = new Timer((secdiff / 3600), (secdiff % 3600) / 60, (secdiff % 3600) % 60);
        return diff;
    }

    String asText() {
        return "[" + sec / 3600 + ":" + (sec % 3600) / 60 + ":" + (sec % 3600) % 60 + "]";
    }

    Timer cloneIt() {
        Timer clone = new Timer();
        clone.sec = this.sec;
        clone.secsave = this.secsave;
        return clone;
    }

    boolean withdraw(int t) {
        if (t >= this.sec) {
            this.sec = 0;
            return false;
        } else {
            this.sec -= t;
            return true;
        }
    }
}