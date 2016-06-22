/**
 * Adventure.java
 * Assignment: Final Project
 * Purpose: class allows creation of items 
 * such as keys, gates, and trophies
 * 
 * @version 6/21/16
 * @author Owen Schroder, Kevin Wilson
 */
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class Item extends JPanel{
   public Item(){}
   boolean hasKey = false;
   int keyFrequency;
   int keyX;
   int keyY;
   //draws initial key
   public Item(int x, int y, Graphics g, int frequency, String itemType){
      if (itemType.equals("key")){
         drawKey(x,y,g,frequency);
      }
   }
   //method for creating/moving keys. takes coordinated to place, and key frequency, to differentiate keys
   public void drawKey(int x, int y, Graphics g, int frequency) {
      BufferedImage makeKey = null;
      try {
         makeKey = ImageIO.read(new File("Key_Sprite.png"));
      } 
      catch (IOException e) {
      }
      g.drawImage(makeKey , x , y , null);    
      keyFrequency = frequency;
      keyX = x;
      keyY = y;
   }
   public void getKey(){hasKey = true;}
}   