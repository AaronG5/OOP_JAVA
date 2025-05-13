package chess.piece;

import chess.exceptions.OutOfBoundsException;

public class Bishop extends Piece {

   public Bishop(boolean isWhite, int col, int row) {
      super(isWhite, col, row);

      if(isWhite) { image = getImage("/w_bishop.png"); }
      else { image = getImage("/b_bishop.png"); }
   }

   @Override
   public String getType() {
      return "Bishop";
   }
   @Override
   public boolean isValidMove(int targetX, int targetY) {
      return (Math.abs(targetX - x) == Math.abs(targetY - y));
   }
   @Override
   public String toString() {
      if(isAlive) {
         return "Bishop " + isWhite + " " + isAlive + " " + x + " " + y + "\n";
      }
      else {
         return "Bishop " + isWhite + " " + isAlive + "\n";
      }
   }
}
