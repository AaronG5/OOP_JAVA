package piece;

public class Pawn extends Piece{
   
   private boolean isFirstMove = true;

   public Pawn(boolean isWhite) {
      super(isWhite);
   }
   public Pawn(boolean isWhite, char xPos, int yPos) {
      super(isWhite, xPos, yPos);
   }

   public void promote() {
      // TODO: make pawn be able to convert into other piece
   }
   public void enPassant() {
      // TODO: make pawn be able to en passant
   }


   @Override
   public boolean isValidMove(char targetXPos, int targetYPos) {
      if(isFirstMove && (Math.abs(targetYPos - yPos) == 2)) {
         isFirstMove = false;
         return true;
      }
      else if(Math.abs(targetYPos - yPos) == 1) {
         if(isFirstMove) {
            isFirstMove = false;
         }
         return true;
      }
      else {
         return false;
      }
      // TODO: Add condition to check if an enemy piece is sitting diagonaly next to pawn
   }
   @Override
   public String pieceToString() {
      if(isAlive) {
         return "Pawn " + isWhite + " " + isAlive + " " + xPos + " " + yPos;
      }
      else {
         return "Pawn " + isWhite + " " + isAlive;
      }
   }
   @Override
   public void move(char targetXPos, int targetYPos) {
      if(isValidMove(targetXPos, targetYPos)) {
         setxPos(targetXPos);
         setyPos(targetYPos);
      }
      if(yPos == (isWhite ? 8 : 1)) {
         promote();
      }
   }
}
