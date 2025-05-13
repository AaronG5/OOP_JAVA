package chess.exceptions;

import chess.piece.Piece;

public class OutOfBoundsException extends IllegalMoveException {
   Piece piece;
   int xPos;
   int yPos;
   public OutOfBoundsException(String errorMessage) {
      super(errorMessage);
   }
   public OutOfBoundsException(String errorMessage, Piece piece, int xPos, int yPos) {
      super(errorMessage);
      this.piece = piece;
      this.xPos = xPos;
      this.yPos = yPos;
   }
   public String getInfo() { return piece.getType() + " " + xPos + " " + yPos; }
   public String getPieceType() { return piece.getType(); }
   public int getTargetxPos() { return xPos; }
   public int getTargetYPos() { return yPos; }
}
