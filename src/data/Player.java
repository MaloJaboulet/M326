package data;

public class Player implements PlayerModel{

    private String name;
    private int score;
    private boolean yourTurn;


    public Player(String name, int score, boolean yourTurn){
        setName(name);
        setScore(score);
        setYourTurn(yourTurn);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean getYourTurn() {
        return yourTurn;
    }

    @Override
    public void changeTurn() {
        if (getYourTurn()){
            setYourTurn(false);
        }else {
            setYourTurn(true);
        }
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }
}
