package gui;

import data.Player;

import java.awt.*;

public interface PlaygroundModel {

    public int getRows();

    public int getColumns();

    public Image getImage(int x,int y);

    public boolean isSelected(int x, int y);

    public void setSelected(int x, int y, boolean selected);

    public int compareCards(int x1, int y1, int x2, int y2);

    public Player winner();

    public Player loser();
}
