/**
 * Adventure.java
 * Assignment: Final Project
 * Purpose: the client class 
 * to run the game. uses  
 * a KeyListener to move  
 * player
 * @version 6/21/16
 * @author Owen Schroder, Kevin Wilson
 */
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;

class Adventure extends JPanel implements KeyListener{
   //initializes the char to take in keyboard
   private char c = 'e';
   //starting player location, coordinates
   int x = 400;
   int y = 250;
   //starting map
   static int mapX = 0;
   static int mapY = 0;
   static int[][] wallLayout;
   static Graphics g;
   boolean getItem = false;
   //initializes class
   public Adventure() {
      this.setPreferredSize(new Dimension(800, 500));
      addKeyListener(this);
   }   
   public void addNotify() {
      super.addNotify();
      requestFocus();
   }
   //paints the player, items, and rooms
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Environment Layout = new Environment();
      Layout.drawRoom(mapX,mapY,g);
      Player PlayerSprite = new Player();
      PlayerSprite.drawPlayer(x,y,g);      
      Layout.items(x,y,g,getItem);
   }
   public void keyPressed(KeyEvent e) { }
   public void keyReleased(KeyEvent e) { }
   //takes keyboard input to move player around, and to different rooms
   public void keyTyped(KeyEvent e) {
      c = e.getKeyChar();
      repaint();
      g = this.getGraphics();
      Environment Layout = new Environment();
      if(Layout.isWall(x,y,c,wallLayout)){}
      else{
         if (c == 'a'){
            x = x - 3;
         }
         else if (c == 'w'){
            y = y - 3;
         }
         else if (c == 's'){
            y = y + 3;
         }
         else if (c == 'd'){
            x = x + 3;
         }          
         else if (c == 'e'){
            getItem = !getItem;
         }
         int yDoor = Layout.isDoor(x, y, c, 'y', wallLayout);
         int xDoor = Layout.isDoor(x, y, c, 'x', wallLayout);
         if(xDoor != 0||yDoor != 0){
            mapY = mapY + yDoor;
            mapX = mapX + xDoor;  
            wallLayout = Layout.walls(mapX,mapY);        
            Layout.drawRoom(mapX,mapY,g);   
            if(xDoor == -1) {
               x = 760;
            }
            else if(xDoor == 1) {
               x = 40;
            }    
            else if(yDoor == -1) {
               y = 460;
            }
            else if(yDoor == 1) {
               y = 40;
            }
         }
      
      }
   }
   //creates the JFrame, and puts first room onto panel
   public static void main(String[] s) throws IOException{
      JFrame f = new JFrame();
      f.getContentPane().add(new Adventure());
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.pack();
      f.setVisible(true);
      Environment Layout = new Environment();
      wallLayout = Layout.walls(mapX,mapY);
   }
}