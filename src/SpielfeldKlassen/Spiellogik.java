package SpielfeldKlassen;

import java.awt.*;
import java.util.Vector;

public class Spiellogik {
    private Karte karteTem;
    private int anzahlUmgedrehteKarten;
    private Vector<Spieler> spielers;
    private String[][] referenzen;

    public Spiellogik(Vector<Spieler> spielers) {
        anzahlUmgedrehteKarten = 0;
        this.spielers = spielers;
    }


    public Image turnKarte(Karte karte) {
        if (anzahlUmgedrehteKarten == 0) {
            if (karte.isTurned()) {
                karteTem = karte;
                anzahlUmgedrehteKarten++;

                karte.setTurned(false);
                return karte.getForeground();
            } else {
                karte.setTurned(true);

                return karte.getBackground();
            }
        } else if (anzahlUmgedrehteKarten == 1) {
            int resultatl = compareCard(karte, karteTem);
            if (resultatl == 1) {
                getPositionKarte(karte);
                getAktSpieler().givePoint(1);
            } else {
                turnSpielerTurn();
            }
        }
        return null;
    }

    public int compareCard(Karte karte, Karte karteTem) {
        if ((karte.getBackground()).toString().equals(karteTem.getBackground().toString())) {
            return 1;
        } else {
            return -1;
        }
    }

    public void givePoints(Spieler spieler, int point) {
        spieler.givePoint(point);
    }

    public Karte getKarteTem() {
        return karteTem;
    }

    public Spieler getAktSpieler() {
        for (Spieler spieler : spielers) {
            if (spieler.isYourTurn()) {
                return spieler;
            }
        }
        return null;
    }

    public void turnSpielerTurn() {
        for (Spieler spieler : spielers) {
            if (spieler.isYourTurn()) {
                spieler.setYourTurn(false);
            } else {
                spieler.setYourTurn(true);
            }
        }
    }

    public void setReferenzen(String[][] referenzen){
        this.referenzen = referenzen;
    }

    public String getPositionKarte(Karte karte){
        System.out.println(referenzen.length);
        return "";
    }
}
