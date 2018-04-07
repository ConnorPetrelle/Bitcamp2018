import java.util.*;
import java.lang.System.out;
import java.lang.Object;
import java.lang.IllegalArgumentException;

final int SIZE = 8;
public class Piece {

  enum Type {
    PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING;
  }

  private String name, color;
  private Boolean is_removed;
  private int x_coord, y_coord;

  public Piece(TYPE name, String color, int pos) {

    if(x < 0 || x > 7 || y < 0 || y > 7) {
      throw new IllegalArgumentException("invalid coordinates");
    }

    this.name = name;
    this.color = color;
    this.position = pos;
    this.is_removed = false;

    public int getX() {
      return this.position % SIZE;
    }

    public int getY() {
      return this.position / SIZE;
    }

    public int getPos() {
      return this.position;
    }

    public String getName() {
      return this.name;
    }

    public Boolean isPresent() {
      return !this.is_removed
    }

  }

  public void remove() {
    this.is_removed = true;
  }

  public int[] get_moves() {

  }

  public void move(int new_position) {
    if (new_position > 63 || new_position < 0 || !ArrayUtils.contains(this.get_moves(), new_position)) {
      throw new IllegalArgumentException("That is not a valid position")
    }
    else  {
      this.position = new_position
    }
  }


  public static void main(String[] args) {
    System.out.println("Hello world");
  }
