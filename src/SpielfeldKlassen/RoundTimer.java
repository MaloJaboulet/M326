package SpielfeldKlassen;

import java.util.Vector;

public class RoundTimer {
    private Timer timer;
    private int index;
    private Vector<Timer> roundtime;

    public RoundTimer(Timer timer){
        setTimer(timer);
        setRoundtime(new Vector<>());
        setIndex(0);
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Vector<Timer> getRoundtime() {
        return roundtime;
    }

    public void setRoundtimer(Timer timer, int index){
        this.roundtime.set(index, timer);
    }

    public void setRoundtime(Vector<Timer> roundtime) {
        this.roundtime = roundtime;
    }

    public void addRoundTimer(Timer timer){
        roundtime.add(timer);
    }
}
