import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/input1"));

        String zeile;
        String first = "";
        String last = "";
        int zahl;
        int sum = 0;


        while(input.hasNextLine())
        {
            //part 2
            zeile = input.nextLine().replace("one","o1e");
            zeile = zeile.replace("two","t2o");
            zeile = zeile.replace("three","t3e");
            zeile = zeile.replace("four","f4r");
            zeile = zeile.replace("five","f5e");
            zeile = zeile.replace("six","s6x");
            zeile = zeile.replace("seven","s7n");
            zeile = zeile.replace("eight","e8t");
            zeile = zeile.replace("nine","n9e");
            zeile = zeile.replace("zero","z0o");

            String [] angabe = zeile.split("(?!^)");
            
            for (int i = 0; i < angabe.length; i++) {
                if (angabe[i].matches(".*\\d.*")) {
                    first = angabe[i];
                    break;
                }
            }
            for (int j = 0; j < angabe.length; j++) {
                if (angabe[angabe.length -1 - j].matches(".*\\d.*")) {
                    last = angabe[angabe.length -1 - j];
                    break;
                }
            }
            zahl = Integer.parseInt(first + last) ;
            sum = sum + zahl;
        }
        System.out.println(sum);




    }
}