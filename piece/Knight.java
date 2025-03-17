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
      return (Math.abs(targetXPos - getxPos()) * Math.abs(targetYPos - getyPos()) == 2);
   }
   @Override
   public String pieceToString() {
      if(getIsAlive()) {
         return "Knight " + getIsWhite() + " " + getIsAlive() + " " + getxPos() + " " + getyPos();
      }
      else {
         return "Knight " + getIsWhite() + " " + getIsAlive();
      }
   }
}
