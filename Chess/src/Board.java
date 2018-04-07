import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {

	private static final long serialVersionUID = 1L;
	final static int SQUARE_WIDTH = 65;
	public final static int SCREEN_WIDTH = 1400;		//width of the JFrame
	public final static int SCREEN_HEIGHT = 750;		//height of the JFrame
	private final int startingLocX = SCREEN_WIDTH / 2 - 4 * SQUARE_WIDTH;
	private final int startingLocY = SCREEN_HEIGHT / 2 - 4 * SQUARE_WIDTH;
	private int pieceSelectedX, pieceSelectedY;
	private int offsetX = 8, offsetY = 28; //weird offsets that came in for no reason
	private boolean whitesMove;

	private Image blackPawn, whitePawn;
	private Image blackKnight,  whiteKnight;
	private Image blackBishop, whiteBishop;
	private Image blackRook, whiteRook;
	private Image blackQueen, whiteQueen;
	private Image blackKing, whiteKing;
	final private String path = "C:\\Users\\phill\\Pictures\\Chess\\";

	final Color lightBrown = new Color(139,69,19);
	final Color mediumBrown = new Color(180, 121, 75);
	final Color darkBrown = new Color(222,184,135);

	Piece [][] board = new Piece [8][8];

	public Board() {

		Piece.init_board(false, board);

		pieceSelectedX = -1;
		pieceSelectedY = -1;

		whitesMove = true;

		for (int i=0; i<2; i ++) {
			Piece.Color color;
			if (i == 1)
				color = Piece.Color.WHITE;
			else
				color = Piece.Color.BLACK;

			//place pawns
			for (int pawns=0; pawns<8; pawns ++) {
				board[pawns][1 + 5 * i] = new Piece(Piece.Type.PAWN, color, 8 + pawns + 40 * i);
			}

			//place queens
			board[3][7 * i] = new Piece(Piece.Type.QUEEN, color, 3 + 56 * i);

			//place kings
			board[4][7 * i] = new Piece(Piece.Type.KING, color, 4 + 56 * i);

			//place rooks
			board[0][7 * i] = new Piece(Piece.Type.ROOK, color, 56 * i);
			board[7][7 * i] = new Piece(Piece.Type.ROOK, color, 7 + 56 * i);

			//place knights
			board[1][7 * i] = new Piece(Piece.Type.KNIGHT, color, 1 + 56 * i);
			board[6][7 * i] = new Piece(Piece.Type.KNIGHT, color, 6 + 56 * i);

			//place bishops
			board[2][7 * i] = new Piece(Piece.Type.BISHOP, color, 2 + 56 * i);
			board[5][7 * i] = new Piece(Piece.Type.BISHOP, color, 5 + 56 * i);
		}

		blackPawn = null;
		try {
			blackPawn = ImageIO.read(new File(path + "blackPawn.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		whitePawn = null;
		try {
			whitePawn = ImageIO.read(new File(path + "whitePawn.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		blackKnight = null;
		try {
			blackKnight = ImageIO.read(new File(path + "blackKnight.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		whiteKnight = null;
		try {
			whiteKnight = ImageIO.read(new File(path + "whiteKnight.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		blackBishop = null;
		try {
			blackBishop = ImageIO.read(new File(path + "blackBishop.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		whiteBishop = null;
		try {
			whiteBishop = ImageIO.read(new File(path + "whiteBishop.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		blackRook = null;
		try {
			blackRook = ImageIO.read(new File(path + "blackRook.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		whiteRook = null;
		try {
			whiteRook = ImageIO.read(new File(path + "whiteRook.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		blackQueen = null;
		try {
			blackQueen = ImageIO.read(new File(path + "blackQueen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		whiteQueen = null;
		try {
			whiteQueen = ImageIO.read(new File(path + "whiteQueen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		blackKing = null;
		try {
			blackKing = ImageIO.read(new File(path + "blackKing.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		whiteKing = null;
		try {
			whiteKing = ImageIO.read(new File(path + "whiteKing.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Board(Board copy) {
		super();
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if (copy.board[i][j] != null)
					this.board[i][j] = new Piece(copy.board[i][j]);
				else
					this.board[i][j] = null;
			}
		}
	}

	@Override 
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(139,69,19));

		//draw the board
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {

				if (pieceSelectedX == i && pieceSelectedY == j)
					g2d.setColor(mediumBrown);
				else if ((i + j) % 2 == 0)
					g2d.setColor(darkBrown);
				else
					g2d.setColor(lightBrown);

				g2d.fillRect(startingLocX + i * SQUARE_WIDTH, startingLocY + j * SQUARE_WIDTH,
						SQUARE_WIDTH, SQUARE_WIDTH);
			}
		}


		//draw the pieces
		for (Piece [] row : board) {
			for (Piece square : row) {
				if (square != null) {
					g2d.drawImage(getPieceImage(square), 1 + startingLocX + square.getX() * SQUARE_WIDTH,
							1 + startingLocY + square.getY() * SQUARE_WIDTH, null);
				}

			}
		}



	}

	Image getPieceImage(Piece piece) {
		Image img = null;
		switch (piece.getName()) {
		case PAWN:
			if (piece.getColor() == Piece.Color.BLACK)
				img = blackPawn;
			else 
				img = whitePawn;
			break;
		case KNIGHT:
			if (piece.getColor() == Piece.Color.BLACK)
				img = blackKnight;
			else 
				img = whiteKnight;
			break;
		case BISHOP:
			if (piece.getColor() == Piece.Color.BLACK)
				img = blackBishop;
			else 
				img = whiteBishop;
			break;
		case ROOK:
			if (piece.getColor() == Piece.Color.BLACK)
				img = blackRook;
			else 
				img = whiteRook;
			break;
		case QUEEN:
			if (piece.getColor() == Piece.Color.BLACK)
				img = blackQueen;
			else 
				img = whiteQueen;
			break;
		case KING:
			if (piece.getColor() == Piece.Color.BLACK)
				img = blackKing;
			else 
				img = whiteKing;
			break;
		}

		return img;

	}

	public void mouseClicked(int x, int y) {
		//check if the mouseEvent is on the board
		if (x >= startingLocX + offsetX  && y >= startingLocY + offsetY && 
				x <= startingLocX + 8 * SQUARE_WIDTH + offsetX && y <= startingLocY + 8 * SQUARE_WIDTH + offsetY) {

			int xVal = (x - startingLocX - offsetX) / SQUARE_WIDTH;
			int yVal = (y - startingLocY - offsetY) / SQUARE_WIDTH;

			if (pieceSelectedX == -1 && board[xVal][yVal] == null)
				return;

			if (pieceSelectedX == xVal && pieceSelectedY == yVal) {
				//deselect piece
				pieceSelectedX = -1;
				pieceSelectedY = -1;
			} else if (pieceSelectedX == -1 || pieceSelectedY == -1) {
				//select piece if it is the correct color
				if (whitesMove && board[xVal][yVal].getColor() == Piece.Color.WHITE || 
						!whitesMove && board[xVal][yVal].getColor() == Piece.Color.BLACK) {
					pieceSelectedX = xVal;
					pieceSelectedY = yVal;
				}
			} else {
				//move piece
				//add line to take the piece at xVal yVal?
				System.out.println("evaluating move");
				if (board[pieceSelectedX][pieceSelectedY].validMove(xVal + 8 * yVal)) {
					if ((whitesMove && board[pieceSelectedX][pieceSelectedY].getColor() == Piece.Color.WHITE) || 
							(!whitesMove && board[pieceSelectedX][pieceSelectedY].getColor() == Piece.Color.BLACK)) {

						board[pieceSelectedX][pieceSelectedY].move(xVal + 8 * yVal);
						whitesMove = !whitesMove;			//change this when adding AI
						System.out.println("valid move");
					}
				}

				pieceSelectedX = -1;
				pieceSelectedY = -1;

			}

		}
	}

	public boolean checkmate() {
		return false;
	}

}
