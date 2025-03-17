package piece;

abstract class Piece {
   private static int livePieceCount = 0;
   private final boolean isWhite;
   private boolean isAlive = false;
   private char xPos;
   private int yPos;

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

   protected final void setIsAlive(boolean isAlive) {
      this.isAlive = isAlive;
   }
   protected final void setxPos(char xPos) {
      Character.toLowerCase(xPos);
      if(xPos >= 'a' && xPos <= 'h') {
         this.xPos = xPos;
      }
      else {
         System.out.println("Error, invalid coordinate value.\n");
      }
   }
   protected final void setyPos(int yPos) {
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
   
   public void captured() {
      setIsAlive(false);
      --livePieceCount;
   }
   public void move(char targetXPos, int targetYPos) {
      if(isValidMove(targetXPos, targetYPos)) {
         setxPos(targetXPos);
         setyPos(targetYPos);
      }
   }
   public void move(char targetXPos) {
      setxPos(targetXPos);
   }
   public void move(int targetYPos) {
      setyPos(targetYPos);
   }

   public abstract boolean isValidMove(char xPos, int yPos);

   public abstract String pieceToString();
}

