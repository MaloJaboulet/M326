package gui;

import data.Player;

import java.awt.*;
/**
 * @author Malo Jaboulet
 * @since 07.07.2021
 * @version 1.0
 */
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
