package chess.piece;

import chess.exceptions.OutOfBoundsException;

public interface Movable extends Positionable {

   void move(int targetX, int targetY) throws OutOfBoundsException;

   boolean isInBounds(int targetX, int targetY);

   boolean isValidMove(int targetX, int targetY);
}