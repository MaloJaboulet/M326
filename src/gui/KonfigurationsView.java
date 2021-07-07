package gui;

import data.Playground;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * @author Malo Jaboulet
 * @since 07.07.2021
 * @version 1.0
 */
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
        spieler1Name = new JTextField("Name Spieler 1: ");
        spieler2Name = new JTextField("Name Spieler 2: ");

        spielerNamen.add(spieler1Name);
        spielerNamen.add(spieler2Name);


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
                if (spielfeldRow.getText().equals("")){
                    spielfeldRow.setText("5");
                }
                if (spielfeldCol.getText().equals("")){
                    spielfeldCol.setText("5");
                }

                Playground playground = new Playground(Integer.parseInt(spielfeldRow.getText()),
                        Integer.parseInt(spielfeldCol.getText()));

                String name1;
                if(spieler1Name.getText().equals("Name Spieler 1: ")){
                    name1 = "Spieler 1";
                }else {
                    name1 = spieler1Name.getText().replace("Name Spieler 1 :", "");
                }
                String name2;
                if(spieler2Name.getText().equals("Name Spieler 2: ")){
                    name2 = "Spieler 2";
                }else {
                    name2 = spieler2Name.getText().replace("Name Spieler 2 :", "");
                }


                playground.getLogic().addNewPlayer(name1, true);
                playground.getLogic().addNewPlayer(name2, false);

                PlaygroundGui playgroundGui = new PlaygroundGui(playground);

               // new AuswertungsGui(playground);
                getFrame().dispose();
            }
        });

        JPanel buttons = new JPanel(new GridLayout(1, 2, 15, 15));
        buttons.setMaximumSize(new Dimension(450, 250));



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
