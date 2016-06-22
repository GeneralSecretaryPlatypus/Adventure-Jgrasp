/**
 * Adventure.java
 * Assignment: Final Project
 * Purpose: creates and draws 
 * the player Sprite  
 * 
 * @version 6/21/16
 * @author Owen Schroder, Kevin Wilson
 */
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Player extends JPanel{
   Graphics grap;
   //draws the player sprite
   void drawPlayer(int x, int y, Graphics g){
      BufferedImage player = null;
      try {
         player = ImageIO.read(new File("Player_Sprite.png"));
      } 
      catch (IOException e) {
      }
      g.drawImage(player , x , y , null);
   }
}