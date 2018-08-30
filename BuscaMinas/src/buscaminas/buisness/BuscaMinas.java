/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas.buisness;

import buscaminas.UI.UIText;
import buscaminas.data.Map;

/**
 *
 * @author User
 */
public class BuscaMinas {
    
    
    public static Map map;
    public static String[] data;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        boolean win = false;
       
        
       
        
        boolean gameMenu = true;
         while(gameMenu)
         {
             data = UIText.menu();  
            if((Integer.parseInt(data[0])*Integer.parseInt(data[1])) > Integer.parseInt(data[2]))
        {
             
        map = new Map(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
          
          UIText.printMap(map);  
          gameMenu = false;
        }
        else
        {
            UIText.error();
        }  
         }
      
         while(win == false)
                {
        String[] selection = UIText.select();
        System.out.println(selection[2]);
        if((Integer.parseInt(selection[0]) < Integer.parseInt(data[0])) && (Integer.parseInt(selection[1]) < Integer.parseInt(data[1])) && ((selection[2].equals("U"))||selection[2].equals("O")))
        {
             String winString = map.updateMap(selection);
        System.out.println(winString);
        UIText.printMap(map);
        
        if(winString == "Winner")
        {
            UIText.win();
            win = true;
        }
        
        if(winString == "Loser")
        {
            UIText.lose();
            win = true;
        }
        }
       else
        {
            UIText.error2();
        }
        
                }
    }
    
}
