package common;

import java.util.Objects;

public class Loc implements Comparable<Loc> {
  final int x;
  final int y;

  public Loc(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public double distanceTo(Loc other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }

  public int manhattanDistanceTo(Loc other) {
    return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Loc loc)) return false;
    return x == loc.x && y == loc.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }


  @Override
  public int compareTo(Loc o) {
    if (this.x != o.x) {
      return Integer.compare(this.x, o.x);
    }
    return Integer.compare(this.y, o.y);
  }
}
