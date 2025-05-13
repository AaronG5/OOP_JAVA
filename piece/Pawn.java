package chess.piece;

import chess.exceptions.OutOfBoundsException;

public class Pawn extends Piece {
   
   private boolean isFirstMove = true;

   public Pawn(boolean isWhite, int col, int row) {
      super(isWhite, col, row);

      if(isWhite) { image = getImage("/w_pawn.png"); }
      else { image = getImage("/b_pawn.png"); }
   }

   @Override
   public String getType() {
      return "Pawn";
   }
   @Override
   public boolean isValidMove(int targetX, int targetY) {
      if(isFirstMove && (Math.abs(targetY - y) == 2)) {
         isFirstMove = false;
         return true;
      }
      else if(Math.abs(targetY - y) == 1) {
         if(isFirstMove) {
            isFirstMove = false;
         }
         return true;
      }
      else if(Math.abs(targetX - x) + Math.abs(targetY - y) == 2) {
         if(isFirstMove) {
            isFirstMove = false;
         }
         return true;
      }
      else {
         return false;
      }
   }
   @Override
   public String toString() {
      if(isAlive) {
         return "Pawn " + isWhite + " " + isAlive + " " + x + " " + y + "\n";
      }
      else {
         return "Pawn " + isWhite + " " + isAlive + "\n";
      }
   }
}
