package gui;

import data.Playground;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PlaygroundGui extends JFrame implements PlaygroundListener {

    private Playground playground;
    private PlaygroundController playgroundController;
    private HashMap<JButton, String> referenzen;
    private JButton[][] buttons;
    private JPanel spielfeld;

    public PlaygroundGui(Playground _playground) {
        this.playground = _playground;
        referenzen = new HashMap<>();
        buttons = new JButton[playground.getRows()][playground.getColumns()];
        playgroundController = new PlaygroundController(playground);
        setListener();
        gui();
    }


    public void gui() {
        this.setTitle("Spielfeld");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel spielAngaben = new JPanel();
        JLabel runde = new JLabel("Runde: ");

        JPanel mittelPanel = new JPanel();
        JLabel spieler1 = new JLabel();
        /*if (model.getSpieler(0) != null && model.getSpieler(0).getSpielerName().equals("spieler1")) {
            Spieler spieler = model.getSpielerMitNummer(1);
            spieler1 = new JLabel("Spieler 1: "+String.valueOf(spieler.getPoints()));
        }else {
            Spieler spieler = model.getSpieler(0);
            spieler1 = new JLabel(spieler.getSpielerName()+": "+String.valueOf(spieler.getPoints()));
        }

        JLabel spieler2 = new JLabel();
        if (model.getSpieler(1) != null && model.getSpieler(1).getSpielerName().equals("spieler2")) {
            Spieler spieler = model.getSpielerMitNummer(2);
            spieler2 = new JLabel("Spieler 2: "+String.valueOf(spieler.getPoints()));
        }else {
            Spieler spieler = model.getSpieler(1);
            spieler2 = new JLabel(spieler.getSpielerName()+": "+String.valueOf(spieler.getPoints()));
        }

        mittelPanel.add(spieler1);
        mittelPanel.add(spieler2);

         */

        spielAngaben.add(runde, BorderLayout.WEST);
        spielAngaben.add(mittelPanel, BorderLayout.CENTER);


        spielfeld = new JPanel();

        spielfeld.setLayout(new GridLayout(playground.getRows(), playground.getColumns(), 10, 10));
        spielfeld = fillCards(playground, spielfeld);
        //spielfeld.setKarten(model.getRows(), model.getColumns(), model.getSpielfeld());


        JLabel titel = new JLabel("Memory Game");

        this.add(titel);
        this.add(spielAngaben, BorderLayout.NORTH);
        this.add(spielfeld);

        this.setVisible(true);
    }


    public void setListener() {
        playground.setPlaygroundListener(this);
    }

    @Override
    public void fireCardChange(int x, int y) {
        JButton button = buttons[x][y];
        Image image = playground.getCard(x, y).getAnzeige();

        button.setIcon(new ImageIcon(image));

    }

    @Override
    public void firePairFound(int x1, int y1, int x2, int y2) {
        JButton button = buttons[x1][y1];
        button.setEnabled(false);

        JButton button2 = buttons[x2][y2];
        button2.setEnabled(false);

    }


    public JPanel fillCards(Playground playground, JPanel panel) {
        for (int i = 0; i < playground.getRows(); i++) {
            for (int j = 0; j < playground.getColumns(); j++) {
                JButton button = new JButton();
                button.addActionListener(new ButtonListener());
                button.setIcon(new ImageIcon(playground.getCard(i, j).getAnzeige()));
                referenzen.put(button, i + "" + j);
                buttons[i][j] = button;

                if (playground.getCard(i, j).getBackground() == new ImageIcon(this.getClass().getResource("../Img/foreground.jpg")).getImage()) {
                    button.setEnabled(false);
                }
                panel.add(button);
            }
        }
        return panel;
    }


    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            for (Map.Entry<JButton, String> entry : referenzen.entrySet()) {
                if (entry.getKey() == button) {
                    if (playgroundController.flipCard(Character.getNumericValue(entry.getValue().charAt(0)),
                            Character.getNumericValue(entry.getValue().charAt(1)))){
                        new AuswertungsGui();
                        getFrame().dispose();
                    }
                    break;
                }
            }
        }
    }

    public JFrame getFrame(){
        return this;
    }
}
