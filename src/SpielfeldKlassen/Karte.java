package SpielfeldKlassen;

import java.awt.*;

public class Karte{

    private boolean isTurned;
    private Image background;
    private Image foreground;
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

    public Image getForeground() {
        return foreground;
    }

    public void setForeground(Image image){
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
