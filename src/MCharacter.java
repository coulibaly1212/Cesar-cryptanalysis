public class MCharacter {

    private char character;
    private double frequency;

    public MCharacter(char character, double frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "" + character + "=" + (int)frequency;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
