/**
 * Adventure.java
 * Assignment: Final Project
 * Purpose: allows for the
 * creation of the room maps 
 * draws png of rooms to panel
 * 
 * @version 6/21/16
 * @author Owen Schroder, Kevin Wilson
 */
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class Map extends JPanel{
   int xNum;
   int yNum;
   Graphics grap;
   //draws the current room, based on room coordinates
   void drawRoom(int x, int y, Graphics g){
      BufferedImage roomToDraw = null;
      try {
         roomToDraw = ImageIO.read(new File(x + "," + y + ".png"));
      } 
      catch (IOException e) {
      }
      g.drawImage(roomToDraw , 0 , 0 , null);
      xNum=x;
      yNum=y;
   }
}