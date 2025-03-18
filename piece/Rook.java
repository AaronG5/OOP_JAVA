package piece;

public class Rook extends Piece{
   
   private boolean isFirstMove = true;

   public Rook(boolean isWhite) {
      super(isWhite);
   }
   public Rook(boolean isWhite, char xPos, int yPos) {
      super(isWhite, xPos, yPos);
   }

   public void Castle() {
      // Let rook and king exchange positions if none of them moved and there is free space between them
      if(isFirstMove) {
         if(isWhite) {
            super.move('d', 1);
         }
         else {
            super.move('d', 8);
         }
         isFirstMove = false;
      }
   }

   @Override
   public boolean isValidMove(char targetXPos, int targetYPos) {
      // TODO: return false if the position it is trying to check is already taken by the same color, 
      // if position taken by piece of different color, return true and somehow stop the operation
      if(((targetXPos == xPos) && (targetYPos != yPos)) || ((targetXPos != xPos) && (targetYPos == yPos))) {
         isFirstMove = false;
         return true;
      }
      else {
         return false;
      }
   }
   @Override
   public String pieceToString() {
      if(isAlive) {
         return "Rook " + isWhite + " " + isAlive + " " + xPos + " " + yPos;
      }
      else {
         return "Rook " + isWhite + " " + isAlive;
      }
   }
}