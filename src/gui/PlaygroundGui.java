package gui;

import data.Player;
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
    private PlayerComponent player1;
    private PlayerComponent player2;

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

        if (playground.getLogic().getPlayer(0) != null && playground.getLogic().getPlayer(0).getName().equals("spieler1")) {
            player1 = new PlayerComponent();
            player1.setText("Spieler 1: " + playground.getLogic().getPlayer(0).getScore());
        } else {
            Player player = playground.getLogic().getPlayer(0);
            player1 = new PlayerComponent();
            player1.setText(player.getName() + ": " + player.getScore());
        }

        Player player;
        if (playground.getLogic().getPlayer(1) != null && playground.getLogic().getPlayer(1).getName().equals("spieler2")) {
            player = playground.getLogic().getPlayer(1);
            player2 = new PlayerComponent();
            player2.setText("Spieler 2: " + String.valueOf(player.getScore()));
        } else {
            player = playground.getLogic().getPlayer(1);
            player2 = new PlayerComponent();
            player2.setText(player.getName() + ": " + String.valueOf(player.getScore()));
        }

        mittelPanel.add(player1);
        mittelPanel.add(player2);


        spielAngaben.add(runde, BorderLayout.WEST);
        spielAngaben.add(mittelPanel, BorderLayout.CENTER);


        spielfeld = new JPanel();
        spielfeld.setLayout(new GridLayout(playground.getRows(), playground.getColumns(), 10, 10));
        spielfeld = fillCards(playground, spielfeld);

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
                            Character.getNumericValue(entry.getValue().charAt(1)))) {
                        new AuswertungsGui(playground);
                        getFrame().dispose();
                    }
                    break;
                }
            }
            String player1Name = playground.getLogic().getPlayer(0).getName();
            String player2Name = playground.getLogic().getPlayer(1).getName();

            String player1Score = String.valueOf(playground.getLogic().getPlayer(0).getScore());
            String player2Score = String.valueOf(playground.getLogic().getPlayer(1).getScore());
            player1.setText(player1Name+": "+player1Score);
            player2.setText(player2Name+": "+player2Score);
        }
    }

    public JFrame getFrame() {
        return this;
    }
}
