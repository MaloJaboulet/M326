package SpielfeldKlassen;

public class Spieler {
    private String spielerName;
    private int points;
    private boolean yourTurn;
    private int anzahlUmdrehungen;
    private Timer timer;

    public Spieler(String name, boolean yourTurn){
        setSpielerName(name);
        setYourTurn(yourTurn);
        setPoints(0);
        setAnzahlUmdrehungen(0);
        setTimer(timer);
    }
    public Spieler(String name, boolean yourTurn, int points, int anzahlUmdrehungen){
        setSpielerName(name);
        setYourTurn(yourTurn);
        setPoints(points);
        setAnzahlUmdrehungen(anzahlUmdrehungen);
        setTimer(timer);
    }

    public String getSpielerName() {
        return spielerName;
    }

    public void setSpielerName(String spielerName) {
        this.spielerName = spielerName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void givePoint(int point){
        setPoints(getPoints()+point);
    }

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }

    public int getAnzahlUmdrehungen() {
        return anzahlUmdrehungen;
    }

    public void setAnzahlUmdrehungen(int anzahlUmdrehungen) {
        this.anzahlUmdrehungen = anzahlUmdrehungen;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

}
