package piece;

abstract class Piece {
   private static int livePieceCount = 0;
   protected final boolean isWhite;
   protected boolean isAlive = false;
   protected char xPos;
   protected int yPos;

   public Piece(boolean isWhite) {
      this.isWhite = isWhite;
      ++livePieceCount;
   }

   public Piece(boolean isWhite, char xPos, int yPos) {
      this(isWhite);
      setxPos(xPos);
      setyPos(yPos);
      setIsAlive(true);
   }

   private void setIsAlive(boolean isAlive) {
      this.isAlive = isAlive;
   }
   private void setxPos(char xPos) { // Change to abstract maybe
      Character.toLowerCase(xPos);
      if(xPos >= 'a' && xPos <= 'h') {
         this.xPos = xPos;
      }
      else {
         System.out.println("Error, invalid coordinate value.\n");
      }
   }
   private void setyPos(int yPos) { // Change to abstract maybe
      if(yPos > 0 && yPos < 9) {
         this.yPos = yPos;
      }
      else {
         System.out.println("Error, invalid coordinate value.\n");
      }
   }
   
   public static int getLivePieceCount() {
      return livePieceCount;
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

   public abstract boolean isValidMove(char xPos, int yPos);

   public void captured() {
      setIsAlive(false);
      --livePieceCount;
   }
   public void move(char xPos, int yPos) {
      if(isValidMove(xPos, yPos)) {
         setxPos(xPos);
         setyPos(yPos);
      }
   }
   public void move(char xPos) {
      setxPos(xPos);
   }
   public void move(int yPos) {
      setyPos(yPos);
   }

   public void println() {
      if(isAlive) {
         System.out.println(isWhite + " " + isAlive + " " + xPos + " " + yPos);
      }
      else {
         System.out.println(isWhite + " " + isAlive);
      }
   }
}

