import java.util.ArrayList;
import java.util.List;

public class Text {

    private String text;
    private char[] characters;
    private char[] charactersPresent;
    private List<MCharacter> numberOfRepetition;

    public Text(String text){
        this.text = text;
        this.characters = text.toCharArray();
        takeCharactersPresent();
        calculateNumberOfRepetitions();
        Tools.sort(numberOfRepetition);
    }

    public void takeCharactersPresent(){
        ArrayList<Character> chp = new ArrayList<>();
        for (char ch : characters) if ((Tools.isUpperCase(ch) || Tools.isLowerCase(ch)) &&  !chp.contains(Tools.toLowerCase(ch))) chp.add(Tools.toLowerCase(ch));
        charactersPresent = new char[chp.size()];
        for (int index = 0; index < charactersPresent.length; index++) charactersPresent[index] = chp.get(index);
    }

    public void calculateNumberOfRepetitions(){
        numberOfRepetition = new ArrayList<>();
        int count;
        for (char chp : charactersPresent){
            count = 0;
            for (char ch : characters) if (chp == Tools.toLowerCase(ch)) ++ count;
            numberOfRepetition.add(new MCharacter(chp, count));
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char[] getCharacters() {
        return characters;
    }

    public void setCharacters(char[] characters) {
        this.characters = characters;
    }

    public char[] getCharactersPresent() {
        return charactersPresent;
    }

    public void setCharactersPresent(char[] charactersPresent) {
        this.charactersPresent = charactersPresent;
    }

    public List<MCharacter> getNumberOfRepetition() {
        return numberOfRepetition;
    }

    public void setNumberOfRepetition(List<MCharacter> numberOfRepetition) {
        this.numberOfRepetition = numberOfRepetition;
    }

}
