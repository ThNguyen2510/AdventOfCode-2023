import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/input"));


        int points = 0;
        int match;
        boolean status = true;
        List<Integer> winners = new ArrayList<>();
        List<Integer> card = new ArrayList<>();
        List<Integer> matches = new ArrayList<>();
        scratchcard [] cardlist = new scratchcard[201];
        int j = 0;

        while(input.hasNextLine())
        {
            String zeile = input.nextLine();
            String [] angabe = zeile.split("\\s+");

            for(int i = 0; i < angabe.length; i++)
            {
                if(angabe[i].equals("|"))
                {
                    status = false;
                }
                if(status && i > 1)
                {
                    winners.add(Integer.parseInt(angabe[i]));
                }
                if(!status && !angabe[i].endsWith("|"))
                {
                    card.add(Integer.parseInt(angabe[i]));
                }
            }

            matches.addAll(card);
            matches.retainAll(winners);
            match = matches.size();
            //part2
            cardlist[j] = new scratchcard(match);
            j++;

            points = points + (int) Math.pow(2,(match - 1));
            status = true;
            card.clear();
            winners.clear();
            matches.clear();
        }

        int zwischenCount;
        for(int i = cardlist.length - 1; i > -1; i--)
        {
            if(cardlist[i].wins == 0)
            {
                cardlist[i].setGesamtcards(1);
            }
            else
            {
                zwischenCount = 0;
                for (int k = 0; k <= cardlist[i].wins; k++)
                {
                    zwischenCount = zwischenCount + cardlist[i+k].gesamtcards;
                }
                cardlist[i].setGesamtcards(zwischenCount+1);
            }
        }

        int totalcard = 0;
        for(int i = 0; i < cardlist.length; i++)
        {
            totalcard = cardlist[i].gesamtcards + totalcard;
        }
        System.out.println(totalcard);


    }
}