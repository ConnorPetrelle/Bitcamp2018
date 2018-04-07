import java.lang.System.out;
import java.lang.IllegalArgumentException;

public class Piece {


  enum Type {
    PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING;
  }

  private String name, color;
  private Boolean is_removed;
  private int x_coord, y_coord;

  public Piece(TYPE name, String color, int x, int y) {

    if(x < 0 || x > 7 || y < 0 || y > 7) {
      throw new IllegalArgumentException("invalid coordinates");
    }

    this.name = ;
    this.color = color;
    this.x_coord = x;
    this.y_coord = y;
    this.is_removed = false;

    public int getXCoord() {
      return this.x_coord;
    }

    public int getYCoord() {
      return this.y_coord;
    }

    public String getName() {
      return this.name;
    }

  }

  public void remove() {
    is_removed = true;
  }

  public

  public static void main(String[] args) {
    System.out.println("Hello world");
  }

}
