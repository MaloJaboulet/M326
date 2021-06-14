package Model;

import SpielfeldKlassen.Karte;
import SpielfeldKlassen.Spieler;

import java.awt.*;
import java.util.Vector;

public class Spielfeld {

    private int[][] spielfeld;
    private int rows;
    private int columns;
    private final Color BACKGROUND = Color.green;
    private Vector<Karte> karten;
    private Vector<Spieler> spieler;

    public Spielfeld(int rows, int columns){
        setColumns(columns);
        setRows(rows);
    }

    public int[][] getSpielfeld() {
        return spielfeld;
    }

    public void setSpielfeld(int[][] spielfeld) {
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

    public void addKarte(Karte karte){
        karten.add(karte);
    }

    public void setKarten(Vector<Karte> karten) {
        this.karten = karten;
    }

    public Vector<Spieler> getSpieler() {
        return spieler;
    }

    public void addSpieler(Spieler spieler){
        this.spieler.add(spieler);
    }
    public void setSpieler(Vector<Spieler> spieler) {
        this.spieler = spieler;
    }

    public void giveTurn(){

    }

    public void endGame(){

    }

    public boolean compareCards(Karte karte1, Karte karte2){
        if (karte1.getBackground() == karte2.getBackground()){
            return true;
        }else {
            return false;
        }
    }
}
