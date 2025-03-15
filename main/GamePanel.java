package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable{
   
   public static final int WIDTH = 800;
   public static final int HEIGHT = 800;

   public GamePanel() {
      setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
      setBackground(Color.black);
   }

   private void update() {

   }
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
   }
   @Override
   public void run() {};

}
