
import java.util.*;

public class Cesar {

    private Text text;
    private List<Guess> proposition;

    public Cesar(){

    }

    public Cesar(String message){
        this.text = new Text(message);
    }


    /** Devine le plain text en essayant les combinaisons trouver par analyse de frequence, jusqua atteindre le nombre d'essaie
     *
     * @param numberOfTry
     * @param persist
     */

    public void guess(int numberOfTry, int persist){
        proposition = new ArrayList<>();
        char[][] selection = select(numberOfTry, persist);
        int permutation = 0;
        String newGuess;
        while (numberOfTry-- > 0){
            newGuess = applySelection(selection[permutation][0], selection[permutation][1]);
            proposition.add(new Guess(selection[permutation][0], selection[permutation][1], newGuess, Dictionary.acknowledgeSentence(newGuess)));
            permutation++;
        }
        Collections.sort(proposition, Comparator.comparing(Guess::getProbability));
    }

    /** Applique le changement des combinaisons obtenue par la selection des lettres frequetes
     *
     * @param to
     * @param from
     * @return
     */
    public String applySelection(char to, char from){
        int deplacement = getMove(to,from);
        char[] newText = new char[text.getCharacters().length];
        int index = newText.length;
        while(index > 0){
            newText[index -1] = decrement(text.getCharacters()[index -1], deplacement);
            index--;
        }
        return String.copyValueOf(newText);
    }

    /** Pour crypter, je l'ai implementer pour chiffre et cryptanalyser pour tester le programme
     *
     * @param message
     * @param decalage
     * @return
     */
    public String encrypt(char[] message, int decalage){
        decalage = (decalage + 26)%26;
        String cypherText = "";
        for (char ch : message){
            if (Tools.isLowerCase(ch)){
                if (ch + decalage > 122) ch = (char) (ch + decalage - 26);
                else if ((ch + decalage < 97)) ch = (char) (ch + decalage + 26);
                else ch = (char) (ch + decalage);
            }else if (Tools.isUpperCase(ch)){
                if (ch + decalage > 90) ch = (char) (ch + decalage - 26);
                else if ((ch + decalage < 65)) ch = (char) (ch + decalage + 26);
                else ch = (char) (ch + decalage);
            }
            cypherText += ch;
        }
        return cypherText;
    }


    /** Change une lettre en un autre
     *
     * @param character
     * @param deplacement
     * @return
     */
    public char decrement(char character, int deplacement){
        if (Tools.isLowerCase(character)){
            if (character - deplacement < 97) character = (char) (character - deplacement + 26);
            else if (character - deplacement > 122) character = (char) (character - deplacement - 26);
            else character = (char) (character - deplacement);
        }else if (Tools.isUpperCase(character)){
            if (character - deplacement < 65) character = (char) (character - deplacement + 26);
            else if (character - deplacement > 90) character = (char) (character - deplacement - 26);
            else character = (char) (character - deplacement);
        }
        return character;
    }


    /** Determine le nombre de deplacement entre les lettres combinees
     *
     * @param to
     * @param from
     * @return
     */
    public int getMove(char to, char from){
        return (to - from + 26)%26;
    }


    /** Selectionne les lettres frequentes dans le message chiffre, et les combinees avec les lettres frequentes dans le francais
     *
     * @param tries
     * @param persist
     * @return
     */
    public char[][] select(int tries, int persist){
        int possibilty = text.getNumberOfRepetition().size()*5;
        if (tries > possibilty) tries = possibilty;
            char[][] selection = new char[tries][2];
            int indexRepetition = 0;
            int indexFrequncy = 0;
            int index = 0;
            while (possibilty-- > 0){
                selection[index][0] = text.getNumberOfRepetition().get(text.getNumberOfRepetition().size() - indexRepetition++ -1).getCharacter();
                selection[index++][1] = Tools.frequency.get(Tools.frequency.size() - indexFrequncy -1).getCharacter();
                if(indexRepetition >= text.getNumberOfRepetition().size()) break;
                if(--tries == 0) break;
                if (index % persist == 0) indexFrequncy++;
            }
        return selection;
    }



    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public void setText(String text){
        this.text = new Text(text);
    }

    public List<Guess> getProposition() {
        return proposition;
    }

    public void setProposition(List<Guess> proposition) {
        this.proposition = proposition;
    }
}
