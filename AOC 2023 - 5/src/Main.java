import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/input"));
        String zeile;
        int status = 0;
        long range;
        long destination_start;
        long source_start;
        String seedAngaben = input.nextLine() + input.nextLine();
        ArrayList<String> map = new ArrayList<>();


        seedAngaben = seedAngaben.replace("seeds:", "");
        seedAngaben = seedAngaben.stripLeading();
        String[] angabe = seedAngaben.split("\\s+");
        //Part 2
        Long seednumamount = 0L;
        for(int i = 0; i < angabe.length;i++ )
        {
            if(i%2 == 1)
            {
                seednumamount += Long.parseLong(angabe[i]);
            }
        }
        seed [] samen = new seed[angabe.length];
        ArrayList<seed> samen2 = new ArrayList<>();


        for(int i = 0; i < angabe.length; i++)
        {
            samen[i] = new seed(Long.parseLong(angabe[i]));
            if(i%2 == 0)
            {
                for(int j = 0; j < Long.parseLong(angabe[i+1]); j++)
                {
                    samen2.add(new seed(Long.parseLong(angabe[i]) + j));
                }
            }
        }



        while(input.hasNextLine())
        {
            zeile = input.nextLine();

            if(zeile.equals("seed-to-soil map:"))
            {
                status = 1;
            }
            if(zeile.equals("soil-to-fertilizer map:"))
            {
                status = 2;
            }
            if(zeile.equals("fertilizer-to-water map:"))
            {
                status = 3;
            }
            if(zeile.equals("water-to-light map:"))
            {
                status = 4;
            }
            if(zeile.equals("light-to-temperature map:"))
            {
                status = 5;
            }
            if(zeile.equals("temperature-to-humidity map:"))
            {
                status = 6;
            }
            if(zeile.equals("humidity-to-location map:"))
            {
                status = 7;
            }
            else if (!zeile.isEmpty() && zeile.matches(".*\\d.*"))
            {
                String[] zeileAngabe = zeile.split("\\s+");
                range = Long.parseLong(zeileAngabe[2]);
                destination_start = Long.parseLong(zeileAngabe[0]);
                source_start = Long.parseLong(zeileAngabe[1]);

                //zuordnen(status,samen,destination_start,source_start,range);
                zuordnen2(status, samen2,destination_start,source_start,range);

            }
        }

        long lowlocation = 1000000000;
        long lowlocation_old = samen[0].location;

        for(int i = 0; i < samen.length;i++)
        {
            lowlocation = samen[i].location;
            if(lowlocation_old < lowlocation)
            {
                lowlocation = lowlocation_old;
            }
            else
            {
                lowlocation_old = lowlocation;
            }
        }

        long lowlocation2 = 1000000000;
        long lowlocation_old2 = samen2.get(0).location;

        for(int i = 0; i < samen2.size();i++)
        {
            lowlocation2 = samen2.get(i).location;
            if(lowlocation_old2 < lowlocation2)
            {
                lowlocation2 = lowlocation_old2;
            }
            else
            {
                lowlocation_old2 = lowlocation2;
            }
        }
        System.out.println("kleinste location ist :"+ lowlocation_old);
        System.out.println("kleinste location2 ist :"+ lowlocation_old2);
        System.out.println(seednumamount);
        //System.out.println(seedAngaben);

    }

    public static void zuordnen(int status, seed[] array, long destination_start, long source_start, long range)
    {
        switch(status){
            // seed-to-soil
            case 1:
                for(int i = 0; i < array.length; i++)
                {
                    if(array[i].seednum < source_start + range && array[i].seednum > source_start)
                    {
                        array[i].setSoil(destination_start + (array[i].seednum-source_start));
                    }
                    if(array[i].soil == -1)
                    {
                        array[i].setSoil(array[i].seednum);
                    }
                }
                break;

            // soil-to-fertilizer
            case 2:
                for(int i = 0; i < array.length; i++)
                {

                    if(array[i].soil < source_start + range && array[i].soil > source_start)
                    {
                        array[i].setFertilizer(destination_start + (array[i].soil-source_start));
                    }

                    if(array[i].fertilizer == -1)
                    {
                        array[i].setFertilizer(array[i].soil);
                    }
                }
                break;
            //fertilizer-to-water
            case 3:
                for(int i = 0; i < array.length; i++)
                {
                    if(array[i].fertilizer < source_start + range && array[i].fertilizer > source_start)
                    {
                        array[i].setWater(destination_start + (array[i].fertilizer-source_start));
                    }
                    if(array[i].water == -1)
                    {
                        array[i].setWater(array[i].fertilizer);
                    }
                }
                break;
            //water-to-light
            case 4:
                for(int i = 0; i < array.length; i++)
                {
                    if(array[i].water < source_start + range && array[i].water > source_start)
                    {
                        array[i].setLight(destination_start + (array[i].water - source_start));
                    }
                    if(array[i].light == -1)
                    {
                        array[i].setLight(array[i].water);
                    }
                }
                break;
            //light-to-temperature
            case 5:
                for(int i = 0; i < array.length; i++)
                {
                    if(array[i].light < source_start + range && array[i].light > source_start)
                    {
                        array[i].setTemperature(destination_start + (array[i].light - source_start));
                    }
                    if(array[i].temperature == -1)
                    {
                        array[i].setTemperature(array[i].light);
                    }
                }
                break;
            //temperature-to-humidity
            case 6:
                for(int i = 0; i < array.length; i++)
                {
                    if(array[i].temperature < source_start + range && array[i].temperature > source_start)
                    {
                        array[i].setHumidity(destination_start + (array[i].temperature - source_start));
                    }
                    if(array[i].humidity == -1)
                    {
                        array[i].setHumidity(array[i].temperature);
                    }
                }
                break;
            //humidity-to-location
            case 7:
                for(int i = 0; i < array.length; i++)
                {
                    if(array[i].humidity < source_start + range && array[i].humidity > source_start)
                    {
                        array[i].setLocation(destination_start + (array[i].humidity - source_start));
                    }
                    if(array[i].location == -1)
                    {
                        array[i].setLocation(array[i].humidity);
                    }
                }
                break;
        }
    }

    public static void zuordnen2(int status, ArrayList<seed> arrayList, long destination_start, long source_start, long range)
    {
        switch(status){
            // seed-to-soil
            case 1:
                for(int i = 0; i < arrayList.size(); i++)
                {
                    if(arrayList.get(i).seednum < source_start + range && arrayList.get(i).seednum > source_start)
                    {
                        arrayList.get(i).setSoil(destination_start + (arrayList.get(i).seednum-source_start));
                    }
                    if(arrayList.get(i).soil == -1)
                    {
                        arrayList.get(i).setSoil(arrayList.get(i).seednum);
                    }
                }
                break;

            // soil-to-fertilizer
            case 2:
                for(int i = 0; i < arrayList.size(); i++)
                {

                    if(arrayList.get(i).soil < source_start + range && arrayList.get(i).soil > source_start)
                    {
                        arrayList.get(i).setFertilizer(destination_start + (arrayList.get(i).soil-source_start));
                    }

                    if(arrayList.get(i).fertilizer == -1)
                    {
                        arrayList.get(i).setFertilizer(arrayList.get(i).soil);
                    }
                }
                break;
            //fertilizer-to-water
            case 3:
                for(int i = 0; i < arrayList.size(); i++)
                {
                    if(arrayList.get(i).fertilizer < source_start + range && arrayList.get(i).fertilizer > source_start)
                    {
                        arrayList.get(i).setWater(destination_start + (arrayList.get(i).fertilizer-source_start));
                    }
                    if(arrayList.get(i).water == -1)
                    {
                        arrayList.get(i).setWater(arrayList.get(i).fertilizer);
                    }
                }
                break;
            //water-to-light
            case 4:
                for(int i = 0; i < arrayList.size(); i++)
                {
                    if(arrayList.get(i).water < source_start + range && arrayList.get(i).water > source_start)
                    {
                        arrayList.get(i).setLight(destination_start + (arrayList.get(i).water - source_start));
                    }
                    if(arrayList.get(i).light == -1)
                    {
                        arrayList.get(i).setLight(arrayList.get(i).water);
                    }
                }
                break;
            //light-to-temperature
            case 5:
                for(int i = 0; i < arrayList.size(); i++)
                {
                    if(arrayList.get(i).light < source_start + range && arrayList.get(i).light > source_start)
                    {
                        arrayList.get(i).setTemperature(destination_start + (arrayList.get(i).light - source_start));
                    }
                    if(arrayList.get(i).temperature == -1)
                    {
                        arrayList.get(i).setTemperature(arrayList.get(i).light);
                    }
                }
                break;
            //temperature-to-humidity
            case 6:
                for(int i = 0; i < arrayList.size(); i++)
                {
                    if(arrayList.get(i).temperature < source_start + range && arrayList.get(i).temperature > source_start)
                    {
                        arrayList.get(i).setHumidity(destination_start + (arrayList.get(i).temperature - source_start));
                    }
                    if(arrayList.get(i).humidity == -1)
                    {
                        arrayList.get(i).setHumidity(arrayList.get(i).temperature);
                    }
                }
                break;
            //humidity-to-location
            case 7:
                for(int i = 0; i < arrayList.size(); i++)
                {
                    if(arrayList.get(i).humidity < source_start + range && arrayList.get(i).humidity > source_start)
                    {
                        arrayList.get(i).setLocation(destination_start + (arrayList.get(i).humidity - source_start));
                    }
                    if(arrayList.get(i).location == -1)
                    {
                        arrayList.get(i).setLocation(arrayList.get(i).humidity);
                    }
                }
                break;
        }
    }
}