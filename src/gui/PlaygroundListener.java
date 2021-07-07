package gui;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * @since 07.07.2021
 * <p>
 * Das Interface, dass das SpielfeldGui implementieren muss.
 * Die Methoden werden braucht das Gui, damit alles richtig angezeigt werden kann.
 */
public interface PlaygroundListener {

    /**
     * Dreht eine ausgewählte Karte. Die Karte wird über die Koordinaten gefunden.
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    public void fireCardChange(int x, int y);

    /**
     * Wenn ein Paar gefunden wird, werden beide Karten deaktiviert.
     *
     * @param x1 x-Koordinate der ersten Karte
     * @param y1 y-Koordinate der ersten Karte
     * @param x2 x-Koordinate der zweiten Karte
     * @param y2 y-Koordinate der zweiten Karte
     */
    public void firePairFound(int x1, int y1, int x2, int y2);
}
