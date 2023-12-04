import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/input1"));

        int sum = 0;
        int blueMax = 14;
        int redMax = 12;
        int greenMax = 13;
        int blueCount = 0;
        int redCount = 0;
        int greenCount = 0;
        int gameID = 0;
        boolean possible;
        int redMin = 0;
        int oldredMin = 1000;
        int blueMin = 0;
        int oldblueMin = 1000;
        int greenMin = 0;
        int oldgreenMin = 0;

        while(input.hasNextLine())
        {

            String [] angabe = input.nextLine().split("\\s+");

            angabe[1] = angabe[1].replace(":","");
            gameID = Integer.parseInt(angabe[1]);
            possible = true;

            redMin = 0;
            oldredMin = 0;
            blueMin = 0;
            oldblueMin = 0;
            greenMin = 0;
            oldgreenMin = 0;




            for(int i = 0; i < angabe.length; i++)
            {
                    if(angabe[i].contains("blue"))
                    {

                        blueMin =  Integer.parseInt(angabe[i-1]);
                        if(oldblueMin > blueMin)
                        {
                            blueMin = oldblueMin;

                        }
                        oldblueMin = blueMin;

                        blueCount = blueCount + Integer.parseInt(angabe[i-1]);
                        if(blueCount > blueMax)
                        {
                            redCount = 0;
                            blueCount = 0;
                            greenCount = 0;
                            possible = false;
                            //break;
                        }
                    }

                    if(angabe[i].contains("red"))
                    {

                        redMin =  Integer.parseInt(angabe[i-1]);
                        if(oldredMin > redMin)
                        {
                            redMin = oldredMin;

                        }
                        oldredMin = redMin;

                        redCount = redCount + Integer.parseInt(angabe[i-1]);
                        if(redCount > redMax)
                        {
                            redCount = 0;
                            blueCount = 0;
                            greenCount = 0;
                            possible = false;
                            //break;
                        }
                    }

                    if(angabe[i].contains("green"))
                    {
                        greenMin =  Integer.parseInt(angabe[i-1]);
                        if(oldgreenMin > greenMin)
                        {
                            greenMin = oldgreenMin;

                        }
                        oldgreenMin = greenMin;

                        greenCount = greenCount + Integer.parseInt(angabe[i-1]);
                        if(greenCount > greenMax)
                        {
                            redCount = 0;
                            blueCount = 0;
                            greenCount = 0;
                            possible = false;
                            //break;
                        }
                    }

                    if(angabe[i].contains(";"))
                    {
                        redCount = 0;
                        blueCount = 0;
                        greenCount = 0;
                    }
            }
            sum = sum +(redMin*blueMin*greenMin);

            redCount = 0;
            blueCount = 0;
            greenCount = 0;
            if(possible)
            {
                //sum = sum + gameID;
            }
        }
        System.out.println("Summe ist: "+ sum);
    }

}
