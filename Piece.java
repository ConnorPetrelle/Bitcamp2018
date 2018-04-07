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
  }
}

public void move(int new_x, int new_y)
{
  if isValid(new_x, new_y)
  {
    this.x = new_x;
    this.y = new_y;
  }
}
