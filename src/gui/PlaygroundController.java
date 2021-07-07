package gui;

import data.Playground;

/**
 * @author Malo Jaboulet
 * @version 1.0
 * @since 07.07.2021
 * <p>
 * Diese Klasse ist für die Spiellogik verantwortlich. Sie arbeitet mit den Karten.
 */
public class PlaygroundController {

    private Playground playground;
    private int rowCardTemp1;
    private int rowCardTemp2;
    private int colCardTemp1;
    private int colCardTemp2;
    private int alreadyCardTurned;
    private int leftPair;

    /**
     * Der Konstruktor der Klasse.
     *
     * @param playground die Datensammlung mit den Karten
     */
    public PlaygroundController(Playground playground) {
        alreadyCardTurned = 0;
        this.playground = playground;
        int temp = playground.getImages().size();
        if (temp % 2 == 0) {    //Wenn die Anzahl Paare gerade ist
            leftPair = temp / 2;
        } else {
            leftPair = (temp - 1) / 2;
        }
    }

    /**
     * Eine ausgewählte Karte wird gedreht.
     * Beim ersten Durchgang wird die Karte aufgedeckt und die Koordinaten zwischen gespeichert.
     * Beim zweiten Durchgange wird die Karte auch aufgedeckt und die Koordinaten zwischen gespeichert.
     * Beim dritten Durchgange wernden die zwei ersten Karten verglichen, wenn sie gleich sind werden sie aus
     * dem Spiel genomme. Wenn nicht werden sie umgedreht. Nach dem wird die dritte Karte umgedreht.
     *
     * @param row x-Koordinate der Karte
     * @param col y-Koordinate der Karte
     * @return ob alle Karten aufgedeckt wurden
     */
    public boolean flipCard(int row, int col) {
        if (!playground.getCard(row, col).isTurned()) { //Schaut, ob die ausgewählte Karte schon gezeigt wird
            if (leftPair == 1) {
                leftPair = leftPair - playground.compareCards(rowCardTemp1, colCardTemp1, row, col);
                return true;
            }
            if (alreadyCardTurned == 0) {
                rowCardTemp1 = row;
                colCardTemp1 = col;
                playground.setSelected(row, col, true); //dreht die Karte
                alreadyCardTurned++;
                return false;
            } else if (alreadyCardTurned == 1) {
                rowCardTemp2 = row;
                colCardTemp2 = col;
                playground.setSelected(row, col, true);  //dreht die Karte
                alreadyCardTurned++;
                return false;
            } else {
                //Vergleicht die Karten, wenn sie gleich sind wird die Anzahl übrigen Paare um 1 verkleinert.
                leftPair = leftPair - playground.compareCards(rowCardTemp1, colCardTemp1, rowCardTemp2, colCardTemp2);
                alreadyCardTurned = 1;
                playground.setSelected(row, col, true);  //dreht die Karte
                rowCardTemp1 = row;
                colCardTemp1 = col;
                rowCardTemp2 = -1;
                colCardTemp2 = -1;
                return false;
            }
        }
        return false;
    }
}
