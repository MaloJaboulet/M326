package Views;

import SpielfeldKlassen.Karte;
import SpielfeldKlassen.Spiellogik;

import javax.swing.*;

public class MyJLabel extends JLabel {

    private Karte karte;
    private Spiellogik spiellogik;

    public MyJLabel(Karte karte, Spiellogik spiellogik) {
        this.spiellogik = spiellogik;
        this.setIcon(new ImageIcon(karte.getForeground()));
        setKarte(karte);
    }




    public void setKarte(Karte karte) {
        this.karte = karte;
    }

    public Karte getKarte() {
        return karte;
    }


}
