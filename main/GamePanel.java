package chess.main;

import chess.piece.*;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable{
   
   public static final int WIDTH = 800;
   public static final int HEIGHT = 800;
   final int FPS = 60;
   Thread gameThread;
   Board board = new Board();
   Mouse mouse = new Mouse();
   boolean isCurrentColorWhite = true;

   // Pieces
   public static ArrayList<Piece> pieces = new ArrayList<>();
   public static ArrayList<Piece> simPieces = new ArrayList<>();
   Piece activePiece;

   public GamePanel() {
      setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
      setBackground(Color.black);
      addMouseMotionListener(mouse);
      addMouseListener(mouse);

      setPieces();
      copyPieces(pieces, simPieces);
   }

   public void launchGame() {
      gameThread = new Thread(this);
      gameThread.start(); // Calls `run` method
   }

   public void setPieces() {
      // White pieces
      pieces.add(new Pawn(true, 0, 6));
      pieces.add(new Pawn(true, 1, 6));
      pieces.add(new Pawn(true, 2, 6));
      pieces.add(new Pawn(true, 3, 6));
      pieces.add(new Pawn(true, 4, 6));
      pieces.add(new Pawn(true, 5, 6));
      pieces.add(new Pawn(true, 6, 6));
      pieces.add(new Pawn(true, 7, 6));
      pieces.add(new Rook(true, 0, 7));
      pieces.add(new Rook(true, 7, 7));
      pieces.add(new Knight(true, 1, 7));
      pieces.add(new Knight(true, 6, 7));
      pieces.add(new Bishop(true, 2, 7));
      pieces.add(new Bishop(true, 5, 7));
      pieces.add(new Queen(true, 3, 7));
      pieces.add(new King(true, 4, 7));

      // Black pieces
      pieces.add(new Pawn(false, 0, 1));
      pieces.add(new Pawn(false, 1, 1));
      pieces.add(new Pawn(false, 2, 1));
      pieces.add(new Pawn(false, 3, 1));
      pieces.add(new Pawn(false, 4, 1));
      pieces.add(new Pawn(false, 5, 1));
      pieces.add(new Pawn(false, 6, 1));
      pieces.add(new Pawn(false, 7, 1));
      pieces.add(new Rook(false, 0, 0));
      pieces.add(new Rook(false, 7, 0));
      pieces.add(new Knight(false, 1, 0));
      pieces.add(new Knight(false, 6, 0));
      pieces.add(new Bishop(false, 2, 0));
      pieces.add(new Bishop(false, 5, 0));
      pieces.add(new Queen(false, 3, 0));
      pieces.add(new King(false, 4, 0));
   }

   private void copyPieces(ArrayList<Piece> source, ArrayList<Piece> target) {
      target.clear();
      for (Piece piece : source) {
         target.add(piece);
      }
   }

   private void update() {
      if(mouse.pressed) { // Mouse button pressed
         if(activePiece == null) { // If there is no active piece, check whether it is possible to pick up piece
            for(Piece piece : simPieces) {
               if(piece.getIsWhite() == isCurrentColorWhite &&
               piece.getCol() == mouse.x/Board.SQUARE_SIZE &&
               piece.getRow() == mouse.y/Board.SQUARE_SIZE) { // If mouse is alligned with cell in which a piece resides, it can be picked up
                  activePiece = piece;
               }
            }
         }
         else {
            simulate();
         }
      }
      if(!mouse.pressed) {
         if(activePiece != null) {
            activePiece.updatePosition();
            changePlayer();
            activePiece = null;
         }
      }
   }

   private void simulate() {
      activePiece.setX(mouse.x - Board.HALF_SQUARE_SIZE);
      activePiece.setY(mouse.y - Board.HALF_SQUARE_SIZE);
      activePiece.setCol(activePiece.getColCenter(activePiece.getX()));
      activePiece.setRow(activePiece.getRowCenter(activePiece.getY()));
   }

   private void changePlayer() {
      isCurrentColorWhite = !isCurrentColorWhite;
      activePiece = null;
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;

      board.draw(g2);

      for(Piece piece : simPieces) {
         piece.draw(g2);
      }

      if(activePiece != null) {
         g2.setColor(Color.white);
         g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
         g2.fillRect(activePiece.getCol() * Board.SQUARE_SIZE, activePiece.getRow() * Board.SQUARE_SIZE, Board.SQUARE_SIZE, Board.SQUARE_SIZE);
         g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
         activePiece.draw(g2);
      }
   }
   @Override
   public void run() { // GAME LOOP
      double drawInterval = 1000000000 / FPS; // Second (in nanoseconds) / FPS
      double delta = 0;
      long lastTime = System.nanoTime();
      long currentTime;

      while(gameThread != null) {
         currentTime = System.nanoTime();
         delta += (currentTime - lastTime) / drawInterval;
         lastTime = currentTime;

         if(delta >= 1) {
            update();
            repaint();
            delta--;
         }
      }
   }

}
