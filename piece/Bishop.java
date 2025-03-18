package piece;

public class Bishop extends Piece {
   
   public Bishop(boolean isWhite) {
      super(isWhite);
   }
   public Bishop(boolean isWhite, char xPos, int yPos) {
      super(isWhite, xPos, yPos);
   }

   @Override
   public boolean isValidMove(char targetXPos, int targetYPos) {
      return (Math.abs(targetXPos - xPos) == Math.abs(targetYPos - yPos));
   }
   @Override
   public String pieceToString() {
      if(isAlive) {
         return "Bishop " + isWhite + " " + isAlive + " " + xPos + " " + yPos;
      }
      else {
         return "Bishop " + isWhite + " " + isAlive;
      }
   }
}
