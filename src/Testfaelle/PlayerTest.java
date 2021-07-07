package Testfaelle;

import data.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Diese Klasse testet den Spieler.
 */
public class PlayerTest {
    private static Player player;

    /**
     * Erstellt einen Spieler.
     */
    @Before
    public void setUp(){
        player = new Player("Test",0,true);
    }

    /**
     * Testet, ob der Spieler richtig erstellt wird und den Namen richtig zurückgeben kann.
     */
    @Test
    public void createPlayer(){
        player = new Player("Hans", 0,true);

        assertEquals("Hans", player.getName());
    }

    /**
     * Testet, ob der Spieler gewechselt werden kann.
     */
    @Test
    public void changedPlayer(){
        player = new Player("Hans", 0,true);
        player.changeTurn();

        assertEquals(false, player.getYourTurn());
    }
}
