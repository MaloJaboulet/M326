package data;

import java.util.Vector;

public class PlayerLogic implements PlayerListener{


    private Vector<Player> players;

    public PlayerLogic(){
        players = new Vector<>();

    }

    public void addNewPlayer(String name, boolean yourTurn){
        players.add(new Player(name,0,yourTurn));
        fireNewPlayer();
    }


    @Override
    public void fireScoreChanged() {

    }

    @Override
    public void fireNameChanged() {

    }

    @Override
    public void fireNewPlayer() {

    }
}
