package Model;

import SpielfeldKlassen.Karte;
import SpielfeldKlassen.Spieler;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.Vector;

public class Spielfeld extends AbstractTableModel {

    private Image[][] spielfeld;
    private int rows;
    private int columns;
    private final Color BACKGROUND = Color.green;
    private Vector<Karte> karten;
    private Vector<Spieler> spieler;
    private Vector<String> bilder;


    public Spielfeld(int rows, int columns) {
        spielfeld = new Image[rows][columns];
        karten = new Vector<>();
        setColumns(columns);
        setRows(rows);
        setBilder(createBilder(rows, columns));
        createKarten(rows,columns);
        fillSpielfeld(rows,columns);

    }

    public Image[][] getSpielfeld() {
        return spielfeld;
    }

    public Image getKarteImSpielfeld(int rows, int columns){
        return spielfeld[rows][columns];
    }

    public void fillSpielfeld(int rows, int columns){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                spielfeld[i][j] = karten.get((i*j)).getBackground();
            }
        }
    }

    public void setSpielfeld(Image[][] spielfeld) {
        this.spielfeld = spielfeld;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Color getBACKGROUND() {
        return BACKGROUND;
    }

    public Vector<Karte> getKarten() {
        return karten;
    }

    public void createKarten(int row, int col) {
        int zaehler = 1;
        for (int i = 0; i < (row * col); i++) {


            double randZahl;

            while (true) {
                randZahl = Math.random() * getBilder().size();
                if (getBilder().get((int) randZahl) != null) {
                    break;
                }
            }
            if (zaehler == 50) {
                zaehler = 1;
            }

            Karte karte = new Karte(new ImageIcon("./Img/"+getBilder().get(zaehler)).getImage(), false, i);
            addKarte(karte);
        }
    }

    public Vector<String> createBilder(int rows, int columns) {
        Vector<String> bilderVec = new Vector<>();

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= (rows * columns) / 2; j++) {
                bilderVec.add(j + ".jpg");
            }
        }
        return bilderVec;
    }

    public void setBilder(Vector<String> bilderVec) {
        bilder = bilderVec;
    }

    public Vector<String> getBilder() {
        return bilder;
    }

    public void addKarte(Karte karte) {
        karten.add(karte);
    }

    public void setKarten(Vector<Karte> karten) {
        this.karten = karten;
    }

    public Vector<Spieler> getSpieler() {
        return spieler;
    }

    public void addSpieler(Spieler spieler) {
        this.spieler.add(spieler);
    }

    public void setSpieler(Vector<Spieler> spieler) {
        this.spieler = spieler;
    }

    public void giveTurn() {

    }

    public void endGame() {

    }

    public boolean compareCards(Karte karte1, Karte karte2) {
        return karte1.getBackground() == karte2.getBackground();
    }

    @Override
    public int getRowCount() {
        return getRows();
    }

    @Override
    public int getColumnCount() {
        return getColumns();
    }

    @Override
    public Image getValueAt(int rowIndex, int columnIndex) {
        return getKarteImSpielfeld(rowIndex, columnIndex);
    }
}
