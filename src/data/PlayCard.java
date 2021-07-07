package data;

import java.awt.*;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * @since 07.07.2021
 * <p>
 * Diese Klasse ist eine Spielkarte des Memory. Sie beinhaltet alle Daten zur Karte.
 * Die Karte kann oder angezeigt werden, dann ist der Background zu sehen oder sie ist nicht aufgedeckt und
 * man sieht den foreground.
 */
public class PlayCard {

    private boolean isTurned;
    private Image background;
    private Image foreground;
    private Image anzeige;
    private boolean visible;
    private int id;

    /**
     * Der Kunstruktor der Karte.
     *
     * @param background das Hintergrundbild
     * @param isTurned   ob sie gedreht ist oder nicht. -> Am Anfang ist es false
     * @param id         die ID der Karte
     */
    public PlayCard(Image background, boolean isTurned, int id) {
        setBackground(background);
        setTurned(isTurned);
        setVisible(false);
        setId(id);
    }

    /**
     * Schaut, ob die Karte gedreht ist.
     *
     * @return ob die Karte gedreht ist
     */
    public boolean isTurned() {
        return isTurned;
    }

    /**
     * Wenn die Karte gedreht ist, wird sie wieder umgedreht, wenn nicht wird sie gedreht.
     * Dabei wird das Bild vom Vordergrund zum Hintergrund, beziehungsweise umgekehrt gesetzt.
     *
     * @param turned wird gedreht
     */
    public void setTurned(boolean turned) {
        if (turned) {
            setAnzeige(getBackground());
        } else {
            setAnzeige(getForeground());
        }
        isTurned = turned;
    }

    /**
     * Holt das Hintergrundbild.
     * @return das Hintergrundbild
     */
    public Image getBackground() {
        return background;
    }

    /**
     * Setzt das Hintergrundbild.
     * @param background das Hintergrundbild
     */
    public void setBackground(Image background) {
        this.background = background;
    }

    /**
     * Holt das Vordergrundbild.
     * @return das Vordergrundbild
     */
    public Image getForeground() {
        return foreground;
    }

    /**
     * Setzt das Bild, dass jetzt angezeigt wird.
     * @param anzeige das Bild
     */
    public void setAnzeige(Image anzeige) {
        this.anzeige = anzeige;
    }

    /**
     * Holt das Bild, das jetzt angezeigt wird.
     * @return das Bild
     */
    public Image getAnzeige() {
        return anzeige;
    }

    /**
     * Setzt das Vordergrundbild
     * @param image das Vordergrundbild
     */
    public void setForeground(Image image) {
        this.foreground = image;
    }

    /**
     * Holt, ob die Karte sichtbar ist oder nicht.
     * @return ob sie sichtbar ist
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Setzt, ob die Karte sichtbar ist oder nicht.
     * @param visible ob sie sichtbar ist oder nicht
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Holt die ID der Karte.
     * @return die ID
     */
    public int getId() {
        return id;
    }

    /**
     * Setzt die ID der Karte.
     * @param id die ID
     */
    public void setId(int id) {
        this.id = id;
    }
}

