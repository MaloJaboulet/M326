package gui;

import data.Playground;

public class PlaygroundController {

    private Playground playground;
    private int rowCardTemp1;
    private int rowCardTemp2;
    private int colCardTemp1;
    private int colCardTemp2;
    private int alreadyCardTurned;
    private int leftPair;

    public PlaygroundController(Playground playground) {
        alreadyCardTurned = 0;
        this.playground = playground;
        int temp = playground.getImages().size();
        if (temp%2 == 0) {
            leftPair = temp/2;
        }else {
            leftPair = (temp-1)/2;
        }
    }


    public boolean flipCard(int row, int col) {
        System.out.println(leftPair);
        if (!playground.getCard(row,col).isTurned()) {
            if (leftPair == 1){
                leftPair = leftPair - playground.compareCards(rowCardTemp1, colCardTemp1, row, col);
                return true;
            }
            if (alreadyCardTurned == 0) {
                rowCardTemp1 = row;
                colCardTemp1 = col;
                playground.setSelected(row, col, true);
                alreadyCardTurned++;
                return false;
            } else if (alreadyCardTurned == 1) {
                rowCardTemp2 = row;
                colCardTemp2 = col;
                playground.setSelected(row, col, true);
                alreadyCardTurned++;
                return false;
            } else {
                leftPair = leftPair - playground.compareCards(rowCardTemp1, colCardTemp1, rowCardTemp2, colCardTemp2);
                alreadyCardTurned = 1;
                playground.setSelected(row, col, true);
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
