package piece;

public class Bishop extends Piece{
   
   public Bishop(boolean isWhite) {
      super(isWhite);
   }
   public Bishop(boolean isWhite, char xPos, int yPos) {
      super(isWhite, xPos, yPos);
   }

   @Override
   public boolean isValidMove(char targetXPos, int targetYPos) {
      return (Math.abs(targetXPos - getxPos()) == Math.abs(targetYPos - getyPos()));
   }
   @Override
   public String pieceToString() {
      if(getIsAlive()) {
         return "Bishop " + getIsWhite() + " " + getIsAlive() + " " + getxPos() + " " + getyPos();
      }
      else {
         return "Bishop " + getIsWhite() + " " + getIsAlive();
      }
   }
}
