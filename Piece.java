import java.util.*;
import java.lang.System.out;
import java.lang.Object;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;

final int SIZE = 8;
public class Piece {


  public enum Type {
    PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING;
  }

  public enum Color {
    WHITE, BLACK;
  }


  private Type name;
  private Color color;
  private Boolean is_removed;
  private int position;
  private Boolean whiteOnTop;

  public Piece(Type name, Color color, int pos) {

    if(x < 0 || x > 7 || y < 0 || y > 7) {
      throw new IllegalArgumentException("invalid coordinates");
    }

    this.name = name;
    this.color = color;
    this.position = pos;
    this.isRemoved = false;

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

    public Type getName() {
      return this.name;
    }

    public Boolean isRemoved() {
      return this.isRemoved
    }

    public Color getColor() {
      return this.color;
    }

  }

  public void remove() {
    this.is_removed = true;
  }
  //all need check for if a space is occupied
  public List<Integer> getMoves() {
    List<Integer> moves = new ArrayList<Integer>();
    switch(this.getName) {
      Case PAWN:
        break;
      Case ROOK:
        for(int i = 0; i <= 7; i++)
        {
          if (this.getX() != i)
            moves.push(i+(8*this.getY()));
          if (this.getY() != i)
            moves.push(this.getX()+(8*i));
        }
        break;
      Case BISHOP:
        for(int i= 1; i < 7; i++)
        {
          if (this.getX()-i >= 0 && this.getY() - i >= 0)
            {
              moves.push((this.getX()-i)+(8*(this.getY()-i)));
            }
          if (this.getX()+i < 8 && this.getY() - i >= 0)
            {
              moves.push((this.getX()+i)+(8*(this.getY()-i)));
            }
          if (this.getX()-i >= 0 && this.getY() + i < 8)
            {
              moves.push((this.getX()-i)+(8*(this.getY()+i)));
            }
          if (this.getX()+i < 8 && this.getY() + i < 8)
            {
              moves.push((this.getX()+i)+(8*(this.getY()+i)));
            }
        }
        break;
      Case KNIGHT:
        break;
      Case QUEEN:
        for(int i = 0; i <= 7; i++)
        {
          if (this.getX() != i)
            moves.push(i+(8*this.getY()));
          if (this.getY() != i)
            moves.push(this.getX()+(8*i));
        }

        for(int i= 1; i < 7; i++)
        {
          if (this.getX()-i >= 0 && this.getY() - i >= 0)
            {
              moves.push((this.getX()-i)+(8*(this.getY()-i)));
            }
          if (this.getX()+i < 8 && this.getY() - i >= 0)
            {
              moves.push((this.getX()+i)+(8*(this.getY()-i)));
            }
          if (this.getX()-i >= 0 && this.getY() + i < 8)
            {
              moves.push((this.getX()-i)+(8*(this.getY()+i)));
            }
          if (this.getX()+i < 8 && this.getY() + i < 8)
            {
              moves.push((this.getX()+i)+(8*(this.getY()+i)));
            }
        }
        break;
      Case KING:

        break;
    }
    return moves;
  }

  public void move(int new_position) {
    if (new_position > 63 || new_position < 0 || !ArrayUtils.contains(this.get_moves(), new_position)) {
      throw new IllegalArgumentException("That is not a valid position to move to")
    }
    else {
      this.position = new_position;
    }
  }

  public static void main(String[] args) {
    Piece ourQueen = new Piece(QUEEN, WHITE, 28)
  }
