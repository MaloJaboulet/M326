package Views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class KonfigurationsView extends JFrame {

    private JTextField spieler1Name;
    private JTextField spieler2Name;
    private final String[] spielerAnzahl = {"Singleplayer", "2 Players"};


    public KonfigurationsView(){
        this.setTitle("Konfiguration");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


        JLabel titel = new JLabel("Konfiguration des Spiels");

        JPanel mittelPanel = new JPanel();
        mittelPanel.setLayout(new BoxLayout(mittelPanel,BoxLayout.Y_AXIS));

        JComboBox anzahlSpieler = new JComboBox(spielerAnzahl);
        anzahlSpieler.setSize(200,100);
        anzahlSpieler.setSelectedIndex(0);

        JPanel spielerNamen = new JPanel(new GridLayout(1,2,20,20));
        TextField spieler1Name = new TextField("Name Spieler 1:");
        TextField spieler2Name = new TextField("Name Spieler 2:");

        spielerNamen.add(spieler1Name);
        spielerNamen.add(spieler2Name);


        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(10);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        JLabel spielfeld = new JLabel("Geben Sie die Spielfeldgrösse ein: (5x5 bis 10x10)");
        JTextField spielfeldGroesse = new JFormattedTextField(formatter);


        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SpielfeldView();
            }
        });

        JPanel buttons = new JPanel(new GridLayout(1,2,15,15));
        buttons.setMaximumSize(new Dimension(450,250));
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
        mittelPanel.add(spielfeldGroesse);
        mittelPanel.add(start);
        mittelPanel.add(buttons);



        this.add(mittelPanel);


        this.setVisible(true);

    }
    public JFrame getFrame(){
        return this;
    }
}
