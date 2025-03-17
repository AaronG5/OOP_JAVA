package piece;

public class Rook extends Piece{
   
   public Rook(boolean isWhite) {
      super(isWhite);
   }
   public Rook(boolean isWhite, char xPos, int yPos) {
      super(isWhite, xPos, yPos);
   }

   public void canCastle() {
      // Let rook and king exchange positions if none of them moved and there is free space between them
   }

   @Override
   public boolean isValidMove(char targetXPos, int targetYPos) {
      // TODO: return false if the position it is trying to check is already taken by the same color, 
      // if position taken by piece of different color, return true and somehow stop the operation
      return (((targetXPos == getxPos()) && (targetYPos != getyPos())) || ((targetXPos != getxPos()) && (targetYPos == getyPos())));
   }
   @Override
   public String pieceToString() {
      if(getIsAlive()) {
         return "Rook " + getIsWhite() + " " + getIsAlive() + " " + getxPos() + " " + getyPos();
      }
      else {
         return "Rook " + getIsWhite() + " " + getIsAlive();
      }
   }
}
