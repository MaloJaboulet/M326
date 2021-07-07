package gui;

import data.Player;

import java.awt.*;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * @since 07.07.2021
 * <p>
 * Das ist das Interface, dass das Playground implementieren muss.
 * Die Methoden werden braucht das Gui, damit alles richtig angezeigt werden kann.
 */
public interface PlaygroundModel {

    /**
     * Holt die Anzahl Reihen.
     *
     * @return die Anzahl Reihen
     */
    public int getRows();

    /**
     * Holt die Anzahl Spalten
     *
     * @return die Anzahl Spalten
     */
    public int getColumns();

    /**
     * Holt das Bild an einer Position.
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @return das Bild
     */
    public Image getImage(int x, int y);

    /**
     * Schaut, ob die Karte angezeigt wird oder nicht.
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @return ob die Karte angezeigt wird
     */
    public boolean isSelected(int x, int y);

    /**
     * Dreht die Karte, damit sie gezeigt wird oder nicht.
     *
     * @param x        x-Koordinate
     * @param y        y-Koordinate
     * @param selected ob sie angezeigt wird
     */
    public void setSelected(int x, int y, boolean selected);

    /**
     * Vergleicht zwei Karten.
     *
     * @param x1 x-Koordinate der ersten Karte
     * @param y1 y-Koordinate der ersten Karte
     * @param x2 x-Koordinate der zweiten Karte
     * @param y2 y-Koordinate der zweiten Karte
     * @return ob die Karten gleich sind
     */
    public int compareCards(int x1, int y1, int x2, int y2);

    /**
     * Holt den Gewinner der Runde.
     *
     * @return der Gewinner
     */
    public Player winner();

    /**
     * Holt den Verlierer der Runde.
     *
     * @return der Verlierer
     */
    public Player loser();
}
