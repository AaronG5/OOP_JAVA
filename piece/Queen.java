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
      return ((Math.abs(targetXPos - getxPos()) == Math.abs(targetYPos - getyPos())) || ((targetXPos == getxPos()) && (targetYPos != getyPos())) || ((targetXPos != getxPos()) && (targetYPos == getyPos())));
   }
   @Override
   public String pieceToString() {
      if(getIsAlive()) {
         return "Queen " + getIsWhite() + " " + getIsAlive() + " " + getxPos() + " " + getyPos();
      }
      else {
         return "Queen " + getIsWhite() + " " + getIsAlive();
      }
   }
}
