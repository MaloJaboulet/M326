package Model;

import SpielfeldKlassen.RoundTimer;
import SpielfeldKlassen.Spieler;

import java.util.Vector;

public class Auswertung {
    private Vector<RoundTimer> roundTimers;
    private int index;
    private boolean sieger;
    private int points1;
    private int points2;


    public Auswertung(int index,int points1, int points2){
        setIndex(index);
        setPoints1(points1);
        setPoints2(points2);
    }

    public Vector<RoundTimer> getRoundTimers() {
        return roundTimers;
    }

    public void setRoundTimers(Vector<RoundTimer> roundTimers) {
        this.roundTimers = roundTimers;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSieger() {
        return sieger;
    }

    public void setSieger(boolean sieger) {
        this.sieger = sieger;
    }

    public int getPoints1() {
        return points1;
    }

    public void setPoints1(int points1) {
        this.points1 = points1;
    }

    public int getPoints2() {
        return points2;
    }

    public void setPoints2(int points2) {
        this.points2 = points2;
    }

    public void calculatePoints(int spielerIndex){
        if (spielerIndex == 1){
            setPoints1(getPoints1());
        }else {
            setPoints2(getPoints2());
        }
    }

    public void calculateRound(){

    }

    public void calculateWinPerPlayer(){

    }

    public void sortRound(){

    }
}
