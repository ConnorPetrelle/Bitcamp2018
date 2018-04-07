<<<<<<< HEAD
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

=======
import java.util.*


pulic boolean isValid(int new_x, int new_y)
{
  if (this.name.equals("Rook"))
  {
    if (new_x < 0 || new_x > 7 || new_y < 0 || new_y > 7)
      return false;
    else if (this.x==new_x && this.y!=new_y)
      return true;
    else if (this.x!=new_x && this.y==new_y)
      return true;
    else
      return false;
  }
  else if (this.name.equals("Pawn"))
  {
    if (new_x < 0 || new_x > 7 || new_y < 0 || new_y > 7)
      return false;
  }
  else if (this.name.equals("Bishop"))
  {
    if (new_x < 0 || new_x > 7 || new_y < 0 || new_y > 7)
      return false;
  }
  else if (this.name.equals("Queen"))
  {
    if (new_x < 0 || new_x > 7 || new_y < 0 || new_y > 7)
      return false;
  }
  else if (this.name.equals("King"))
  {
    if (new_x < 0 || new_x > 7 || new_y < 0 || new_y > 7)
      return false;
  }
  else if (this.name.equals("Knight"))
  {
    if (new_x < 0 || new_x > 7 || new_y < 0 || new_y > 7)
      return false;
  }
}

public void move(int new_x, int new_y)
{
  if isValid(new_x, new_y)
  {
    this.x = new_x;
    this.y = new_y;
  }
>>>>>>> cfbf4529cb99ed2a7b3701869f1596d2c6be2249
}
