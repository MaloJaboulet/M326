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
 * @version 1.0
 * @since 07.07.2021
 * <p>
 * Das ist das GUI für die Konfiguration des Spiels. Der Benutzer kann wählen,
 * ob das Spiel "Singleplayer" oder "2 Players" ist. Er kann auch die Grösse des Spielfelds wählen und die Namen
 * der Spieler eintragen.
 */
public class KonfigurationsView extends JFrame {

    private JTextField spieler1Name;
    private JTextField spieler2Name;
    private final String[] spielerAnzahl = {"Singleplayer", "2 Players"};

    /**
     * Der Konstruktor der Klasse und hier wird das GUI erstellt.
     */
    public KonfigurationsView() {
        this.setTitle("Konfiguration");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


        JLabel titel = new JLabel("Konfiguration des Spiels");
        titel.setHorizontalAlignment(SwingConstants.CENTER);

        //Das Panel mit all den Komponenten
        JPanel mittelPanel = new JPanel();
        mittelPanel.setLayout(new BoxLayout(mittelPanel, BoxLayout.Y_AXIS));

        //Die Auswahl zwischen Singleplayer und Muliplayer
        JComboBox anzahlSpieler = new JComboBox(spielerAnzahl);
        anzahlSpieler.setSize(200, 100);
        anzahlSpieler.setSelectedIndex(0);

        //Namen der Spieler
        JPanel spielerNamen = new JPanel(new GridLayout(1, 2, 20, 20));
        spieler1Name = new JTextField("Name Spieler 1: ");
        spieler2Name = new JTextField("Name Spieler 2: ");

        spielerNamen.add(spieler1Name);
        spielerNamen.add(spieler2Name);

        //Reihen und Spalten
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

        //Anzahl Reihen
        JTextField spielfeldRow = new JFormattedTextField(formatter);
        spielfeldRow.setText("Anzahl Zeilen");

        //Anzahl Spalten
        JTextField spielfeldCol = new JFormattedTextField(formatter);
        spielfeldCol.setText("Anzahl Spalten");


        colRow.add(spielfeldRow);
        colRow.add(spielfeldCol);

        //Button
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            /**
             * Wenn der Startknopf gedrück wird, wird das Spiel gestartet und das Spielfeld wird sichtbar.
             *
             * @param e das Event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //Wenn keine Spalten oder Reihen eingegeben wird, wird auf 5x5 gesetzt.
                if (spielfeldRow.getText().equals("")) {
                    spielfeldRow.setText("5");
                }
                if (spielfeldCol.getText().equals("")) {
                    spielfeldCol.setText("5");
                }

                Playground playground = new Playground(Integer.parseInt(spielfeldRow.getText()),
                        Integer.parseInt(spielfeldCol.getText()));

                //Der Name der Spieler wird umgeformt und dann übergeben.
                String name1;
                if (spieler1Name.getText().equals("Name Spieler 1: ")) {
                    name1 = "Spieler 1";
                } else {
                    name1 = spieler1Name.getText().replace("Name Spieler 1 :", "");
                }
                String name2;
                if (spieler2Name.getText().equals("Name Spieler 2: ")) {
                    name2 = "Spieler 2";
                } else {
                    name2 = spieler2Name.getText().replace("Name Spieler 2 :", "");
                }


                playground.getLogic().addNewPlayer(name1, true);
                playground.getLogic().addNewPlayer(name2, false);

                PlaygroundGui playgroundGui = new PlaygroundGui(playground);

                getFrame().dispose();
            }
        });

        //Panel mit Buttons
        JPanel buttons = new JPanel(new GridLayout(1, 2, 15, 15));
        buttons.setMaximumSize(new Dimension(450, 250));


        JButton verlassen = new JButton("Verlassen");
        verlassen.addActionListener(new ActionListener() {
            /**
             * Die Konfiguration wird abgebrochen und der Benutzer wird zum Hauptmenü geführt.
             *
             * @param e das Event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartView();
                getFrame().dispose();
            }
        });

        JButton beenden = new JButton("Beenden");
        beenden.addActionListener(new ActionListener() {
            /**
             * Das Programm wird geschlossen.
             *
             * @param e das Event
             */
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

    /**
     * Holt das JFrame.
     *
     * @return das JFrame
     */
    public JFrame getFrame() {
        return this;
    }

}
