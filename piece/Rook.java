package chess.piece;

public class Rook extends Piece{
   
   private boolean isFirstMove = true;

   public Rook(boolean isWhite, int col, int row) {
      super(isWhite, col, row);

      if(isWhite) { image = getImage("/w_rook.png"); }
      else { image = getImage("/b_rook.png"); }
   }

//   public void castle() {
//      // Let rook and king exchange positions if none of them moved and there is free space between them
//      if(isFirstMove) {
//         if(isWhite) {
//            super.move('d', 1);
//         }
//         else {
//            super.move('d', 8);
//         }
//         isFirstMove = false;
//      }
//   }

   @Override
   public String getType() { return "Rook"; }
   @Override
   public boolean isValidMove(int targetX, int targetY) {
      // TODO: return false if the position it is trying to check is already taken by the same color, 
      // if position taken by piece of different color, return true and somehow stop the operation
      if(((targetX == x) && (targetY != y)) || ((targetX != x) && (targetY == y))) {
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
         return "Rook " + isWhite + " " + isAlive + " " + x + " " + y;
      }
      else {
         return "Rook " + isWhite + " " + isAlive;
      }
   }
}