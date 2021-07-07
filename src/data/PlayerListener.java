package data;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * @since 07.07.2021
 * <p>
 * Das Interface, dass die PlayerLogic implementieren muss.
 */
public interface PlayerListener {

    /**
     * Signalisiert dem Gui, das sich die Punkte des Spielers geänder haben.
     *
     * @param player der Spieler
     * @param score  die Anzahl Punkte
     */
    public void fireScoreChanged(Player player, int score);

    /**
     * Signalisiert dem Gui, dass sich der Name des Spielers geändert hat.
     *
     * @param player der Spieler
     * @param name   der Name
     */
    public void fireNameChanged(Player player, String name);

    /**
     * Signalisiert dem Gui, dass ein neuer Spieler gemacht wurde.
     */
    public void fireNewPlayer();

}
