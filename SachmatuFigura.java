// aaron.gandzumian@mif.stud.vu.lt
// LSP ID: 2413934

enum pieceType {
   PAWN,
   KNIGHT,
   BISHOP,
   ROOK,
   QUEEN,
   KING
}

class ChessPiece {
   private static int livePieceCount = 0;
   private final pieceType type;
   private final boolean isWhite;
   private boolean isAlive = false;
   private char xPos;
   private int yPos;

   public ChessPiece(pieceType type, boolean isWhite) {
      this.type = type;
      this.isWhite = isWhite;
      
      ++livePieceCount;
   }

   public ChessPiece(pieceType type, boolean isWhite, char xPos, int yPos) {
      this(type, isWhite);
      setxPos(xPos);
      setyPos(yPos);
      setisAlive(true);
   }

   private void setisAlive(boolean isAlive) {
      this.isAlive = isAlive;
   }
   private void setxPos(char xPos) {
      Character.toLowerCase(xPos);
      if(xPos >= 'a' && xPos <= 'h') {
         this.xPos = xPos;
      }
      else {
         System.out.println("Error, invalid coordinate value.\n");
      }
   }
   private void setyPos(int yPos) {
      if(yPos > 0 && yPos < 9) {
         this.yPos = yPos;
      }
      else {
         System.out.println("Error, invalid coordinate value.\n");
      }
   }
   
   public static int getlivePieceCount() {
      return livePieceCount;
   }
   public pieceType gettype() {
      return type;
   }
   public boolean getisWhite() {
      return isWhite;
   }
   public boolean getisAlive() {
      return isAlive;
   }
   public char getxPos() {
      return xPos;
   }
   public int getyPos() {
      return yPos;
   }

   public void captured() {
      setisAlive(false);
      --livePieceCount;
   }
   public void move(char xPos, int yPos) {
      setxPos(xPos);
      setyPos(yPos);
   }
   public void move(char xPos) {
      setxPos(xPos);
   }
   public void move(int yPos) {
      setyPos(yPos);
   }

   public void println() {
      if(isAlive) {
         System.out.println(type + " " + isWhite + " " + isAlive + " " + xPos + " " + yPos);
      }
      else {
         System.out.println(type + " " + isWhite + " " + isAlive);
      }
   }
}

class Main {
   public static void main(String[] args) {
      {
         ChessPiece blackPAWN = new ChessPiece(pieceType.PAWN, false, 'a', 2);
         blackPAWN.println();
         blackPAWN.move('a', 3);
         blackPAWN.println();

         ChessPiece whiteROOK = new ChessPiece(pieceType.ROOK, true, 'h', 8);
         whiteROOK.println();
         System.out.println(ChessPiece.getlivePieceCount());
         whiteROOK.captured();
         whiteROOK.println();
         System.out.println(ChessPiece.getlivePieceCount());
      }
      System.out.println(ChessPiece.getlivePieceCount());
   }
}