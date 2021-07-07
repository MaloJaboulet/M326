package gui;

import data.Playground;

public class PlaygroundController {

    private Playground playground;
    private int rowCardTemp;
    private int colCardTemp;
    private boolean alreadyCardTurned;

    public PlaygroundController(Playground playground) {
        alreadyCardTurned = false;
        this.playground = playground;
    }


    public void flipCard(int row, int col) {
        playground.setSelected(row, col, true);
        if (!alreadyCardTurned) {
            rowCardTemp = row;
            colCardTemp = col;
            alreadyCardTurned = true;
        } else {
            playground.compareCards(row,col,rowCardTemp,colCardTemp);
            alreadyCardTurned = false;
            rowCardTemp = -1;
            colCardTemp = -1;
        }

    }
}
