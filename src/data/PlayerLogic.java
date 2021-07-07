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

    public Player getPlayer(String playername){
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(playername)){
                return players.get(i);
            }
        }
        return null;
    }

    public Player getPlayer(int index){
        return players.get(index);
    }


    @Override
    public void fireScoreChanged(Player player, int score) {
        int playerScore = players.get(players.indexOf(player)).getScore();
        players.get(players.indexOf(player)).setScore(playerScore + score);
    }

    @Override
    public void fireNameChanged(Player player, String name) {
        players.get(players.indexOf(player)).setName(name);
    }

    @Override
    public void fireNewPlayer() {

    }
}
