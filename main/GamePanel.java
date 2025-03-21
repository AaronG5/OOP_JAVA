package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable{
   
   public static final int WIDTH = 800;
   public static final int HEIGHT = 800;
   final int FPS = 60;
   Thread gameThread;
   Board board = new Board();

   public GamePanel() {
      setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
      setBackground(Color.black);
   }

   public void launchGame() {
      gameThread = new Thread(this);
      gameThread.start(); // Calls `run` method
   }

   private void update() {

   }
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      board.draw(g2);
   }
   @Override
   public void run() { // GAME LOOP
      double drawInterval = 1000000000 / FPS; // Second (in nanoseconds) / FPS
      double delta = 0;
      long lastTime = System.nanoTime();
      long currentTime;

      while(gameThread != null) {
         currentTime = System.nanoTime();
         delta += (currentTime - lastTime) / drawInterval;
         lastTime = currentTime;

         if(delta >= 1) {
            update();
            repaint();
            delta--;
         }
      }
   }

}
