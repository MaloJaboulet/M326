package data;

import java.awt.*;

public class PlayCard {

    private boolean isTurned;
    private Image background;
    private Image foreground;
    private Image anzeige;
    private boolean visible;
    private int id;

    public PlayCard(Image background, boolean isTurned, int id) {
        setBackground(background);
        setTurned(isTurned);
        setVisible(false);
        setId(id);
    }

    public boolean isTurned() {
        return isTurned;
    }

    public void setTurned(boolean turned) {
        if (turned){
            setAnzeige(getBackground());
        }else {
            setAnzeige(getForeground());
        }
        isTurned = turned;
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public Image getForeground() {
        return foreground;
    }

    public void setAnzeige(Image anzeige) {
        this.anzeige = anzeige;
    }

    public Image getAnzeige() {
        return anzeige;
    }

    public void setForeground(Image image) {
        this.foreground = image;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

