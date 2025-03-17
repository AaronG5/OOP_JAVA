package main;

import javax.swing.JFrame;

public class Main {
   public static void main(String[] args) {
      JFrame window = new JFrame("Chess");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);

      GamePanel game = new GamePanel();
      window.add(game);
      window.pack();

      window.setLocationRelativeTo(null);
      window.setVisible(true);

      game.launchGame();


      // Rook whiteRook = new Rook(true, 'b', 7);
      // System.out.println(whiteRook.pieceToString());
      // System.out.println(whiteRook.isValidMove('b', 1));

      // Bishop whiteBishop = new Bishop(true, 'a', 1);
      // System.out.println(whiteBishop.pieceToString());
      // System.out.println(whiteBishop.isValidMove('b', 2));
   }
}
