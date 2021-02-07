import java.io.*;
import java.util.*;

public class Tools {

    static {
        uploadTable();
    }

    public static List<MCharacter> frequency;

    public static boolean createFile (String name){
        try {
            File file = new File("Assets/Dictionnaire/" + name + ".txt");
            if (file.createNewFile()) return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    /** Charge les lettres et leur frequence
     * @return
     */
    public static boolean uploadTable(){
        ArrayList<String> uploadFrequencyFile = uploadFrequencyFile();
        if (uploadFrequencyFile.isEmpty() || uploadFrequencyFile == null) return false;
        frequency = new ArrayList<>();
        for (String string : uploadFrequencyFile) addValue(string);
        sort(frequency);
        return true;
    }

    public static void addValue(String string){
        String[] values = string.split(" ");
        frequency.add(new MCharacter(values[0].toCharArray()[0], Double.parseDouble(values[1])));
    }

    /** Charge le fichier frequency qui contient les lettres et leurs frequences
     *
     * @return
     */
    public static ArrayList<String> uploadFrequencyFile(){
        try{
            InputStream flux = new FileInputStream("Assets/Frequency.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String next;
            ArrayList<String> frequency = new ArrayList<>();
            while ((next = buff.readLine())!=null) frequency.add(next);
            buff.close();
            return frequency;
        } catch (Exception e){ e.printStackTrace(); return null;}
    }

    public static void sort(List<MCharacter> list){
        Collections.sort(list, Comparator.comparing(MCharacter::getFrequency));
    }

    public static boolean isLowerCase(char character){
        return character <= 122 && character >= 97;
    }

    public static boolean isUpperCase(char character){
        return character <= 90 && character >= 65;
    }

    public static char getLowerCase(char character){
        return (char)((int)character +32);
    }

    public static char toLowerCase(char character){
        if (isUpperCase(character)) return (char) (character +32);
        return character;
    }

}
