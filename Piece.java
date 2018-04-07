import java.util.*;
import java.lang.System.out;
import java.lang.Object;
import java.lang.IllegalArgumentException;

final int SIZE = 8;
public class Piece {


  enum Type {
    PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING;
  }

  enum Color {
    WHITE, BLACK;
  }

  private Type name;
  private Color color;
  private Boolean is_removed;
  private int position;

  public Piece(Type name, Color color, int pos) {

    if(x < 0 || x > 7 || y < 0 || y > 7) {
      throw new IllegalArgumentException("invalid coordinates");
    }

    this.name = name;
    this.color = color;
    this.position = pos;
    this.isRemoved = false;

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

  public int[] getMoves() {
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
  }

  public void move(int newPosition) {
    if (newPosition > 63 || newPosition < 0 || !ArrayUtils.contains(this.getMoves(), newPosition)) {
      throw new IllegalArgumentException("That is not a valid position to move to")
    }
    else {
      this.position = newPosition;
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello world");
  }
