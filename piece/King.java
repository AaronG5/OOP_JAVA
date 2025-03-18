package piece;

public class King extends Piece{
   private boolean isFirstMove = true;

   public King(boolean isWhite) {
      super(isWhite);
   }
   public King(boolean isWhite, char xPos, int yPos) {
      super(isWhite, xPos, yPos);
   }

   public void Castle() {
      // Let rook and king exchange positions if none of them moved and there is free space between them
      if(isFirstMove) {
         if(isWhite) {
            super.move('c', 1);
         }
         else {
            super.move('c', 8);
         }
         isFirstMove = false;
      }
   }

   public String gameOver() {
      return "Game Over!\n" + (isWhite ? "Black" : "White") + " wins!";
   }

   @Override
   public boolean isValidMove(char targetXPos, int targetYPos) {
      if((Math.abs(targetXPos - xPos) == 1) || (Math.abs(targetYPos - yPos) == 1)) {
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
         return "King " + isWhite + " " + isAlive + " " + xPos + " " + yPos;
      }
      else {
         return "King " + isWhite + " " + isAlive;
      }
   }
}
