package gui;

import data.Playground;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Malo Jaboulet
 * @since 07.07.2021
 * @version 1.0
 */
public class StartView extends JFrame {

    private JButton spielen;
    private JButton spielkonfigurieren;

    public StartView() {
        this.setTitle("Memorygame");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());


        JLabel titel = new JLabel("Memorygame", SwingConstants.CENTER);
        titel.setFont(titel.getFont().deriveFont(32.0f));
        topPanel.add(titel, BorderLayout.CENTER);

        JPanel mittelPanel = new JPanel(new GridLayout(1, 2, 15, 15));
        mittelPanel.setMaximumSize(new Dimension(500, 300));

        spielkonfigurieren = new JButton("Spielkonfigurieren");
        spielkonfigurieren.setPreferredSize(new Dimension(50, 50));
        spielkonfigurieren.addActionListener(new ButtonController());

        spielen = new JButton("Spielen");
        spielen.addActionListener(new ButtonController());

        mittelPanel.add(spielkonfigurieren);
        mittelPanel.add(spielen);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(mittelPanel, BorderLayout.SOUTH);


        this.setVisible(true);
    }

    public JFrame getFrame() {
        return this;
    }

    class ButtonController implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == spielkonfigurieren) {
                new KonfigurationsView();
            } else {
                Playground playground = new Playground(10,10);
                playground.getLogic().addNewPlayer("Spieler 1", true);
                playground.getLogic().addNewPlayer("Spieler 2",false);
                new PlaygroundGui(playground);
            }
            getFrame().dispose();
        }
    }
}
