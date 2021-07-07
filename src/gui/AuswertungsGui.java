package gui;

import data.Playground;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuswertungsGui extends JFrame {

    public AuswertungsGui(Playground playground){
        this.setTitle("Auswertungsgui");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1,0,200));

        JPanel auswertungsTabelle = new JPanel(new GridLayout(1,2,250,0));
        auswertungsTabelle.setOpaque(false);


        panel.setBackground(new Color(113,139,245));

        JLabel titel = new JLabel("Auswertung des Memory Game");
        titel.setFont(new Font("Arial",Font.BOLD,30));

        JPanel titelPanel = new JPanel();
        titelPanel.setOpaque(false);
        titelPanel.add(titel);


        //Das Gewinnerpanel

        JPanel gewinnerPanel = new JPanel();
        gewinnerPanel.setLayout(new GridLayout(3,1));


        JPanel panelTemp = new JPanel(new GridLayout(1,2));
        JLabel winnerLabel = new JLabel("Gewinner");
        JLabel gewinnerName = new JLabel(playground.winner().getName());

        panelTemp.add(winnerLabel);
        panelTemp.add(gewinnerName);
        panelTemp.setBackground(Color.green);
        panelTemp.setBorder(BorderFactory.createLineBorder(Color.black,5));

        JPanel punkteGewinnerPanel = new JPanel(new GridLayout(1,2));
        punkteGewinnerPanel.setBackground(Color.cyan);
        punkteGewinnerPanel.setBorder(BorderFactory.createLineBorder(Color.black,5));

        JLabel gewinnerPunkte = new JLabel(String.valueOf(playground.winner().getScore()));
        JLabel gewinnerPunkteText = new JLabel("Punkte");

        punkteGewinnerPanel.add(gewinnerPunkteText);
        punkteGewinnerPanel.add(gewinnerPunkte);


        JPanel rundenGewinnerPanel = new JPanel(new GridLayout(1,2));
        rundenGewinnerPanel.setBackground(Color.cyan);
        rundenGewinnerPanel.setBorder(BorderFactory.createLineBorder(Color.black,5));

        JLabel gewinnerRunden = new JLabel("1");
        JLabel gewinnerRundenText = new JLabel("Runden");

        rundenGewinnerPanel.add(gewinnerRundenText);
        rundenGewinnerPanel.add(gewinnerRunden);


        gewinnerPanel.add(panelTemp);
        gewinnerPanel.add(punkteGewinnerPanel);
        gewinnerPanel.add(rundenGewinnerPanel);


        //Das Verliererpanel

        JPanel verliererPanel = new JPanel();
        verliererPanel.setLayout(new GridLayout(3,1));


        JPanel verliererNamePanel = new JPanel(new GridLayout(1,2));
        JLabel verliererLabel = new JLabel("Gewinner");
        JLabel verliererName = new JLabel(playground.loser().getName());

        verliererNamePanel.add(verliererLabel);
        verliererNamePanel.add(verliererName);
        verliererNamePanel.setBackground(Color.red);
        verliererNamePanel.setBorder(BorderFactory.createLineBorder(Color.black,5));

        JPanel punkteVerliererPanel = new JPanel(new GridLayout(1,2));
        punkteVerliererPanel.setBackground(Color.cyan);
        punkteVerliererPanel.setBorder(BorderFactory.createLineBorder(Color.black,5));

        JLabel verliererPunkte = new JLabel(String.valueOf(playground.loser().getScore()));
        JLabel verliererPunkteText = new JLabel("Punkte");

        punkteVerliererPanel.add(verliererPunkteText);
        punkteVerliererPanel.add(verliererPunkte);


        JPanel rundenVerliererPanel = new JPanel(new GridLayout(1,2));
        rundenVerliererPanel.setBackground(Color.cyan);
        rundenVerliererPanel.setBorder(BorderFactory.createLineBorder(Color.black,5));

        JLabel verliererRunden = new JLabel("0");
        JLabel verliererRundenText = new JLabel("Runden");

        rundenVerliererPanel.add(verliererRundenText);
        rundenVerliererPanel.add(verliererRunden);


        verliererPanel.add(verliererNamePanel);
        verliererPanel.add(punkteVerliererPanel);
        verliererPanel.add(rundenVerliererPanel);

        auswertungsTabelle.add(gewinnerPanel);
        auswertungsTabelle.add(verliererPanel);

        auswertungsTabelle.setBorder(new EmptyBorder(0,200,0,200));


        //Buttons

        JPanel buttons = new JPanel(new GridLayout(1,4));
        JButton beenden = new JButton("Beenden");
        beenden.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().dispose();
            }
        });

        JButton haupmenu = new JButton("Hauptmenü");
        haupmenu.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        haupmenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartView();
                getFrame().dispose();
            }
        });

        JButton speichern = new JButton("Speichern");
        speichern.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        speichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Speichern");
            }
        });

        JButton nochmalsSpielen = new JButton("Nochmals spielen");
        nochmalsSpielen.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        nochmalsSpielen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlaygroundGui(playground);
                getFrame().dispose();
            }
        });

        buttons.add(beenden);
        buttons.add(haupmenu);
        buttons.add(speichern);
        buttons.add(nochmalsSpielen);

        panel.add(titelPanel);
        panel.add(auswertungsTabelle);
        panel.add(buttons);



        this.add(panel,BorderLayout.CENTER);
        this.getContentPane().setBackground(new Color(113,139,245));
        this.setVisible(true);
    }

    public JFrame getFrame(){
        return this;
    }
}
