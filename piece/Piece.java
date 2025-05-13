package chess.piece;

import chess.exceptions.OutOfBoundsException;
import chess.main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece implements Movable{
   protected BufferedImage image;
   protected final boolean isWhite;
   protected boolean isAlive = true;
   protected int col, row;
   protected int preCol, preRow;
   protected int x, y;

   public Piece(boolean isWhite, int col, int row) {
      this.isWhite = isWhite;
      this.col = col;
      this.row = row;
      setX(col * Board.SQUARE_SIZE);
      setY(row * Board.SQUARE_SIZE);
      setIsAlive(true);
   }

   public BufferedImage getImage(String imagePath) {
      BufferedImage image = null;

      try {
         image = ImageIO.read(getClass().getResourceAsStream(imagePath));
      } catch(IOException e) {
         e.printStackTrace();
      }
      return image;
   }

   public void draw(Graphics2D g2) {
      g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
   }

   protected final void setIsAlive(boolean isAlive) {
      this.isAlive = isAlive;
   }

   public void setCol(int col) { this.col = col; }
   public void setRow(int row) { this.row = row; }

   public void setX(int x) { this.x = x; }
   public void setY(int y) { this.y = y; }

   public void updatePosition() {
      this.x = getCol() * Board.SQUARE_SIZE;
      this.y = getRow() * Board.SQUARE_SIZE;
      preCol = getColCenter(x);
      preRow = getRowCenter(y);
   }

   public int getX() { return x; }
   public int getY() { return y; }

   public int getCol() { return col; }
   public int getRow() { return row; }

   public int getPreCol() { return preCol; }
   public int getPreRow() { return preRow; }

   public int getColCenter(int x) { return (x + Board.HALF_SQUARE_SIZE) / Board.SQUARE_SIZE; }
   public int getRowCenter(int y) { return (y + Board.HALF_SQUARE_SIZE) / Board.SQUARE_SIZE; }

   public abstract String getType();

   public boolean getIsWhite() { return isWhite; }
   public boolean getIsAlive() { return isAlive; }

   public abstract boolean isValidMove(int targetX, int targetY);

   public void move(int targetX, int targetY) throws OutOfBoundsException {
      if(!isInBounds(targetX, targetY)) {
         throw new OutOfBoundsException("Error. OutOfBoundsException: Piece can't go out of bounds.", this, targetX, targetY);
      }
//      if(isValidMove(targetX, targetY)) {
//         updatePosition(targetX, targetY);
//      }
   }

   public boolean isInBounds(int targetX, int targetY) {
       return targetX >= 1 && targetX <= 8 && targetY >= 1 && targetY <= 8;
   }
   
   public void captured() {
      setIsAlive(false);
   }

   public abstract String toString();
}