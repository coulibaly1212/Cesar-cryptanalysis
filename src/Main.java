import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Cypher Text:");
        String cypherText = new Scanner(System.in).nextLine();
        System.out.println("Nombre d'essaie");
        int tries = new Scanner(System.in).nextInt();
        System.out.println("Persiste sur une lettre frequente en francais pour combien de fois:");
        int persist = new Scanner(System.in).nextInt();

        System.out.println();
        Cesar cesar = new Cesar(cypherText);
        System.out.println(cesar.getText().getNumberOfRepetition() + "\n");
        cesar.guess(tries, persist);

        for (int index = cesar.getProposition().size() -1; index >= 0; index--) System.out.println(cesar.getProposition().get(index));


    }

}
