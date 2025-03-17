package piece;

public class King extends Piece{
   
   public King(boolean isWhite) {
      super(isWhite);
   }
   public King(boolean isWhite, char xPos, int yPos) {
      super(isWhite, xPos, yPos);
   }

   public boolean canCastle() {
      // Let rook and king exchange positions if none of them moved and there is free space between them
      return true;
   }

   public void gameOver() {
      System.out.println("Game Over!\n" + (getIsWhite() ? "Black" : "White") + " wins!");
   }

   @Override
   public boolean isValidMove(char targetXPos, int targetYPos) {
      return ((Math.abs(targetXPos - getxPos()) == 1) || (Math.abs(targetYPos - getyPos()) == 1));
   }
   @Override
   public String pieceToString() {
      if(getIsAlive()) {
         return "King " + getIsWhite() + " " + getIsAlive() + " " + getxPos() + " " + getyPos();
      }
      else {
         return "King " + getIsWhite() + " " + getIsAlive();
      }
   }
}
