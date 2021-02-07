import java.io.*;

public class Dictionary {

    //
    public static int acknowledgeSentence(String sentence){
        int reconnue = 0;
        String[] mots = sentence.split(" ");
        for (String mot : mots) if (acknowledgeWord(mot)) reconnue++;
        return 100*reconnue/sentence.length();
    }

    public static boolean acknowledgeWord(String word){
        String prefixe;
        if (word.length() >= 3) prefixe = word.substring(0,3);
        else if (word.length() == 2) prefixe = word.substring(0,2);
        else return true;

        File file = new File("Assets/Dictionary/" + prefixe + ".txt");
        if (!file.exists()) return false;

        try{
            InputStream flux = new FileInputStream("Assets/Dictionary/" + file.getName());
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String line;
            while ((line = buff.readLine())!=null) if (isFamiliar(word, line)) return true;
            buff.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isFamiliar(String mot1, String mot2){
        if (mot1.length() >= mot2.length() && mot1.length() - mot2.length() > 3) return false;
        else if (mot2.length() - mot1.length() > 3) return false;
        return mot1.equalsIgnoreCase(mot2);
    }

}
