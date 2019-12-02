package tateti;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Auxiliar {
    
    private static Scanner entrada = new Scanner(System.in);
            
    
    static public int numRandomEntre(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min-1, max)+1;
    }
    
    static char readChar(String message){                    
        Scanner entrada = new Scanner(System.in);
        char character;
        System.out.print(message);
        character = entrada.nextLine().toLowerCase().charAt(0);
        while (character != 'a' && character != 'b' && character != 'c'){
            System.out.print("ERROR." + message);
            character = entrada.nextLine().toLowerCase().charAt(0);
        }
        return character;
    }
    static int readPositiveWholeBetween(String message,int since, int until){    
        Scanner entrada = new Scanner(System.in);
        int whole;    
        System.out.print(message);
        whole = entrada.nextInt();
        while (whole < since && whole > until){
            System.out.print("ERROR." + message);
            whole = entrada.nextInt();    
        }
        return whole;
    }
    public static String readString(String text){
    System.out.print(text);
    String txt = entrada.nextLine();
    return txt;
    }
}
