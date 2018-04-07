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

<<<<<<< HEAD
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
    for (int i = 0; i == 7; i++)
    {
      //need a surrounding check for if piece in the way somehow
      if(this.x+i == new_x && this.y+i == new_y)
        return true;
      if(this.x-i == new_x && this.y+i == new_y)
        return true;
      if(this.x-i == new_x && this.y-i == new_y)
        return true;
      if(this.x+i == new_x && this.y-i == new_y)
        return true;
    }
    return false
  }
  else if (this.name.equals("Queen"))
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
  else if (this.name.equals("King"))
  {
    if (new_x < 0 || new_x > 7 || new_y < 0 || new_y > 7)
      return false;
  }
  else if (this.name.equals("Knight"))
  {
    if (new_x < 0 || new_x > 7 || new_y < 0 || new_y > 7)
      return false;
=======
  public void move(int new_position) {
    if (new_position > 63 || new_position < 0 || !ArrayUtils.contains(this.get_moves(), new_position)) {
      throw new IllegalArgumentException("That is not a valid position")
    }
    else  {
      this.position = new_position
    }
>>>>>>> 1a09b8b070709b52e73820188da66f13599690e7
  }


  public static void main(String[] args) {
    System.out.println("Hello world");
  }
