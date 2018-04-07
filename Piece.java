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

  public Piece(Type name, String color, int pos) {

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

    public Type getName() {
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
<<<<<<< HEAD
      
=======
    switch(this.getName) {
      Case PAWN:
        break;
      Case KNIGHT:
        break;
      Case ROOK:
        break;
      Case BISHOP:
        break;
      Case KNIGHT:
        break;
      Case QUEEN:
        break;
      Case KING:
        break;
    }
>>>>>>> 57a23a847c8eeaf8b750561bcdb18e1d42bffb30
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
    System.out.println("Hello world");
  }
