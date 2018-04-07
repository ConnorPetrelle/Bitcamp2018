package bitcamp2018;

import java.util.*;
import java.lang.Object;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;


public class Piece {

	final int SIZE = 8;
	
	public enum Type {
		PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING;
	}

	public enum Color {
		WHITE, BLACK;
	}


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
		this.isRemoved = false;
	}
	
	public static void init_board(Boolean whiteOT, Piece[][] new_board) {
		whiteOnTop=whiteOT;
		board = new_board;
	}
	
	
	public boolean validMovePawn(int to_pos){
		return true;
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

	public Boolean isRemoved() {
		return this.isRemoved;
	}

	public void remove() {
		this.isRemoved = true;
	}

	//all need check for if a space is occupied
	public List<Integer> getMoves() {
		List<Integer> moves = new ArrayList<Integer>();



		switch(this.getName()) {
		case PAWN:
			if ((whiteOnTop && this.color == Color.WHITE)||(!whiteOnTop && this.color == Color.BLACK))
			{
				if(this.getY() == 1)
					moves.add(this.getX()+16);
				moves.add(this.getX()+(8*(this.getY()+1)));
				//need something for checking if there is a possible piece to take for a move
			}
			else
			{
				if(this.getY() == 7)
					moves.add(this.getX()-16);
				moves.add(this.getX()+(8*(this.getY()-11)));
			}
			break;
		case ROOK:
			for(int i = 0; i <= 7; i++)
			{
				if (this.getX() != i)
					moves.add(i+(8*this.getY()));
				if (this.getY() != i)
					moves.add(this.getX()+(8*i));
			}
			break;
		case BISHOP:
			int i= this.getX();
			while(i-- >=0)
			{
				if (this.getX()-i >= 0 && this.getY() - i >= 0)
				{
					moves.add((this.getX()-i)+(8*(this.getY()-i)));
				}
				if (this.getX()+i < 8 && this.getY() - i >= 0)
				{
					moves.add((this.getX()+i)+(8*(this.getY()-i)));
				}
				if (this.getX()-i >= 0 && this.getY() + i < 8)
				{
					moves.add((this.getX()-i)+(8*(this.getY()+i)));
				}
				if (this.getX()+i < 8 && this.getY() + i < 8)
				{
					moves.add((this.getX()+i)+(8*(this.getY()+i)));
				}
			}
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
								{moves.add((this.getX()+x_change)+(8*(this.getY()+y_change)));}
							if(this.getY()-y_change >= 0)
								{moves.add((this.getX()+x_change)+(8*(this.getY()-y_change)));}
						}
						if(this.getX()-x_change >= 0)
						{
							if(y_change+this.getY() < 8)
								{moves.add((this.getX()-x_change)+(8*(this.getY()+y_change)));}
							if(this.getY()-y_change >= 0)
								{moves.add((this.getX()-x_change)+(8*(this.getY()-y_change)));}
						}
					}
				}
			}
			break;
		case QUEEN:
			for(int i = 0; i <= 7; i++)
			{
				if (this.getX() != i)
					moves.add(i+(8*this.getY()));
				if (this.getY() != i)
					moves.add(this.getX()+(8*i));
			}

			i = 1;
			while(i <= 7)
			{
				if (this.getX()-i >= 0 && this.getY() - i >= 0)
				{
					moves.add((this.getX()-i)+(8*(this.getY()-i)));
				}
				if (this.getX()+i < 8 && this.getY() - i >= 0)
				{
					moves.add((this.getX()+i)+(8*(this.getY()-i)));
				}
				if (this.getX()-i >= 0 && this.getY() + i < 8)
				{
					moves.add((this.getX()-i)+(8*(this.getY()+i)));
				}
				if (this.getX()+i < 8 && this.getY() + i < 8)
				{
					moves.add((this.getX()+i)+(8*(this.getY()+i)));
				}
				i++;
			}
			break;
		case KING:
			for(int i= -1; i<=1;i++)
			{
				for(int j= -1; j<=1; j++)
				{
					if(i!=0||j!=0)
					{
						moves.add((this.getX()+i)+(8*(this.getY()+j)));
					}
				}
			}
			break;
		}
		return moves;
	}
	
	public boolean validMove(int newPos)
	{
		if (this.getMoves().contains(newPos))
		{
			return true;
		}
		else
			return false;
	}
	
	public void move(int new_pos)
	{
		if (validMove(new_pos))
			board[new_pos%8][new_pos/8]= this;
	}
	/*
	public void move(int newPosition) {
		if (newPosition > 63 || newPosition < 0 || !ArrayUtils.contains(this.getMoves(), newPosition)) {
			throw new IllegalArgumentException("That is not a valid position to move to")
		}
		else {
			this.position = newPosition;
		}
	}
	 */
	
	public static void main(String[] args) {
		Piece ourQueen = new Piece(Type.QUEEN, Color.WHITE, 63);
		Piece ourKing = new Piece(Type.KING, Color.WHITE, 28);
		List <Integer> list = ourQueen.getMoves();
		List <Integer> kList = ourKing.getMoves();
		Collections.sort(kList);
		System.out.println("King moves:"+kList);
		
		for(int i=0; i<8; i++) {
			System.out.print("[");
			for(int j=0; j<8; j++) {
				System.out.print(i * 8 + j + "\t");
			}
			System.out.println("]\n");
		}
	}
}
