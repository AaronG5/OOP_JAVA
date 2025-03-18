package piece;

public class Knight extends Piece {
   
   public Knight(boolean isWhite) {
      super(isWhite);
   }
   public Knight(boolean isWhite, char xPos, int yPos) {
      super(isWhite, xPos, yPos);
   }

   @Override
   public boolean isValidMove(char targetXPos, int targetYPos) {
      return (Math.abs(targetXPos - xPos) * Math.abs(targetYPos - yPos) == 2);
   }
   @Override
   public String pieceToString() {
      if(isAlive) {
         return "Knight " + isWhite + " " + isAlive + " " + xPos + " " + yPos;
      }
      else {
         return "Knight " + isWhite + " " + isAlive;
      }
   }
}
