package Model;

import SpielfeldKlassen.Karte;
import SpielfeldKlassen.Spieler;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Spielfeld extends SpielfeldModel{

    private Karte[][] spielfeld;
    private int rows;
    private int columns;
    private Vector<Karte> karten;
    private Vector<Spieler> spielern;
    private Vector<String> bilder;


    public Spielfeld(int rows, int columns) {
        spielfeld = new Karte[rows][columns];
        karten = new Vector<>();
        spielern = new Vector<>();
        setColumns(columns);
        setRows(rows);
        setBilder(createBilder(rows, columns));
        createKarten(rows, columns);
        fillSpielfeld(rows, columns);
    }

    public Spielfeld(int rows, int columns, String  spieler1Name, String  spieler2Name) {
        spielfeld = new Karte[rows][columns];
        karten = new Vector<>();
        spielern = new Vector<>();
        setColumns(columns);
        setRows(rows);
        setBilder(createBilder(rows, columns));
        createKarten(rows, columns);
        fillSpielfeld(rows, columns);
        createSpieler(spieler1Name,spieler2Name);

    }

    public Karte[][] getSpielfeld() {
        return spielfeld;
    }

    public Karte getKarteImSpielfeld(int rows, int columns) {
        return spielfeld[rows][columns];
    }

    public void fillSpielfeld(int rows, int columns) {
        int zaehler = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                spielfeld[i][j] = karten.get(zaehler);
                zaehler++;
            }
        }
    }

    public void setSpielfeld(Karte[][] spielfeld) {
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

    public Vector<Karte> getKarten() {
        return karten;
    }

    public void createKarten(int row, int col) {
        int zaehler = 0;
        for (int i = 0; i < (row * col); i++) {
            double randZahl;

            while (true) {
                randZahl = Math.random() * getBilder().size();
                if (getBilder().get((int) randZahl) != null) {
                    break;
                }
            }
            if (zaehler == (row * col)/2) {
                zaehler = 0;
            }

            //Karte karte = new Karte(new ImageIcon("./Img/"+getBilder().get(zaehler)).getImage(), false, i);
            Karte karte = new Karte(new ImageIcon(this.getClass().getResource("../Img/"+(zaehler+1)+".jpg")).getImage(), false, i);
            karte.setForeground(new ImageIcon(this.getClass().getResource("../Img/foreground.jpg")).getImage());
            addKarte(karte);
            zaehler++;
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

    @Override
    public Image getBild(Karte karte) {
        return karte.getBackground();
    }


    public void addKarte(Karte karte) {
        karten.add(karte);
    }

    public void setKarten(Vector<Karte> karten) {
        this.karten = karten;
    }

    public Vector<Spieler> getSpieler() {
        return spielern;
    }

    public void addSpieler(Spieler spieler) {
        this.spielern.add(spieler);
    }

    public void setSpieler(Vector<Spieler> spieler) {
        this.spielern = spieler;
    }

    public void createSpieler(String name1, String name2){
            if (name2 != null){
                addSpieler(new Spieler(name1, true));
                addSpieler( new Spieler(name2,false));
            }else {
                Spieler spieler1 = new Spieler(name1,true);
                addSpieler(spieler1);
        }
    }

    public boolean compareCards(Karte karte1, Karte karte2) {
        return karte1.getBackground() == karte2.getBackground();
    }

    @Override
    public Karte getKarte(int rowIndex, int colIndex) {
        return spielfeld[rowIndex][colIndex];
    }

    @Override
    public Spieler getSpieler(String spielerName) {
        for (Spieler spieler : spielern) {
            if (spieler.getSpielerName() == spielerName) {
                return spieler;
            }
        }
        return null;
    }

    @Override
    public Spieler getSpielerMitNummer(int spielerNummer) {
        for (Spieler spieler : spielern) {
            if (spieler.getSpielerName().contains(Integer.toString(spielerNummer))) {
                return spieler;
            }
        }
        return null;
    }

    @Override
    public Spieler getSpieler(int index) {
        if (index < spielern.size()){
            return spielern.get(index);
        }
        return null;
    }
}
