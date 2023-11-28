package tramp;

public class TrumpCard extends Card{

    private int number;
    private SHARP sharp;

    public int getNumber() {
        return number;
    }

    public SHARP getSharp() {
        return sharp;
    }

    public TrumpCard(int number, SHARP sharp, int width, int height) {
        super(width, height);
        this.number = number;
        this.sharp = sharp;
    }
}
