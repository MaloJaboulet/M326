package Views;

import SpielfeldKlassen.Karte;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class SpielfeldView extends JFrame {
    private Vector<Karte> karten;
    private Vector<ImageIcon> hintergrundBilder;
    private JPanel spielfeld;
    private AbstractTableModel model;


    public SpielfeldView(AbstractTableModel model) {
        this.model = model;

        karten = new Vector<>();
        hintergrundBilder = new Vector<>();

        this.setTitle("Spielfeld");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        spielfeld = new JPanel();
        spielfeld.setLayout(new GridLayout(model.getRowCount(), model.getColumnCount(), 15, 15));



        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                JButton button = new JButton();


                //button.setIcon(new ImageIcon(this.getClass().getResource("1.jpg")));
                button.setBackground(Color.green);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton)e.getSource();
                        System.out.println("Klick");
                    }
                });
                spielfeld.add(button);
            }
        }


        JLabel titel = new JLabel("Memory Game");

        this.add(titel);
        this.add(spielfeld);


        this.setVisible(true);
    }
}
