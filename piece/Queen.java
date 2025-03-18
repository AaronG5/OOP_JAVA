package piece;

public class Queen extends Piece{
   
   public Queen(boolean isWhite) {
      super(isWhite);
   }
   public Queen(boolean isWhite, char xPos, int yPos) {
      super(isWhite, xPos, yPos);
   }

   @Override
   public boolean isValidMove(char targetXPos, int targetYPos) {
      return ((Math.abs(targetXPos - xPos) == Math.abs(targetYPos - yPos)) || ((targetXPos == xPos) && (targetYPos != yPos)) || ((targetXPos != xPos) && (targetYPos == yPos)));
   }
   @Override
   public String pieceToString() {
      if(isAlive) {
         return "Queen " + isWhite + " " + isAlive + " " + xPos + " " + yPos;
      }
      else {
         return "Queen " + isWhite + " " + isAlive;
      }
   }
}
