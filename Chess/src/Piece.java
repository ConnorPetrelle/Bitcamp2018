
import java.util.*;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Scanner;

public class Piece {

	final int SIZE = 8;
	public enum Type {
		PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING;
	}

	public enum Color {
		WHITE, BLACK;
	}

	Scanner sc = new Scanner(System.in);
	private Type name;
	private Color color;
	private Boolean isRemoved;
	private int position;
	public static Boolean whiteOnTop;
	public static Piece[][] board;

	public Piece(Type name, Color color, int pos) {
		int x = pos % 8;
		int y = pos / 8;
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			throw new IllegalArgumentException("invalid coordinates");
		}

		this.name = name;
		this.color = color;
		this.position = pos;
	}

	public Piece(Piece piece) {
		// TODO Auto-generated constructor stub
		this.color = piece.color;
		this.position = piece.position;
		this.name = piece.name;
	}

	public static void init_board(Boolean whiteOT, Piece[][] new_board) {
		whiteOnTop=whiteOT;
		board = new_board;
	}

	public Type getName() {
		return this.name;
	}

	public Color getColor() {
		return this.color;
	}

	public int getX() {
		return this.position % SIZE;
	}

	public int getY() {
		return this.position / SIZE;
	}

	public int getPosition() {
		return this.position;
	}

	//all need check for if a space is occupied
	public List<Integer> getMoves() {
		List<Integer> moves = new ArrayList<Integer>();
		int i;
		switch(this.getName()) {
		case PAWN:
			if (((whiteOnTop && this.color == Color.WHITE)||(!whiteOnTop && this.color == Color.BLACK)))
			{
				if(this.getY() == 1)
					moves.add(this.getX()+24);
				if((this.getY() +1 < 8) && board[this.getX()][this.getY()+1]==null)
					moves.add(this.getX()+(8*(this.getY()+1)));
				
				if(this.getX()-1 >= 0 && this.getY() +1 < 8){ 
					if((board[this.getX()-1][this.getY()+1] != null) && board[this.getX()-1][this.getY()+1].getColor()!=this.getColor()){
						moves.add(this.getX()-1+(8*(this.getY()+1)));
					}
				}
				
				if(this.getX()+1 >= 0 && this.getY() +1 < 8){ 
					if((board[this.getX()+1][this.getY()+1] != null) && board[this.getX()+1][this.getY()+1].getColor()!=this.getColor()){
						moves.add(this.getX()+1+(8*(this.getY()+1)));
					}
				}
				
			}
			else
			{
				if(this.getY() == 6)
					moves.add(this.getX()+32);
				if((this.getY() -1 >= 0) && board[this.getX()][this.getY()-1]==null)
					moves.add(this.getX()+(8*(this.getY()-1)));
				
				if(this.getX()-1 >= 0 && this.getY() -1 >= 0){ 
					if((board[this.getX()-1][this.getY()-1] != null) && board[this.getX()-1][this.getY()-1].getColor()!=this.getColor()){
						moves.add(this.getX()-1+(8*(this.getY()-1)));
					}
				}
				if(this.getX()+1 >= 0 && this.getY() -1 >= 0){ 
					if((board[this.getX()+1][this.getY()-1] != null) && board[this.getX()+1][this.getY()-1].getColor()!=this.getColor()){
						moves.add(this.getX()+1+(8*(this.getY()-1)));
					}
				}
			}
			break;
		case ROOK:
			//Get horizontal moves
			i = this.getX();

			while( ++i < SIZE && (board[i][this.getY()] == null))
				moves.add(i + (SIZE * this.getY()));

			if(i < SIZE && board[i][this.getY()].getColor() != this.getColor())
				moves.add(i + SIZE * this.getY());

			i = this.getX();

			while( --i >= 0 && (board[i][this.getY()] == null))
				moves.add(i + SIZE * this.getY());

			if(i >= 0 && board[i][this.getY()].getColor() != this.getColor())
				moves.add(i + SIZE *this.getY());

			//Get vertical moves
			i = this.getY();

			while(++i < SIZE && (board[this.getX()][i]) == null)
				moves.add(i * SIZE + this.getX());

			if(i < SIZE && board[this.getX()][i].getColor() != this.getColor())
				moves.add(i * SIZE + this.getX());

			i = this.getY();

			while(--i >= 0 && (board[this.getX()][i]) == null)
				moves.add(i * SIZE + this.getX());

			if(i >= 0 && board[this.getX()][i].getColor() != this.getColor())
				moves.add((i * SIZE)  + this.getX());
			break;
		case BISHOP:
			i = 0;
			
			while((this.getX() + ++i) < SIZE && i + this.getY() < SIZE && (board[this.getX() + i][this.getY() + i] == null))
				moves.add(this.getX() + i + SIZE * (this.getY() + i));
			
			if((this.getX() + i) < SIZE && i + this.getY() < SIZE && board[this.getX() + i][this.getY() + i].getColor() != this.getColor())
				moves.add(this.getX() + i + SIZE * (this.getY() + i));
			
			i = 0;
			
			while((this.getX() + ++i) < SIZE && this.getY() - i >= 0 && (board[this.getX() + i][this.getY() - i] == null))
				moves.add(this.getX() + i + SIZE * (this.getY() - i));
			
			if((this.getX() + i) < SIZE && this.getY() - i >= 0 && board[this.getX() + i][this.getY() - i].getColor() != this.getColor())
				moves.add(this.getX() + i + SIZE * (this.getY()- i));
			
			i = 0;
			
			while((this.getX() - ++i) >= 0 && (i + this.getY()) < SIZE && (board[this.getX() - i][this.getY() + i] == null))
				moves.add(this.getX() - i + SIZE * (this.getY() + i));
			
			if((this.getX() - i) >= 0 && (i + this.getY()) < SIZE && board[this.getX() - i][this.getY() + i].getColor() != this.getColor())
				moves.add(this.getX() - i + SIZE * (this.getY() + i));
			
			i = 0;
			
			while(this.getX() - ++i >= 0 && this.getY() - i >= 0 && (board[this.getX() - i][this.getY() - i] == null))
				moves.add(this.getX() - i + SIZE * (this.getY() - i));
			
			if((this.getX() - i) >= 0 && this.getY() - i >= 0 && board[this.getX() - i][this.getY() - i].getColor() != this.getColor())
				moves.add(this.getX() - i + SIZE * (this.getY() - i));

			break;
		case KNIGHT:
			for(int x_change=1; x_change <= 2; x_change++)
			{
				for(int y_change=1; y_change <= 2; y_change++)
				{
					if(x_change!=y_change)
					{
						if(x_change+this.getX() < 8)
						{
							if(y_change+this.getY() < 8)
							{
								if((board[this.getX()+x_change][this.getY()+y_change]==null) || board[this.getX()+x_change][this.getY()+y_change].getColor() != this.getColor())
									moves.add((this.getX()+x_change)+(8*(this.getY()+y_change)));
							}
							
							if(this.getY()-y_change >= 0)
							{
								if((board[this.getX()+x_change][this.getY()-y_change]==null) || board[this.getX()+x_change][this.getY()-y_change].getColor() != this.getColor())
									moves.add((this.getX()+x_change)+(8*(this.getY()-y_change)));
							}
						}
						
						if(this.getX()-x_change >= 0)
						{
							if(y_change+this.getY() < 8)
							{
								if((board[this.getX()-x_change][this.getY()+y_change]==null) || board[this.getX()-x_change][this.getY()+y_change].getColor() != this.getColor())
									moves.add((this.getX()-x_change)+(8*(this.getY()+y_change)));
							}
							
							if(this.getY()-y_change >= 0)
							{
								if((board[this.getX()-x_change][this.getY()-y_change]==null) || board[this.getX()-x_change][this.getY()-y_change].getColor() != this.getColor())
									moves.add((this.getX()-x_change)+(8*(this.getY()-y_change)));
							}
						}
					}
				}
			}
			break;
		case QUEEN:
			i = this.getX();

			while( ++i < SIZE && (board[i][this.getY()] == null))
				moves.add(i + (SIZE * this.getY()));

			if(i < SIZE && board[i][this.getY()].getColor() != this.getColor())
				moves.add(i + SIZE * this.getY());

			i = this.getX();

			while( --i >= 0 && (board[i][this.getY()] == null))
				moves.add(i + SIZE * this.getY());

			if(i >= 0 && board[i][this.getY()].getColor() != this.getColor())
				moves.add(i + SIZE *this.getY());

			//Get vertical moves
			i = this.getY();

			while(++i < SIZE && (board[this.getX()][i]) == null)
				moves.add(i * SIZE + this.getX());

			if(i < SIZE && board[this.getX()][i].getColor() != this.getColor())
				moves.add(i * SIZE + this.getX());

			i = this.getY();

			while(--i >= 0 && (board[this.getX()][i]) == null)
				moves.add(i * SIZE + this.getX());

			if(i >= 0 && board[this.getX()][i].getColor() != this.getColor())
				moves.add((i * SIZE)  + this.getX());
			//Diagonal moves
			i = 0;
			
			while((this.getX() + ++i) < SIZE && i + this.getY() < SIZE && (board[this.getX() + i][this.getY() + i] == null))
				moves.add(this.getX() + i + SIZE * (this.getY() + i));
			
			if((this.getX() + i) < SIZE && i + this.getY() < SIZE && board[this.getX() + i][this.getY() + i].getColor() != this.getColor())
				moves.add(this.getX() + i + SIZE * (this.getY() + i));
			
			i = 0;
			
			while((this.getX() + ++i) < SIZE && this.getY() - i >= 0 && (board[this.getX() + i][this.getY() - i] == null))
				moves.add(this.getX() + i + SIZE * (this.getY() - i));
			
			if((this.getX() + i) < SIZE && this.getY() - i >= 0 && board[this.getX() + i][this.getY() - i].getColor() != this.getColor())
				moves.add(this.getX() + i + SIZE * (this.getY()- i));
			
			i = 0;
			
			while((this.getX() - ++i) >= 0 && (i + this.getY()) < SIZE && (board[this.getX() - i][this.getY() + i] == null))
				moves.add(this.getX() - i + SIZE * (this.getY() + i));
			
			if((this.getX() - i) >= 0 && (i + this.getY()) < SIZE && board[this.getX() - i][this.getY() + i].getColor() != this.getColor())
				moves.add(this.getX() - i + SIZE * (this.getY() + i));
			
			i = 0;
			
			while(this.getX() - ++i >= 0 && this.getY() - i >= 0 && (board[this.getX() - i][this.getY() - i] == null))
				moves.add(this.getX() - i + SIZE * (this.getY() - i));
			
			if((this.getX() - i) >= 0 && this.getY() - i >= 0 && board[this.getX() - i][this.getY() - i].getColor() != this.getColor())
				moves.add(this.getX() - i + SIZE * (this.getY() - i));

			break;
		case KING:
			for(i= -1; i<=1;i++)
			{
				for(int j= -1; j<=1; j++)
				{
					if(i!=0||j!=0)
					{
						if ((this.getX() +  i < 8 && this.getY() +j < 8) && (this.getX() +  i >= 0 && this.getY() +j >= 0) )
							if ((board[this.getX()+i][(this.getY()+j)] == null)||(board[this.getX()+i][(this.getY()+j)].getColor()!=this.getColor()))
								moves.add((this.getX()+i)+(8*(this.getY()+j)));
					}
				}
			}
			break;
		}
		return moves;
	}

	public boolean validMove(int newPos) {
		if (this.getMoves().contains(newPos))
		{
			return true;
		}
		else
			return false;
	}

	public void move(int new_pos) {
		if (validMove(new_pos)) {
			board[new_pos%8][new_pos/8]= this;
			board[this.getX()][this.getY()] = null;
			this.position = new_pos;
		}
		if(this.getName()==Type.PAWN)
		{
			if (((whiteOnTop && this.color == Color.WHITE)||(!whiteOnTop && this.color == Color.BLACK)))
			{
				if(this.getY()==7)
				{
					System.out.println("Please enter a number: 1 = Queen, 2 = Rook, 3 = Bishop, 4 = Knight");
					int newPiece= sc.nextInt();
					if (newPiece==1)
						this.name=Type.QUEEN;
					else if (newPiece==2)
						this.name=Type.ROOK;
					else if (newPiece==3)
						this.name=Type.BISHOP;
					else if (newPiece==4)
						this.name=Type.KNIGHT;
				}
			}
			else
			{
				if(this.getY()==0)
				{
					System.out.println("Please enter a number: 1 = Queen, 2 = Rook, 3 = Bishop, 4 = Knight");
					int newPiece= sc.nextInt();
					if (newPiece==1)
						this.name=Type.QUEEN;
					else if (newPiece==2)
						this.name=Type.ROOK;
					else if (newPiece==3)
						this.name=Type.BISHOP;
					else if (newPiece==4)
						this.name=Type.KNIGHT;
				}
			}
		}
	}

	public static void main(String[] args) {

		init_board(true, new Piece[8][8]);
		Piece ourQueen = new Piece(Type.QUEEN, Color.WHITE, 28);
		Piece ourKnight = new Piece(Type.KING, Color.WHITE, 28);
		Piece ourRook = new Piece(Type.ROOK, Color.WHITE, 28);

		Piece additionalRook = new Piece(Type.ROOK, Color.WHITE, 20);
		List <Integer> rookList = ourRook.getMoves();
		List <Integer> list = ourQueen.getMoves();
		List <Integer> kList = ourKnight.getMoves();
		Collections.sort(kList);
		System.out.println("Knight moves:"+kList);
		System.out.println("Rook moves: " + rookList);

		for(int i=0; i<8; i++) {
			System.out.print("[");
			for(int j=0; j<8; j++) {
				System.out.print(i * 8 + j + "\t");
			}
			System.out.println("]\n");
		}

		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.println(board[i][j]);
			}
		}
		System.out.println(board);
	}
}
