package Testfaelle;


import data.PlayCard;
import data.Playground;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.swing.*;
import java.awt.*;

/**
 * Dies Klasse testet die Karte.
 */
public class CardTest {

    private static Playground playground;

    /**
     * Setzt die Daten, die für die Test gebraucht werden.
     */
    @Before
    public void setUp() {
        playground = new Playground(10, 10);
    }


    /**
     * Dieser Test schaut, ob die Karte das Hintergrundbild richtig speichert und wiedergeben kann.
     */
    @Test
    public void compareCards() {
        Image image = new ImageIcon(this.getClass().getResource("../Img/1.jpg")).getImage();
        PlayCard card1 = new PlayCard(image, false, 1);

        assertEquals(new ImageIcon(this.getClass().getResource("../Img/1.jpg")).getImage(), card1.getBackground());
    }

}
