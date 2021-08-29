package gui;

import data.Playground;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * @since 07.07.2021
 * <p>
 * Das ist das Auswertungsgui des Spieles.
 * Hier werden der Gewinner und Verlierer angezeigt und dem Benutzer die Möglichkeit gegeben nochmals zu spielen oder etwas anderes zu machen.
 */
public class AuswertungsGui extends JFrame {

    /**
     * Der Konstruktor des GUIs, wo das GUI erstellt wird.
     *
     * @param playground die Datensammlung des Spielfelds
     */
    public AuswertungsGui(Playground playground) {
        playground.setWinner(playground.winner()); //Setzt den Gewinner
        Color hintergrundFarbe = new Color(52, 155, 235);

        this.setTitle("Auswertungsgui");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Das Hauptpanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 0, 200));
        panel.setBackground(new Color(113, 139, 245));

        // Die Tabelle mit dem Gewinner und Verlierer
        JPanel auswertungsTabelle = new JPanel(new GridLayout(1, 2, 250, 0));
        auswertungsTabelle.setOpaque(false);

        //Der Titel
        JLabel titel = new JLabel("Auswertung des Memory Game");
        titel.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel titelPanel = new JPanel();
        titelPanel.setOpaque(false);
        titelPanel.add(titel);


        //Das Gewinnerpanel
        JPanel gewinnerPanel = new JPanel();
        gewinnerPanel.setLayout(new GridLayout(3, 1));

        //Panel mit dem Gewinnername
        JPanel panelTemp = new JPanel(new GridLayout(1, 2));
        JLabel winnerLabel = new JLabel("Gewinner");
        JLabel gewinnerName = new JLabel(playground.winner().getName());

        panelTemp.add(winnerLabel);
        panelTemp.add(gewinnerName);
        panelTemp.setBackground(Color.green);
        panelTemp.setBorder(BorderFactory.createLineBorder(Color.black, 5));

        //Panel mit den Punkten
        JPanel punkteGewinnerPanel = new JPanel(new GridLayout(1, 2));
        punkteGewinnerPanel.setBackground(hintergrundFarbe);
        punkteGewinnerPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));

        JLabel gewinnerPunkte = new JLabel(String.valueOf(playground.winner().getScore()));
        JLabel gewinnerPunkteText = new JLabel("Punkte");

        punkteGewinnerPanel.add(gewinnerPunkteText);
        punkteGewinnerPanel.add(gewinnerPunkte);

        //Panel mit den Anzahl gewonnenen Runden
        JPanel rundenGewinnerPanel = new JPanel(new GridLayout(1, 2));
        rundenGewinnerPanel.setBackground(hintergrundFarbe);
        rundenGewinnerPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));

        JLabel gewinnerRunden = new JLabel(String.valueOf(playground.winner().getRoundsWon()));
        JLabel gewinnerRundenText = new JLabel("Runden");

        rundenGewinnerPanel.add(gewinnerRundenText);
        rundenGewinnerPanel.add(gewinnerRunden);


        gewinnerPanel.add(panelTemp);
        gewinnerPanel.add(punkteGewinnerPanel);
        gewinnerPanel.add(rundenGewinnerPanel);


        //Das Verliererpanel
        JPanel verliererPanel = new JPanel();
        verliererPanel.setLayout(new GridLayout(3, 1));

        //Panel mit dem Verlierername
        JPanel verliererNamePanel = new JPanel(new GridLayout(1, 2));
        JLabel verliererLabel = new JLabel("Verlierer");
        JLabel verliererName = new JLabel(playground.loser().getName());

        verliererNamePanel.add(verliererLabel);
        verliererNamePanel.add(verliererName);
        verliererNamePanel.setBackground(Color.red);
        verliererNamePanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));

        //Panel mit den Punkten
        JPanel punkteVerliererPanel = new JPanel(new GridLayout(1, 2));
        punkteVerliererPanel.setBackground(hintergrundFarbe);
        punkteVerliererPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));

        JLabel verliererPunkte = new JLabel(String.valueOf(playground.loser().getScore()));
        JLabel verliererPunkteText = new JLabel("Punkte");

        punkteVerliererPanel.add(verliererPunkteText);
        punkteVerliererPanel.add(verliererPunkte);

        //Panel mit den gewonnen Runden
        JPanel rundenVerliererPanel = new JPanel(new GridLayout(1, 2));
        rundenVerliererPanel.setBackground(hintergrundFarbe);
        rundenVerliererPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));

        JLabel verliererRunden = new JLabel(String.valueOf(playground.loser().getRoundsWon()));
        JLabel verliererRundenText = new JLabel("Runden");

        rundenVerliererPanel.add(verliererRundenText);
        rundenVerliererPanel.add(verliererRunden);


        verliererPanel.add(verliererNamePanel);
        verliererPanel.add(punkteVerliererPanel);
        verliererPanel.add(rundenVerliererPanel);

        auswertungsTabelle.add(gewinnerPanel);
        auswertungsTabelle.add(verliererPanel);

        auswertungsTabelle.setBorder(new EmptyBorder(0, 200, 0, 200));


        //Buttons
        JPanel buttons = new JPanel(new GridLayout(1, 4));
        buttons.setPreferredSize(new Dimension(1920, 50));
        buttons.setMaximumSize(new Dimension(1920, 50));

        JButton beenden = new JButton("Beenden");
        beenden.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        beenden.addActionListener(new ActionListener() {
            /**
             * Wenn der Button gedrückt wird, wird das Programm geschlossen.
             *
             * @param e das Event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().dispose();
            }
        });

        JButton haupmenu = new JButton("Hauptmenü");
        haupmenu.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        haupmenu.addActionListener(new ActionListener() {
            /**
             * Wenn der Button gedrückt wird, wird der Benutzer zum Haupmenü geführt.
             *
             * @param e das Event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartView();
                getFrame().dispose();
            }
        });

        /*JButton speichern = new JButton("Speichern");
        speichern.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        speichern.addActionListener(new ActionListener() {
            /**
             * Speichert den Spielstand des Spiels.
             *
             * @param e das Event
             */
            /*@Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Speichern");
            }
        });*/

        JButton nochmalsSpielen = new JButton("Nochmals spielen");
        nochmalsSpielen.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        nochmalsSpielen.addActionListener(new ActionListener() {
            /**
             * Wenn der Button gedrückt wird, wird das Spielfeld neu erstellt und es wird nochmals gespielt.
             *
             * @param e das Event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                playground.restoreData();
                new PlaygroundGui(playground);
                getFrame().dispose();
            }
        });

        buttons.add(beenden);
        buttons.add(haupmenu);
        //buttons.add(speichern);
        buttons.add(nochmalsSpielen);

        panel.add(titelPanel);
        panel.add(auswertungsTabelle);
        panel.add(buttons);


        this.add(panel, BorderLayout.CENTER);
        this.getContentPane().setBackground(new Color(113, 139, 245));
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
