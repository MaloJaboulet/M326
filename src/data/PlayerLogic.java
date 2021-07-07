package data;

import java.util.Vector;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * <p>
 * Diese Klasse beinhaltet die ganze Logic um die Spieler. Hier werden alle Spieler gespeichert.
 * @since 07.07.2021
 */
public class PlayerLogic implements PlayerListener {


    private Vector<Player> players;

    /**
     * Der Kunstruktor.
     */
    public PlayerLogic() {
        players = new Vector<>();
    }

    /**
     * Erstellt einen neuen Spieler und fügt diesen dem Vector hinzu.
     *
     * @param name     der Name des Spielers
     * @param yourTurn ob der an der Reihe ist
     */
    public void addNewPlayer(String name, boolean yourTurn) {
        players.add(new Player(name, 0, yourTurn));
        fireNewPlayer();
    }

    /**
     * Holt den Spieler nach seinem Namen.
     *
     * @param playername der Spielername
     * @return der Spieler
     */
    public Player getPlayer(String playername) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(playername)) {
                return players.get(i);
            }
        }
        return null;
    }

    /**
     * Holt den Spieler nach seinem Index im Vector.
     *
     * @param index der Index
     * @return der Spieler
     */
    public Player getPlayer(int index) {
        return players.get(index);
    }

    /**
     * Signalisiert dem Gui, dass der Spieler einen Punkt bekommen hat.
     *
     * @param player der Spieler
     * @param score  die Anzahl Punkte
     */
    @Override
    public void fireScoreChanged(Player player, int score) {
        int playerScore = players.get(players.indexOf(player)).getScore();
        players.get(players.indexOf(player)).setScore(playerScore + score);
    }

    /**
     * Signalisiert dem Gui, dass der Spieler einen neuen Namen hat.
     *
     * @param player der Spieler
     * @param name   der Name
     */
    @Override
    public void fireNameChanged(Player player, String name) {
        players.get(players.indexOf(player)).setName(name);
    }

    /**
     * Signalisiert dem Gui, dass ein neuer Spieler erstellt worden ist.
     */
    @Override
    public void fireNewPlayer() {

    }
}
