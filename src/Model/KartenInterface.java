package Model;

import SpielfeldKlassen.Karte;
import SpielfeldKlassen.Spieler;

import java.awt.*;

interface KartenInterface {


    public Karte getKarte(int rowIndex, int colIndex);

    public Spieler getSpieler(String spielerName);

    public Spieler getSpielerMitNummer(int spielerNummer);

    public Spieler getSpieler(int index);

    public int getRows();

    public int getColumns();

    public Image getBild(Karte karte);


}
