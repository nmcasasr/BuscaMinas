/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas.data;

/**
 *
 * @author User
 */
import java.util.concurrent.ThreadLocalRandom;
public class Map {
    private static char[][] map;
    private static int[][] mapData;
    private static int mines;
    private static int xData;
    private static int yData;

  
    public static char[][] getMap() {
        return map;
    }

    public static void setMap(char[][] map) {
        Map.map = map;
    }

    public static int[][] getMapData() {
        return mapData;
    }

    public static void setMapData(int[][] mapData) {
        Map.mapData = mapData;
    }

    public static int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    public static int getX() {
        return xData;
    }

    public static void setX(int x) {
        Map.xData = x;
    }

    public static int getY() {
        return yData;
    }

    public static void setY(int y) {
        Map.yData = y;
    }
    
    
      public Map(int x, int y, int mine) {
         map = new char[x][y];
         mapData = new int[x][y];
         xData = x;
         yData = y;
         mines = mine;
         int randomNumber = mine;
         while(randomNumber > 0)
         {
         int mineRandomX = ThreadLocalRandom.current().nextInt(0, x-1);
         int mineRandomY = ThreadLocalRandom.current().nextInt(0, y-1);   
         if(mapData[mineRandomX][mineRandomY] < 0)
          {
              
          }
          else
          {
              //-1 represent mines
              mapData[mineRandomX][mineRandomY] = - 1;
              
              if((mineRandomX + 1 >= 0 && mineRandomY + 1 >= 0) && (mapData[mineRandomX + 1][mineRandomY + 1] != -1))
              {
              mapData[mineRandomX + 1][mineRandomY + 1]++;   
              }
            if((mineRandomX+1 >= 0 && mineRandomY >= 0) && (mapData[mineRandomX + 1][mineRandomY] != -1))
              {
              mapData[mineRandomX + 1][mineRandomY]++;   
              }
             if((mineRandomX >= 0 && mineRandomY+1 >= 0) && (mapData[mineRandomX][mineRandomY + 1] != -1))
              {
              mapData[mineRandomX][mineRandomY + 1]++;   
              }
              if((mineRandomX-1 >= 0 && mineRandomY-1 >= 0) && (mapData[mineRandomX -1][mineRandomY -1] != -1))
              {
              mapData[mineRandomX -1][mineRandomY -1]++;   
              }
               if((mineRandomX >= 0 && mineRandomY-1 >= 0) && (mapData[mineRandomX ][mineRandomY - 1] != -1))
              {
              mapData[mineRandomX ][mineRandomY - 1]++;   
              }
                if((mineRandomX-1 >= 0 && mineRandomY >= 0) && (mapData[mineRandomX - 1][mineRandomY ] != -1))
              {
              mapData[mineRandomX - 1][mineRandomY ]++;   
              }
                 if((mineRandomX+1 >= 0 && mineRandomY-1 >= 0) && (mapData[mineRandomX + 1][mineRandomY - 1] != -1))
              {
              mapData[mineRandomX + 1][mineRandomY - 1]++;   
              }
                  if((mineRandomX-1 >= 0 && mineRandomY+1 >= 0) && (mapData[mineRandomX - 1][mineRandomY + 1] != -1))
              {
              mapData[mineRandomX - 1][mineRandomY + 1]++;   
              }
            
                   
              
              randomNumber--; 
          }
         }
         
         
            //This map is what the user see                       
          for(int i = 0; i < x; i++)
          {
              for(int j = 0; j < y; j++)
          {
              map[i][j] = '.';
            
      
          } 
          }
            
    }

     public static String updateMap(String[] select)
     {
        int x = Integer.parseInt(select[0]);
        int y = Integer.parseInt(select[1]);
        char simbol = select[2].charAt(0);
        System.out.println(mines);
        if(simbol == 'U')
        {
            
            if(mapData[x][y] == -1)
            {
                map[x][y] = '*';
                return "Loser";
            }
            if(mapData[x][y] >= 0)
            {
                paintCell(x,y);
            }
            
        }
            if(simbol == 'M')
            {
            if(mapData[x][y] == -1)
            {
                mines--;
                map[x][y] = 'P';
                if(mines == 0)
                {
                    return "Winner";
                }
            }
                
            }
        
        return "next";
         
         
         
     }
     public static void paintCell(int x,int y)
     {
         if((x  < xData && y < yData) &&(x >= 0 && y >= 0) && (mapData[x][y] == 0))
              {
                  System.out.print(" Entro " +x + " " + y);
                  if(mapData[x][y] == 0)
                  {
                       mapData[x][y] = -2;   
                       map[x][y] = '-';
                  }
                   if(mapData[x][y] > 0)
                  {
                       
                        map[x][y] = Character.forDigit(mapData[x][y], 10);
                        mapData[x][y] = -3;   
                  }    
                       
                       
                       
                       
                      paintCell(x+1,y);
                       paintCell(x,y+1);
                       paintCell(x-1,y);
                       paintCell(x,y-1);
       
              }
         else if((x  < xData && y < yData) &&(x >= 0 && y >= 0) && (mapData[x][y] > 0))
              {
                  
                
                       
                        map[x][y] = Character.forDigit(mapData[x][y], 10);
                        mapData[x][y] = -3;   
            
       
              }
              
     }
   
}

/*

        if((x  < xData && y < yData) &&(x >= 0 && y >= 0) && (mapData[x][y] > 0))
              {
                       map[x][y] = Character.forDigit(mapData[x][y], 10);
                       paintCell(x+1,y);
                       paintCell(x,y+1);
                       paintCell(x-1,y);
                       paintCell(x,y-1);

             
              }
*/