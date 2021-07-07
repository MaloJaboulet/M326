package data;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * <p>
 * Diese Klasse ist ein Spieler des Spiels. Hier werden alle Daten zum Spieler gespeichert.
 * @since 07.07.2021
 */
public class Player implements PlayerModel {

    private String name;
    private int score;
    private boolean yourTurn;
    private int roundsWon;

    /**
     * Der Konstruktor des Spielers.
     *
     * @param name     der Name des Spielers
     * @param score    die Punkte, die der Spieler hat
     * @param yourTurn ob er an der Reihe ist
     */
    public Player(String name, int score, boolean yourTurn) {
        setName(name);
        setScore(score);
        setYourTurn(yourTurn);
        roundsWon = 0;
    }

    /**
     * Wechselt den Spieler. Der Spieler, der an der Reihe ist, wird auch false gesetzt und der andere auf true.
     */
    @Override
    public void changeTurn() {
        if (getYourTurn()) {
            setYourTurn(false);
        } else {
            setYourTurn(true);
        }
    }

    /**
     * Holt den Name des Spielers.
     *
     * @return der Name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen des Spielers.
     *
     * @param name der Name des Spielers
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Holt die Punkte des Spielers.
     *
     * @return die Punkte
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * Setzt die Punkte des Spielers.
     *
     * @param score die Punkte
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Holt, ob der Spieler an der Reihe ist oder nicht.
     *
     * @return ob er an der Reihe ist oder nicht
     */
    @Override
    public boolean getYourTurn() {
        return yourTurn;
    }


    /**
     * Setzt, ob der Spieler an der Reihe ist.
     *
     * @param yourTurn ob er an der Reihe ist
     */
    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }

    /**
     * Holt, wie viele Runden der Spieler gewonnen hat.
     *
     * @return die Anzahl von gewonnenen Runden
     */
    public int getRoundsWon() {
        return roundsWon;
    }

    /**
     * Setzt, wie viele Runden ein Spieler gewonnen hat.
     *
     * @param roundsWon die Anzahl gewonnene Runden
     */
    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }
}
