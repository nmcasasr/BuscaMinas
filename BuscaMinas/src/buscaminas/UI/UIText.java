/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas.UI;

/**
 *
 * @author nmcasasr
 */

import buscaminas.data.Map;
import java.util.Scanner;
public class UIText {
    private static Scanner opcion = new Scanner(System.in);
    
    public static String[] menu()
    {
        System.out.println("----------------Mines Weeper----------------");
        System.out.println("Welcome to Mines Weeper, please enter  height, width of the board and the number of mines (for example '5 6 2'): ");
        String dataMap= opcion.nextLine();
        String[] splited = dataMap.split("\\s+");
        return splited;
    }
     public static void exit()
    {
        System.out.println("Thanks for playing :)");
        System.exit(0);
    }
     public static void error()
    {
        System.out.println("There is more mines than cells, try again.");
       
    }
      public static void error2()
    {
        System.out.println("Invalid input, try again.");
       
    }
       public static void win()
    {
        System.out.println("You win! :)");
       
    }
          public static void lose()
    {
        System.out.println("You lose! :(");
       
    }
      public static String[] select()
    {
        System.out.println("Chose uncover(U) o mark a cell(M), for example '2 3 U', that means Uncover cell in position row 2, column 4");
        String dataSelection= opcion.nextLine();
        String[] splited = dataSelection.split("\\s+");
        return splited;
       
    }
     public static void printMap(Map mapGame)
     {
 
           String[][] mapString = new String[mapGame.getX()][mapGame.getY()];
           
          char[][] mapChar = mapGame.getMap();
          //int[][]mapChar = mapGame.getMapData();
           for(int c = 0; c < mapGame.getX(); c++)
        {
            for(int f = 0; f < mapGame.getY(); f++)
            {
                mapString[c][f] = String.valueOf(mapChar[c][f]);
                System.out.print(mapString[c][f]);
                System.out.print(" ");
            }
            System.out.println();
        }
         
     }
}

