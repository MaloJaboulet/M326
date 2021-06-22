package Views;

import SpielfeldKlassen.Karte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Vector;


public class SpielfeldView extends JFrame {
    private Vector<Karte> karten;
    private Vector<ImageIcon> hintergrundBilder;
    private JPanel spielfeld;


    public SpielfeldView(int row, int col) {
        karten = new Vector<>();
        hintergrundBilder = new Vector<>();

        this.setTitle("Spielfeld");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        spielfeld = new JPanel();
        spielfeld.setLayout(new GridLayout(row, col, 10, 10));
        createCards(row, col);

        JLabel titel = new JLabel("Memory Game");

        this.add(titel);
        this.add(spielfeld);


        this.setVisible(true);
    }


    public void createCards(int row, int col) {
            for (int i = 0; i < (row * col); i++) {
                Karte karte = new Karte(false, i);
                karten.add(karte);

                Image photo = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../Img/1.jpg"))).getImage();

                hintergrundBilder.add(new ImageIcon(photo));
                JButton buttonKarte = new JButton();

                buttonKarte.setBackground(karte.getFOREGROUND());
                buttonKarte.addActionListener(new ButtonActionListener());
                spielfeld.add(buttonKarte);
            }
    }

    class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton kickedButton = (JButton) e.getSource();
            kickedButton.setIcon(hintergrundBilder.get(0));
        }
    }
}
