package Testfaelle;

import data.Player;
import data.Playground;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Diese Klasse testet den Spieler.
 */
public class PlayerTest {
    private static Player player;
    private static Playground playground;

    /**
     * Erstellt einen Spieler.
     */
    @Before
    public void setUp(){
        player = new Player("Test",0,true);
        playground = new Playground(10,10);
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

    @Test
    public void drawOnPoints(){
        playground.getLogic().addNewPlayer("Hans",true);
        playground.getLogic().addNewPlayer("Meier",false);

        Player gewinner = playground.winner();

        assertEquals(null, gewinner);
    }
}
