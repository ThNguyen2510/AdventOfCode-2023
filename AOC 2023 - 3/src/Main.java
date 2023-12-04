import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("src/input"));
        String zeile = input.nextLine();;
        List<Integer> sum = new ArrayList<>();
        part [][] map = new part [zeile.length()][140];
        String summenWert = "";
        int gesamt = 0;
        int gearRatio = 0;
        int gear = 0;
        int gearges = 0;
        int partcount = 0;
        List<Integer> gearsum = new ArrayList<>();
        for(int i = 0; i < 140; i++)
        {
            if(i != 0)
            {
                zeile = input.nextLine();
            }

            for(int j = 0; j < zeile.length(); j++)
            {
                map[i][j] = new part(zeile.charAt(j));
                if(!isDigit(map[i][j].content) && map[i][j].content != '.')
                {
                    map[i][j].setSpecial(true);
                }
            }

        }
        //verbinden der zahlen
        for(int i = 0; i < 140; i++)
        {
            for(int j = 0; j < map[i].length;j++)
            {
                if(isDigit(map[i][j].content) && !map[i][j].isVerbunden())
                {
                    map[i][j].setVerbunden(true);
                    map[i][j].setMain(map[i][j]);
                    if(isDigit(map[i][j+1].content))
                    {
                        map[i][j].setPartner(map[i][j+1]);
                        map[i][j].setHasPartner(true);

                        map[i][j+1].setVerbunden(true);

                        map[i][j+1].setMain(map[i][j]);

                        //if(j+2 <= map[i].length)
                        //{
                            if(isDigit(map[i][j+2].content))
                            {
                                map[i][j].setPartner2(map[i][j+2]);
                                map[i][j].setHasPartner2(true);
                                map[i][j+2].setVerbunden(true);

                                map[i][j+2].setMain(map[i][j]);
                            }
                        //}
                    }
                    if(map[i][j].hasPartner && map[i][j].hasPartner2)
                    {
                        summenWert = ""+map[i][j].content + map[i][j].getPartner().content + map[i][j].partner2.content;
                    }
                    else if (map[i][j].hasPartner)
                    {
                        summenWert = ""+map[i][j].content + map[i][j].partner.content;
                    }
                    else
                    {
                        summenWert = ""+map[i][j].content;
                    }

                    map[i][j].setWert(Integer.parseInt(summenWert));
                }
            }
        }

        for(int i = 0; i < 140; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {

                //if(map[i][j].content != '.')
                if (map[i][j].content == '*') {
                    //if(map[i][j].special)
                    //{
                    if (isDigit(map[i - 1][j - 1].content)) {
                        if (!map[i - 1][j - 1].getMain().gecheckt) {
                            sum.add(map[i - 1][j - 1].getMain().wert);

                            //part 2
                            gear = map[i - 1][j - 1].getMain().wert;
                            partcount++;
                            map[i - 1][j - 1].getMain().setGecheckt(true);


                        }
                    }

                    if (isDigit(map[i - 1][j].content)) {
                        if (!map[i - 1][j].getMain().gecheckt) {
                            sum.add(map[i - 1][j].getMain().wert);
                            map[i - 1][j].getMain().setGecheckt(true);

                            //part 2
                            if (gear == 0) {
                                gear = map[i - 1][j].getMain().wert;
                                partcount = 1;
                            } else {
                                gearges = gear * map[i - 1][j].getMain().wert;
                                partcount++;
                            }
                        }
                    }

                    if (isDigit(map[i - 1][j + 1].content)) {
                        if (!map[i - 1][j + 1].getMain().gecheckt) {
                            sum.add(map[i - 1][j + 1].getMain().wert);
                            map[i - 1][j + 1].getMain().setGecheckt(true);

                            //part 2

                            if (gear == 0) {
                                gear = map[i - 1][j + 1].getMain().wert;
                                partcount = 1;
                            } else {
                                gearges = gear * map[i - 1][j + 1].getMain().wert;
                                partcount++;
                            }
                        }
                    }

                    if (isDigit(map[i][j - 1].content)) {
                        if (!map[i][j - 1].getMain().gecheckt) {
                            sum.add(map[i][j - 1].getMain().wert);
                            map[i][j - 1].getMain().setGecheckt(true);

                            //part 2
                            if (gear == 0) {
                                gear = map[i][j - 1].getMain().wert;
                                partcount = 1;
                            } else {
                                gearges = gear * map[i][j - 1].getMain().wert;
                                partcount++;
                            }
                        }
                    }

                    if (isDigit(map[i][j + 1].content)) {
                        if (!map[i][j + 1].getMain().gecheckt) {
                            sum.add(map[i][j + 1].getMain().wert);
                            map[i][j + 1].getMain().setGecheckt(true);

                            //part 2
                            if (gear == 0) {
                                gear = map[i][j + 1].getMain().wert;
                                partcount = 1;
                            } else {
                                gearges = gear * map[i][j + 1].getMain().wert;
                                partcount++;
                            }
                        }
                    }

                    if (isDigit(map[i + 1][j + 1].content)) {
                        if (!map[i + 1][j + 1].getMain().gecheckt) {
                            sum.add(map[i + 1][j + 1].getMain().wert);
                            map[i + 1][j + 1].getMain().setGecheckt(true);


                            //part 2
                            if (gear == 0) {
                                gear = map[i + 1][j + 1].getMain().wert;
                                partcount = 1;
                            } else {
                                gearges = gear * map[i + 1][j + 1].getMain().wert;
                                partcount++;
                            }
                        }
                    }

                    if (isDigit(map[i + 1][j].content)) {
                        if (!map[i + 1][j].getMain().gecheckt) {
                            sum.add(map[i + 1][j].getMain().wert);
                            map[i + 1][j].getMain().setGecheckt(true);

                            //part 2
                            if (gear == 0) {
                                gear = map[i + 1][j].getMain().wert;
                                partcount = 1;
                            } else {
                                gearges = gear * map[i + 1][j].getMain().wert;
                                partcount++;
                            }
                        }
                    }

                    if (isDigit(map[i + 1][j - 1].content)) {
                        if (!map[i + 1][j - 1].getMain().gecheckt) {
                            sum.add(map[i + 1][j - 1].getMain().wert);
                            map[i + 1][j - 1].getMain().setGecheckt(true);
                            //part 2
                            if (gear == 0) {
                                gear = map[i + 1][j - 1].getMain().wert;
                                partcount = 1;
                            } else {
                                gearges = gear * map[i + 1][j - 1].getMain().wert;
                                partcount++;
                            }
                        }
                    }
                    //}
                    //}
                    if(partcount == 2)
                    {
                        gearsum.add(gearges);
                    }
                    partcount = 0;
                    gear = 0;
                }
            }
        }
        for(int i = 0; i < sum.size(); i++)
        {
            gesamt = gesamt + sum.get(i);

        }
        gesamt = 0;

        for(int i = 0; i < gearsum.size(); i++)
        {
            gesamt = gesamt + gearsum.get(i);

        }
        System.out.println(gesamt);





        System.out.println(map);
    }

}