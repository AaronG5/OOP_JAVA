package piece;

class Piece {
   protected final boolean isWhite;
   protected boolean isAlive = false;
   protected char xPos;
   protected int yPos;

   public Piece(boolean isWhite) {
      this.isWhite = isWhite;
   }

   public Piece(boolean isWhite, char xPos, int yPos) {
      this(isWhite);
      if(setxPos(xPos) && setyPos(yPos)) {
         setIsAlive(true);
      }
   }

   protected final void setIsAlive(boolean isAlive) {
      this.isAlive = isAlive;
   }
   protected final boolean setxPos(char xPos) {
      Character.toLowerCase(xPos);
      if(xPos >= 'a' && xPos <= 'h') {
         this.xPos = xPos;
         return true;
      }
      else {
         //System.out.println("Error, invalid coordinate value.\n");
         return false;
      }
   }
   protected final boolean setyPos(int yPos) {
      if(yPos > 0 && yPos < 9) {
         this.yPos = yPos;
         return true;
      }
      else {
         //System.out.println("Error, invalid coordinate value.\n");
         return false;
      }
   }
   
   public boolean getIsWhite() {
      return isWhite;
   }
   public boolean getIsAlive() {
      return isAlive;
   }
   public char getxPos() {
      if(isAlive) {
         return xPos;
      }
      return 0;
   }
   public int getyPos() {
      if(isAlive) {
         return yPos;
      }
      return 0;
   }
   
   public void captured() {
      setIsAlive(false);
   }
   public void move(char targetXPos, int targetYPos) {
      if(isValidMove(targetXPos, targetYPos)) {
         setxPos(targetXPos);
         setyPos(targetYPos);
      }
   }

   public boolean isValidMove(char targetXPos, int targetYPos) {   
      return (((targetXPos == xPos) && (targetYPos != yPos)) || ((targetXPos != xPos) && (targetYPos == yPos)));
   }
   
   public String pieceToString() {
      if(isAlive) {
         return "Piece " + isWhite + " " + isAlive + " " + xPos + " " + yPos;
      }
      else {
         return "Piece " + isWhite + " " + isAlive;
      }
   }
}