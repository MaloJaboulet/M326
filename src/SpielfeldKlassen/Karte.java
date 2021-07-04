package SpielfeldKlassen;

import java.awt.*;

public class Karte {

    private boolean isTurned;
    private Image background;
    private final Color FOREGROUND = new Color(0, 158, 96);
    private boolean visible;
    private int id;

    public Karte(Image background,boolean isTurned, int id){
        setBackground(background);
        setTurned(isTurned);
        setVisible(false);
        setId(id);
    }

    public boolean isTurned() {
        return isTurned;
    }

    public void setTurned(boolean turned) {
        isTurned = turned;
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public Color getFOREGROUND() {
        return FOREGROUND;
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
