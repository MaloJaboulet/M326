package gui;

import data.Player;
import data.Playground;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * @since 07.07.2021
 * <p>
 * Das ist das GUI des Spielfelds. Hier werden alle Karten in Tabellenform angezeigt.
 * Hier werden auch alle Eingaben des Benutzers entgegengenommen.
 */
public class PlaygroundGui extends JFrame implements PlaygroundListener {

    private Playground playground;
    private PlaygroundController playgroundController;
    private HashMap<JButton, String> referenzen;
    private JButton[][] buttons;
    private JPanel spielfeld;
    private JLabel player1;
    private JLabel player2;

    /**
     * Der Konstruktor der Klasse. Hier werden alle Variablen gesetzt.
     *
     * @param _playground die Datensammlung mit all den Karten
     */
    public PlaygroundGui(Playground _playground) {
        this.playground = _playground;
        referenzen = new HashMap<>();
        buttons = new JButton[playground.getRows()][playground.getColumns()];
        playgroundController = new PlaygroundController(playground);
        setListener();
        gui();
    }

    /**
     * Hier wird das GUI erstellt und angezeigt.
     */
    public void gui() {
        this.setTitle("Spielfeld");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.red);

        //Top-Panel mit all den Spielangaben
        JPanel spielAngaben = new JPanel(new GridLayout(1, 3, 200, 0));
        spielAngaben.setBackground(new Color(52, 155, 235));
        JLabel runde = new JLabel("Runde: " + playground.getRoundsPlayed());

        JPanel mittelPanel = new JPanel();
        mittelPanel.setOpaque(false);

        //Spielernamen
        Player player = playground.getLogic().getPlayer(0);
        player1 = new JLabel();
        player1.setText(player.getName() + ": " + player.getScore());

        player = playground.getLogic().getPlayer(1);
        player2 = new JLabel();
        player2.setText(player.getName() + ": " + String.valueOf(player.getScore()));

        mittelPanel.add(player1);
        mittelPanel.add(player2);

        //Timer
        //JLabel timer = new JLabel("Timer");
        JLabel timer = new JLabel("");
        timer.setHorizontalAlignment(SwingConstants.RIGHT);


        spielAngaben.add(runde);
        spielAngaben.add(mittelPanel);
        spielAngaben.add(timer);

        //Das Panel mit dem Buttons/Karten
        spielfeld = new JPanel();
        spielfeld.setBackground(new Color(113, 139, 245));
        spielfeld.setLayout(new GridLayout(playground.getRows(), playground.getColumns(), 10, 10));
        spielfeld = fillCards(playground, spielfeld); //füllt das Spielfeld


        //Buttons
        JPanel buttons = new JPanel(new GridLayout(1, 4));
        buttons.setPreferredSize(new Dimension(1920, 50));
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
           /* @Override
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

        this.add(spielAngaben, BorderLayout.NORTH);
        this.add(spielfeld);
        this.add(buttons, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    /**
     * Wenn eine Karte ausgewählt wurde, wird diese gedreht.
     *
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    @Override
    public void fireCardChange(int x, int y) {
        JButton button = buttons[x][y];
        Image image = playground.getCard(x, y).getAnzeige();

        button.setIcon(new ImageIcon(image));
    }

    /**
     * Wenn ein Paar gefunden wird, werden beide Karten deaktiviert.
     *
     * @param x1 x-Koordinate der ersten Karte
     * @param y1 y-Koordinate der ersten Karte
     * @param x2 x-Koordinate der zweiten Karte
     * @param y2 y-Koordinate der zweiten Karte
     */
    @Override
    public void firePairFound(int x1, int y1, int x2, int y2) {
        JButton button = buttons[x1][y1];
        button.setEnabled(false);

        JButton button2 = buttons[x2][y2];
        button2.setEnabled(false);

    }

    /**
     * Füllt das Spielfeld mit all den Karten.
     * Die Karten werden in Buttons getan und die Button werden dann in ein JPanel mit GridLayout gefüllt.
     *
     * @param playground die Datensammlung mit den Karten
     * @param panel      das JPanel
     * @return das JPanel
     */
    public JPanel fillCards(Playground playground, JPanel panel) {
        for (int i = 0; i < playground.getRows(); i++) {
            for (int j = 0; j < playground.getColumns(); j++) {
                JButton button = new JButton();
                button.addActionListener(new ButtonListener());
                button.setIcon(new ImageIcon(playground.getCard(i, j).getAnzeige())); //Setzt das Bild
                referenzen.put(button, i + "" + j); //Referenz mit den Koordinaten
                buttons[i][j] = button;

                //Wenn die Kartenanzahl ungrade ist, wird eine Karte von Anfang an deaktiviert
                if (playground.getCard(i, j).getBackground() ==
                        new ImageIcon(this.getClass().getResource("../Img/foreground.jpg")).getImage()) {
                    button.setEnabled(false);
                }
                panel.add(button);
            }
        }
        return panel;
    }

    /**
     * Setzt den Listener des Spielfelds.
     */
    public void setListener() {
        playground.setPlaygroundListener(this);
    }

    /**
     * Der Actionlistener des Buttons. Wenn ein Button gedrück wird, wird die dazugehörige Karte gedreht.
     */
    class ButtonListener implements ActionListener {
        /**
         * Wenn der Button gedrückt wird, dreht sich die Karte.
         *
         * @param e das Event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            // Sucht den gedrückten Button
            for (Map.Entry<JButton, String> entry : referenzen.entrySet()) {
                if (entry.getKey() == button) {
                    int x = Character.getNumericValue(entry.getValue().charAt(0));
                    int y = Character.getNumericValue(entry.getValue().charAt(1));
                    //Wenn alle Karten aufgedeckt wurden, wird die Auswertung angezeigt
                    if (playgroundController.flipCard(x, y)) {
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
            player1.setText(player1Name + ": " + player1Score);
            player2.setText(player2Name + ": " + player2Score);
        }
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
