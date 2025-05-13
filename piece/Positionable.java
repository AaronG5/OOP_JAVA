package chess.piece;

public interface Positionable {

   void updatePosition();

   void setX(int col);
   void setY(int row);
}