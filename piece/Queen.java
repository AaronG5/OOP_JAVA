package chess.piece;

public class Queen extends Piece{

   public Queen(boolean isWhite, int col, int row) {
      super(isWhite, col, row);

      if(isWhite) { image = getImage("/w_queen.png"); }
      else { image = getImage("/b_queen.png"); }
   }

   @Override
   public String getType() { return "Queen"; }
   @Override
   public boolean isValidMove(int targetX, int targetY) {
      return ((Math.abs(targetX - x) == Math.abs(targetY - y)) || ((targetX == x) && (targetY != y)) || ((targetX != x) && (targetY == y)));
   }
   @Override
   public String toString() {
      if(isAlive) {
         return "Queen " + isWhite + " " + isAlive + " " + x + " " + y;
      }
      else {
         return "Queen " + isWhite + " " + isAlive;
      }
   }
}
