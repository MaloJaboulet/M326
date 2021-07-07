package data;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * @since 07.07.2021
 * <p>
 * Das Interface, dass der Spieler implementieren muss.
 * Die Methoden werden braucht das Gui, damit alles richtig angezeigt werden kann.
 */
public interface PlayerModel {

    /**
     * Holt den Namen des Spielers.
     *
     * @return der Name
     */
    public String getName();

    /**
     * Holt die Punkte des Spielers.
     *
     * @return die Punkte
     */
    public int getScore();

    /**
     * Holt, ob der Spieler an der Reihe ist oder nicht.
     *
     * @return ob er an der Reihe ist
     */
    public boolean getYourTurn();

    /**
     * Wechselt, wer an der Reihe ist von den Spielern.
     */
    public void changeTurn();
}
