package Model;

import SpielfeldKlassen.Karte;
import SpielfeldKlassen.Spieler;

import java.awt.*;

public abstract class SpielfeldModel implements KartenInterface {

    @Override
    public Karte getKarte(int rowIndex, int colIndex) {
        return null;
    }

    @Override
    public Spieler getSpieler(String spielerName) {
        return null;
    }

    @Override
    public Spieler getSpielerMitNummer(int spielerNummer) {
        return null;
    }

    @Override
    public Spieler getSpieler(int index) {
        return null;
    }

    @Override
    public int getRows() {
        return 0;
    }

    @Override
    public int getColumns() {
        return 0;
    }

    @Override
    public Image getBild(Karte karte) {
        return null;
    }
}
