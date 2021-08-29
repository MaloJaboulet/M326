package data;

import gui.PlaygroundListener;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Vector;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * @since 07.07.2021
 * <p>
 * Diese Klasse ist Hauptspeicher aller Daten. Hier weden die Bilde geholt und in die Karten getan.
 * Das Spielfeld mit all den Karten wird auch hier gelagert.
 */
public class Playground implements gui.PlaygroundModel {
    private PlayCard[][] cards;
    private Vector<String> images;
    private PlayerLogic logic;
    private int rows;
    private int cols;
    private PlaygroundListener playgroundListener;
    private int roundsPlayed;

    /**
     * Der Konstrukor des Spielfelds.
     *
     * @param row  die Anzahl Reihen
     * @param cols die Anzahl Spalten
     */
    public Playground(int row, int cols) {
        setRows(row);
        setCols(cols);
        cards = new PlayCard[row][cols];
        images = new Vector<>();
        images = createImages(row, cols);
        createCards(row, cols);
        logic = new PlayerLogic();
        roundsPlayed = 1;
    }

    /**
     * Erstellt die Karten für das Spielfeld. Diese werden auch gerade in das Spielfeld gespeichert.
     *
     * @param rows die Anzahl Reihen
     * @param cols die Anzahl Spalten
     */
    public void createCards(int rows, int cols) {
        Vector<String> bilderTemp = getImages();
        int zaehler = 0;
        Collections.shuffle(images);    //Die Bilder werden gemischt
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                //Das Hintergrundbild wird aus dem Ordner "Img" gehold und in die Karte getan.
                Image image = new ImageIcon(this.getClass().getResource("../Img/"+(images.get(zaehler))))
                        .getImage();
                PlayCard card = new PlayCard(image, false, (i * j));

                //Das Vordergrundbild wird aus dem Ordner "Img" gehold und in die Karte getan.
                card.setForeground(new ImageIcon(
                        this.getClass().getResource("../Img/foreground.jpg")).getImage());
                card.setAnzeige(card.getForeground());
                cards[i][j] = card;
                zaehler++;
            }
        }
    }

    /**
     * Alle Bilder werden in ein Vector gespeichert. Es werden so viele gespeichert, wie es für das Spiel braucht.
     *
     * @param rows    die Anzahl Reihen
     * @param columns die Anzahl Spalten
     * @return das Vector mit all den Bildern
     */
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


    /**
     * Dreht, welcher Spieler an der Reihe ist.
     */
    public void turnCurrentPlayer() {
        if (getLogic().getPlayer(0).getYourTurn()) {
            getLogic().getPlayer(0).setYourTurn(false);
        } else {
            getLogic().getPlayer(0).setYourTurn(true);
        }

        if (getLogic().getPlayer(1).getYourTurn()) {
            getLogic().getPlayer(1).setYourTurn(false);
        } else {
            getLogic().getPlayer(1).setYourTurn(true);
        }
    }

    /**
     * Vergleicht 2 Karten miteinander.
     * Wenn die 2 Karten gleicht sind, werden beide ausgeschaltet und der aktuelle Spieler bekommt einen Punkt und
     * kann weiter spielen.
     * Wenn die Karten nicht gleich sind, ist der Spielzug vorbei und die Spieler werden gewechselt.
     *
     * @param x1 x-Koordinate der ersten Karte
     * @param y1 y-Koordinate der ersten Karte
     * @param x2 x-Koordinate der zweiten Karte
     * @param y2 y-Koordinate der zweiten Karte
     * @return 1 = Karten sind gleich, 0 = Karten sind nicht gleich
     */
    @Override
    public int compareCards(int x1, int y1, int x2, int y2) {
        PlayCard card1 = getCard(x1, y1);
        PlayCard card2 = getCard(x2, y2);
        if (card1.getBackground().equals(card2.getBackground())) {
            card1.setVisible(false);    //Schaltet die Karte aus
            card2.setVisible(false);    //Schaltet die Karte aus
            playgroundListener.firePairFound(x1, y1, x2, y2);
            getLogic().fireScoreChanged(getCurrentPlayer(), 1); //Spieler bekommt einen Punkt

            return 1;
        } else {
            card1.setAnzeige(card1.getForeground()); //erste Karte wird gedreht
            card1.setTurned(false);
            playgroundListener.fireCardChange(x1, y1);


            card2.setAnzeige(card2.getForeground()); //zweite Karte wird gedreht
            card2.setTurned(false);
            playgroundListener.fireCardChange(x2, y2);
            turnCurrentPlayer(); //Spieler wechseln
            return 0;
        }
    }

    /**
     * Setzt die Karten des Spielfeld wieder zurück, damit mehrere Runden gespieler werden können.
     */
    public void restoreData() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                addRound();
                PlayCard card = getCard(i, j);
                card.setTurned(false);
                card.setAnzeige(card.getForeground());
            }
        }
        createCards(getRows(),getColumns());
    }

    /**
     * Holt die Anzahl gespielten Runden.
     *
     * @return die Anzahl Runden
     */
    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    /**
     * Erhöht die Anzahl gespielen Runden um Eins.
     */
    public void addRound() {
        setRoundsPlayed(getRoundsPlayed() + 1);
    }

    /**
     * Setzt die Anzahl gespielte Runden.
     *
     * @param roundsPlayed die Anzahl gespielte Runden
     */
    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    /**
     * Holt die Anzahl Reihen.
     *
     * @return die Anzahl Reihen
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * Setzt die Anzahl Reihen.
     *
     * @param rows die Anzahl Reihen
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Holt die Anzahl Spalten.
     *
     * @return die Anzahl Spalten
     */
    @Override
    public int getColumns() {
        return cols;
    }

    /**
     * Setzt die Anzahl Spalten.
     *
     * @param cols die Anzahl Spalten
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * Holt das Bild an einer bestimmten Position im Spielfeld.
     *
     * @param x die x-Koordinate
     * @param y die y-Koordinate
     * @return das Bild
     */
    @Override
    public Image getImage(int x, int y) {
        return cards[x][y].getAnzeige();
    }

    /**
     * Schaut, ob eine Karte angezeigt wird oder nicht.
     *
     * @param x die x-Koordinate
     * @param y die y-Koordinate
     * @return ob sie angezeigt wird oder nicht
     */
    @Override
    public boolean isSelected(int x, int y) {
        return cards[x][y].isTurned();
    }

    /**
     * Dreht die ausgewählte Karte.
     *
     * @param x        die x-Koordinate
     * @param y        die y-Koordinate
     * @param selected ob sie gezeigt werden soll oder nicht
     */
    @Override
    public void setSelected(int x, int y, boolean selected) {
        cards[x][y].setTurned(selected);
        playgroundListener.fireCardChange(x, y);
    }


    /**
     * Erstellt einen neuen Spieler.
     *
     * @param name     der Name des Spielers
     * @param yourTurn ob er an der Reihe ist
     */
    public void createPlayer(String name, boolean yourTurn) {
        logic.addNewPlayer(name, yourTurn);
    }

    /**
     * Hold alle Karten.
     *
     * @return die Karten
     */
    public PlayCard[][] getCards() {
        return cards;
    }

    /**
     * Setzt alle Karten.
     *
     * @param cards die Karten
     */
    public void setCards(PlayCard[][] cards) {
        this.cards = cards;
    }

    /**
     * Holt eine Karte nach seiner Position auf dem Spielfeld.
     *
     * @param row die Reihe
     * @param col die Spalte
     * @return die Karte
     */
    public PlayCard getCard(int row, int col) {
        return cards[row][col];
    }

    /**
     * Holt alle Bilder.
     *
     * @return die Bilder
     */
    public Vector<String> getImages() {
        return images;
    }

    /**
     * Setzt all die Bilder.
     *
     * @param images die Bilder
     */
    public void setImages(Vector<String> images) {
        this.images = images;
    }

    /**
     * Holt die Logik des Spielers.
     *
     * @return die Logik
     */
    public PlayerLogic getLogic() {
        return logic;
    }

    /**
     * Setzt die Logik des Spielers.
     *
     * @param logic die Logik
     */
    public void setLogic(PlayerLogic logic) {
        this.logic = logic;
    }

    /**
     * Holt den Listener des SpielfeldGui.
     *
     * @return den Listener des GUIs
     */
    public PlaygroundListener getPlaygroundListener() {
        return playgroundListener;
    }

    /**
     * Setzt den Listener des SpielfeldGui.
     *
     * @param playgroundListener der Listener
     */
    public void setPlaygroundListener(PlaygroundListener playgroundListener) {
        this.playgroundListener = playgroundListener;
    }

    /**
     * Holt den Spieler, der an der Reihe ist.
     *
     * @return der Spieler
     */
    public Player getCurrentPlayer() {
        if (getLogic().getPlayer(0).getYourTurn()) {
            return getLogic().getPlayer(0);
        } else {
            return getLogic().getPlayer(1);
        }
    }


    /**
     * Setzt den Gewinner einer Runde.
     *
     * @param player der Spieler, der gewonnen hat
     */
    public void setWinner(Player player) {
        player.setRoundsWon(player.getRoundsWon() + 1);
    }

    /**
     * Holt den Gewinner dieser Runde.
     *
     * @return der Spieler, der gewonnen hat
     */
    @Override
    public Player winner() {
        if (logic.getPlayer(0).getScore() > logic.getPlayer(1).getScore()) {
            return logic.getPlayer(0);
        } else {
            return logic.getPlayer(1);
        }
    }

    /**
     * Holt den Verlierer diese Runde.
     *
     * @return der Verlierer
     */
    @Override
    public Player loser() {
        if (logic.getPlayer(0).getScore() < logic.getPlayer(1).getScore()) {
            return logic.getPlayer(0);
        } else {
            return logic.getPlayer(1);
        }
    }
}
