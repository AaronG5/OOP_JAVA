package chess.piece;

public class King extends Piece{
   private boolean isFirstMove = true;

   public King(boolean isWhite, int col, int row) {
      super(isWhite, col, row);

      if(isWhite) { image = getImage("/w_king.png"); }
      else { image = getImage("/b_king.png"); }
   }

//   public void castle() {
//      // Let rook and king exchange positions if none of them moved and there is free space between them
//      if(isFirstMove) {
//         if(isWhite) {
//            super.move('c', 1);
//         }
//         else {
//            super.move('c', 8);
//         }
//         isFirstMove = false;
//      }
//   }

   public String gameOver() {
      
      return "Game Over!\n" + (isWhite ? "Black" : "White") + " wins!";
   }

   @Override
   public String getType() { return "King"; }
   @Override
   public boolean isValidMove(int targetX, int targetY) {
      if((Math.abs(targetX - x) == 1) || (Math.abs(targetY - y) == 1)) {
         isFirstMove = false;
         return true;
      }
      else {
         return false;
      }
   }
   @Override
   public String toString() {
      if(isAlive) {
         return "King " + isWhite + " " + isAlive + " " + x + " " + y;
      }
      else {
         return "King " + isWhite + " " + isAlive;
      }
   }
}
