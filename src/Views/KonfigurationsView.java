package Views;

import Model.Spielfeld;
import SpielfeldKlassen.Spieler;

import javax.swing.*;

import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class KonfigurationsView extends JFrame {

    private JTextField spieler1Name;
    private JTextField spieler2Name;
    private final String[] spielerAnzahl = {"Singleplayer", "2 Players"};


    public KonfigurationsView() {
        this.setTitle("Konfiguration");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


        JLabel titel = new JLabel("Konfiguration des Spiels");

        JPanel mittelPanel = new JPanel();
        mittelPanel.setLayout(new BoxLayout(mittelPanel, BoxLayout.Y_AXIS));

        JComboBox anzahlSpieler = new JComboBox(spielerAnzahl);
        anzahlSpieler.setSize(200, 100);
        anzahlSpieler.setSelectedIndex(0);

        JPanel spielerNamen = new JPanel(new GridLayout(1, 2, 20, 20));
        spieler1Name = new JTextField("Name Spieler 1:");
        spieler2Name = new JTextField("Name Spieler 2:");

        spielerNamen.add(spieler1Name);
        spielerNamen.add(spieler2Name);

        Spieler spieler1 = new Spieler(spieler1Name.getText(), true);
        Spieler spieler2 = new Spieler(spieler2Name.getText(), false);


        JPanel colRow = new JPanel();
        colRow.setLayout(new GridLayout(1, 2, 15, 15));

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(5);
        formatter.setMaximum(10);
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        JLabel spielfeld = new JLabel("Geben Sie die Spielfeldgrösse ein: (5x5 bis 10x10)");


        JTextField spielfeldRow = new JFormattedTextField(formatter);
        spielfeldRow.setText("Anzahl Zeilen");
        JTextField spielfeldCol = new JFormattedTextField(formatter);
        spielfeldCol.setText("Anzahl Spalten");

        colRow.add(spielfeldRow);
        colRow.add(spielfeldCol);


        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Spielfeld spielfeld = new Spielfeld(Integer.parseInt(spielfeldRow.getText())
                        , Integer.parseInt(spielfeldCol.getText()));

                spielfeld.addSpieler(spieler1);
                spielfeld.addSpieler(spieler2);

                new SpielfeldView(new Spielfeld(Integer.parseInt(spielfeldRow.getText()),Integer.parseInt(spielfeldCol.getText())));
                getFrame().dispose();
            }
        });

        JPanel buttons = new JPanel(new GridLayout(1, 2, 15, 15));
        buttons.setMaximumSize(new Dimension(450, 250));
        buttons.setAlignmentX(0.425f);


        JButton verlassen = new JButton("Verlassen");
        verlassen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartView();
                getFrame().dispose();
            }
        });

        JButton beenden = new JButton("Beenden");
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().dispose();
            }
        });


        buttons.add(verlassen);
        buttons.add(beenden);

        mittelPanel.add(titel);
        mittelPanel.add(anzahlSpieler);
        mittelPanel.add(spielerNamen);
        mittelPanel.add(spielfeld);
        mittelPanel.add(colRow);
        mittelPanel.add(start);
        mittelPanel.add(buttons);


        this.add(mittelPanel);


        this.setVisible(true);

    }

    public JFrame getFrame() {
        return this;
    }

}
