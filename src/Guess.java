public class Guess {

    private char to;
    private char from;
    private String plainText;
    private int probability;
    private int guessNumber;
    private static int staticGN = 1;

    public Guess(char to, char from, String plainText, int probability) {
        this.to = to;
        this.from = from;
        this.plainText = plainText;
        this.probability = probability;
        this.guessNumber = staticGN++;
    }

    @Override
    public String toString() {
        String details = "Essaie n° " + guessNumber + "\n";
        details += to + " -> " + from + "\n";
        details += "Sure a " + probability + "%\n";
        details += "Texte en claire:\n" + plainText + "\n";
        return details;
    }

    public char getTo() {
        return to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    public char getFrom() {
        return from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }
}
