package piece;

public class Rook extends Piece{
   
   public Rook(boolean isWhite) {
      super(isWhite);
   }
   public Rook(boolean isWhite, char xPos, int yPos) {
      super(isWhite, xPos, yPos);
   }

   @Override
   public boolean isValidMove(char xPos, int yPos) {
      if(((xPos == this.xPos) && (yPos != this.yPos)) || ((xPos != this.xPos) && (yPos == this.yPos))) {
         return true;
      }

      // TODO: return false if the position it is trying to check is already taken by the same color, if position taken by piece of different color, return true and somehow stop the operation
      
      return true;
   }
}
