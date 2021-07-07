package gui;

public interface PlaygroundListener {

    public void fireCardChange(int x, int y);

    public void firePairFound(int x1, int y1, int x2, int y2);
}
