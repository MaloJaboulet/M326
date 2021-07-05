package Views;

import Model.Spielfeld;
import SpielfeldKlassen.Karte;
import SpielfeldKlassen.Spiellogik;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;


public class SpielfeldView extends JFrame implements SpielfeldInterface {
    private Vector<Karte> karten;
    private Vector<ImageIcon> hintergrundBilder;
    private MyComponent spielfeld;
    private Spielfeld model;
    private Spiellogik spiellogik;


    public SpielfeldView(Spielfeld _model) {
        this.model = _model;
        spiellogik = new Spiellogik(model.getSpieler());

        //karten = new Vector<>();
        //hintergrundBilder = new Vector<>();

        this.setTitle("Spielfeld");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel spielAngaben = new JPanel();
        JLabel runde = new JLabel("Runde: ");

        JPanel mittelPanel = new JPanel();
        JLabel spieler1 = new JLabel();
        /*if (model.getSpieler(0) != null && model.getSpieler(0).getSpielerName().equals("spieler1")) {
            Spieler spieler = model.getSpielerMitNummer(1);
            spieler1 = new JLabel("Spieler 1: "+String.valueOf(spieler.getPoints()));
        }else {
            Spieler spieler = model.getSpieler(0);
            spieler1 = new JLabel(spieler.getSpielerName()+": "+String.valueOf(spieler.getPoints()));
        }

        JLabel spieler2 = new JLabel();
        if (model.getSpieler(1) != null && model.getSpieler(1).getSpielerName().equals("spieler2")) {
            Spieler spieler = model.getSpielerMitNummer(2);
            spieler2 = new JLabel("Spieler 2: "+String.valueOf(spieler.getPoints()));
        }else {
            Spieler spieler = model.getSpieler(1);
            spieler2 = new JLabel(spieler.getSpielerName()+": "+String.valueOf(spieler.getPoints()));
        }

        mittelPanel.add(spieler1);
        mittelPanel.add(spieler2);

         */

        spielAngaben.add(runde, BorderLayout.WEST);
        spielAngaben.add(mittelPanel, BorderLayout.CENTER);





        spielfeld = new MyComponent(model.getRows(),model.getColumns(), model);
        spielfeld.setKarten(model.getRows(), model.getColumns(), model.getSpielfeld());


        JLabel titel = new JLabel("Memory Game");

        this.add(titel);
        this.add(spielAngaben, BorderLayout.NORTH);
        this.add(spielfeld);

        this.setVisible(true);
    }

    @Override
    public void firePicChanged(int row, int col, Image pic) {
        MyJLabel myJLabel = (MyJLabel) spielfeld.getComponentAt(row,col);
        myJLabel.setIcon(new ImageIcon(pic));
    }

    @Override
    public void firePicDisable(int row, int col) {
        MyJLabel myJLabel = (MyJLabel) spielfeld.getComponentAt(row,col);
        myJLabel.setEnabled(false);
    }


}

