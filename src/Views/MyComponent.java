package Views;

import Model.Spielfeld;
import SpielfeldKlassen.Karte;
import SpielfeldKlassen.Spiellogik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyComponent extends JPanel implements MouseListener {

    private String[][] referenzen;
    private Spiellogik spiellogik;
    private Spielfeld spielfeld;

    public MyComponent(int rows, int cols, Spielfeld spielfeld){
        this.spielfeld = spielfeld;
        this.spiellogik = new Spiellogik(this.spielfeld.getSpieler());
        referenzen = new String[rows][cols];
        super.setLayout(new GridLayout(rows, cols, 10,10));

    }

    public void setKarten(int row, int cols, Karte[][] karten){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                MyJLabel myJLabel = new MyJLabel(karten[i][j], spiellogik);
                myJLabel.addMouseListener(this);

                referenzen[i][j] = myJLabel.toString();

                this.add(myJLabel);
            }
        }
        spiellogik.setReferenzen(referenzen);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MyJLabel myJLabel = (MyJLabel) e.getSource();
        Karte karte = myJLabel.getKarte();
        myJLabel.setIcon(new ImageIcon(spiellogik.turnKarte(karte)));


        /*Karte karte = model.getKarte(row, col);


        button.setIcon(new ImageIcon(spiellogik.turnKarte(karte)));
        int resultat = spiellogik.compareCard(karte);

        System.out.println("Klick");
        System.out.println("Spieler: " + spiellogik.getAktSpieler().getSpielerName());

        if (resultat == 1) {
            spiellogik.givePoints(spiellogik.getAktSpieler(), 1);
            button.setEnabled(false);
        } else if (resultat == -1) {
            spiellogik.turnSpielerTurn();
            button.setBackground(Color.blue);
        }
*/

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
