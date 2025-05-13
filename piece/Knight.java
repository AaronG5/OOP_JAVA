package chess.piece;

public class Knight extends Piece {

   public Knight(boolean isWhite, int col, int row) {
      super(isWhite, col, row);

      if(isWhite) { image = getImage("/w_knight.png"); }
      else { image = getImage("/b_knight.png"); }
   }

   @Override
   public String getType() { return "Knight"; }
   @Override
   public boolean isValidMove(int targetX, int targetY) {
      return (Math.abs(targetX - x) * Math.abs(targetY - y) == 2);
   }
   @Override
   public String toString() {
      if(isAlive) {
         return "Knight " + isWhite + " " + isAlive + " " + x + " " + y;
      }
      else {
         return "Knight " + isWhite + " " + isAlive;
      }
   }
}
