package chess.main;

import chess.exceptions.OutOfBoundsException;
import chess.piece.*;

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

//      try {
//         Pawn whitePawn1 = new Pawn(true, 'a', 1);

         // Factory method
//         BishopFactory bFactory = new BishopFactory();
//         PawnFactory pFactory = new PawnFactory();
//
//         Bishop whiteBishop2 = bFactory.createPiece(true, 'c', 6);
//         Pawn blackPawn1 = pFactory.createPiece(true, 'a', 2);
//
//
//         System.out.println(whiteBishop2.toString());
//         System.out.println(blackPawn1.toString());
//
//         whiteBishop2.move('d', 7);
         // ---


//         Movable blackPawn = new Pawn(false, 'a', 2);
//      } catch (OutOfBoundsException e) {
//         System.out.println(e.getMessage());
//         System.out.println(e.getInfo());
//      } catch (NullPointerException | IllegalArgumentException e) {
//         System.out.println(e.getMessage());
//      }
   }
}
