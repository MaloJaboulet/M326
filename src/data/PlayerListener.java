package data;

public interface PlayerListener {

    public void fireScoreChanged(Player player, int score);

    public void fireNameChanged(Player player, String name);

    public void fireNewPlayer();

}
