/**
 * Adventure.java
 * Assignment: Final Project
 * Purpose: Sets up and controls 
 * the palyer's environment, such 
 * as walls, doors, and items  
 * 
 * @version 6/21/16
 * @author Owen Schroder, Kevin Wilson
 */
import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import java.lang.Math;

public class Environment extends Map{
   Map level = new Map();   
   //manages items in each room
   public void items(int playerX, int playerY, Graphics g, boolean getItem){
      if(xNum == 0 && yNum == 0) {
         Item keyOne = new Item(125, 280, g, 0, "key");
         if(canGetItem(playerX, playerY, keyOne.keyX, keyOne.keyY, getItem)){
            keyOne.getKey();
         }
         if(keyOne.hasKey){
            keyOne.drawKey(playerX, playerY, g, 0);
         }
      }
   }
   //tests if player is close enough, and has key pressed to pick up an item
   public boolean canGetItem(int playerX, int playerY, int itemX, int itemY, boolean pickUp){
      boolean get = false; 
      if(Math.abs(playerX-itemX) < 50 && Math.abs(playerY-itemY) < 50 && pickUp) {
         get = true;
      } 
      return get;
   }
   //finds if player is moving through a door, to another room
   public int isDoor(int moveX, int moveY, char let, char direction, int[][] walls){ 
      int door = 0;
      if(direction == 'y'){
         if(let == 'w') {
            if(moveY - 10 <= 0){door = -1;}
         }
         else if(let == 's') {
            if(moveY + 10 >= 490){door = 1;}
         }
      }
      else{
         if(let == 'a') {
            if(moveX - 10 <= 0){door = -1;}
         }
         if(let == 'd') {
            if(moveX + 10 >= 790){door = 1;}
         }
      }
      return door;         
   }
   //returns 2d array of the rooms colors, by int
   public int[][] walls(int roomX, int roomY){
      BufferedImage room = null;
      try {
         room = ImageIO.read(new File(roomX + "," + roomY + ".png"));
      } 
      catch (IOException e) {
      }  
      int[][] walls = convertImage(room);  
      return walls; 
   }
   //tests if player is moving into a wall
   public boolean isWall(int moveX, int moveY, char let, int[][] walls){   
      boolean blocked = false;
      if(let == 'w') {
         if(walls[moveY-3][moveX] == -3584){blocked = true;}
      }
      else if(let == 's') {
         if(walls[moveY+20][moveX] == -3584){blocked = true;}
      }
      else if(let == 'a') {
         if(walls[moveY][moveX-3] == -3584 || walls[moveY+17][moveX-3] == -3584){blocked = true;}
      }
      else if(let == 'd') {
         if(walls[moveY][moveX+20] == -3584 || walls[moveY+17][moveX+20] == -3584){blocked = true;}
      }
      return blocked;      
   } 
   //converts room image into 2d array 
   static int[][] convertImage(BufferedImage image) {
      int width = image.getWidth();
      int height = image.getHeight();
      int[][] result = new int[height][width];
   
      for (int row = 0; row < height; row++) {
         for (int col = 0; col < width; col++) {
            result[row][col] = image.getRGB(col, row);
         }
      }
      return result;
   }
}