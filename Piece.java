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
	private Boolean whiteOnTop;

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
			for(int i= 1; i <= 7; i++)
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
			break;
		case QUEEN:
			for(int i = 0; i <= 7; i++)
			{
				if (this.getX() != i)
					moves.add(i+(8*this.getY()));
				if (this.getY() != i)
					moves.add(this.getX()+(8*i));
			}

			for(int i= 1; i <= 7; i++)
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
		case KING:

			break;
		}
		return moves;
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
		List <Integer> list = ourQueen.getMoves();
		Collections.sort(list);
		System.out.println(list);
		
		for(int i=0; i<8; i++) {
			System.out.print("[");
			for(int j=0; j<8; j++) {
				System.out.print(i * 8 + j + "\t");
			}
			System.out.println("]\n");
		}
	}
}
