import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/input"));

        String zeile = input.nextLine();
        zeile = zeile.replace("Time: ", "");
        //String [] zeit = zeile.stripLeading().split("\\s+");

        //part2
        String [] zeit = zeile.stripLeading().replaceAll("\\s", "").split("\\s+");

        String zeile2 = input.nextLine();
        zeile2 = zeile2.replace("Distance: ", "");
        //String [] distanz = zeile2.stripLeading().split("\\s+");

        //part2
        String [] distanz = zeile2.stripLeading().replaceAll("\\s", "").split("\\s+");



        long product = 1;

        for(int i = 0; i < distanz.length; i++)
        {
            product = product * race(i,zeit,distanz);
        }
        System.out.println("Das Produkt ist: "+ product);
    }

    public static long race(int pos, String[] zeit, String[] distanz) {
        long count = 0;
        long time = Long.parseLong(zeit[pos]);
        long distance = Long.parseLong(distanz[pos]);

        for(int i = 0; i < time; i++)
        {
            if(i * (time - i) > distance)
            {
                count++;
            }

        }
        return count;
    }


}