package data;

import gui.PlaygroundListener;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Playground implements gui.PlaygroundModel {
    private PlayCard[][] cards;
    private Vector<String> images;
    private PlayerLogic logic;
    private int rows;
    private int cols;
    private PlaygroundListener playgroundListener;

    public Playground(int row, int cols) {
        setRows(row);
        setCols(cols);
        cards = new PlayCard[row][cols];
        images = new Vector<>();
        images = createImages(row, cols);
        createCards(row, cols);
        logic = new PlayerLogic();
    }

    public void createCards(int rows, int cols) {
        Vector<String> bilderTemp = getImages();
        int zaehler = 0;
        Collections.shuffle(images);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                PlayCard card = new PlayCard(new ImageIcon(
                        this.getClass().getResource("../Img/" + (images.get(zaehler)))).getImage()
                        , false, (i * j));
                card.setForeground(new ImageIcon(
                        this.getClass().getResource("../Img/foreground.jpg")).getImage());
                card.setAnzeige(card.getForeground());
                cards[i][j] = card;
                zaehler++;
            }
        }
    }

    public Vector<String> createImages(int rows, int columns) {
        Vector<String> bilderVec = new Vector<>();

        if ((rows * columns) % 2 != 0) {
            bilderVec.add("foreground.jpg");
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= (rows * columns) / 2; j++) {

                bilderVec.add(j + ".jpg");
            }
        }
        return bilderVec;
    }

    public void createPlayer(String name, boolean yourTurn) {
        logic.addNewPlayer(name, yourTurn);
    }

    public PlayCard[][] getCards() {
        return cards;
    }

    public void setCards(PlayCard[][] cards) {
        this.cards = cards;
    }

    public PlayCard getCard(int row, int col) {
        return cards[row][col];
    }

    public Vector<String> getImages() {
        return images;
    }

    public void setImages(Vector<String> images) {
        this.images = images;
    }

    public PlayerLogic getLogic() {
        return logic;
    }

    public void setLogic(PlayerLogic logic) {
        this.logic = logic;
    }

    public PlaygroundListener getPlaygroundListener() {
        return playgroundListener;
    }

    public void setPlaygroundListener(PlaygroundListener playgroundListener) {
        this.playgroundListener = playgroundListener;
    }

    @Override
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public int getColumns() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    @Override
    public Image getImage(int x, int y) {
        return cards[x][y].getAnzeige();
    }

    @Override
    public boolean isSelected(int x, int y) {
        return cards[x][y].isTurned();
    }

    @Override
    public void setSelected(int x, int y, boolean selected) {
        cards[x][y].setTurned(selected);
        playgroundListener.fireCardChange(x, y);
    }

    @Override
    public int compareCards(int x1, int y1, int x2, int y2) {
        PlayCard card1 = getCard(x1, y1);
        PlayCard card2 = getCard(x2, y2);
        if (card1.getBackground().equals(card2.getBackground())) {
            card1.setVisible(false);
            card2.setVisible(false);
            playgroundListener.firePairFound(x1, y1, x2, y2);
            return 1;
        } else {
            card1.setAnzeige(card1.getForeground());
            card1.setTurned(false);
            playgroundListener.fireCardChange(x1, y1);

            card2.setAnzeige(card2.getForeground());
            card2.setTurned(false);
            playgroundListener.fireCardChange(x2, y2);
            return 0;
        }
    }

}
