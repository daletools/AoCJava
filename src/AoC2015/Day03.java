package AoC2015;

import common.Day;
import common.Util;

import java.util.HashSet;

public class Day03 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day03());
  }

  @Override
  public long partOne(String[] input) {
    HashSet<Loc> locSet = new HashSet<>();
    int x = 0;
    int y = 0;

    for (char c : input[0].toCharArray()) {
      switch (c) {
        case '^' -> y++;
        case '>' -> x++;
        case '<' -> x--;
        case 'v' -> y--;
      }
      locSet.add(new Loc(x, y));
    }

    return locSet.size();
  }

  @Override
  public long partTwo(String[] input) {
    HashSet<Loc> locSet = new HashSet<>();
    int x = 0;
    int x2 = 0;
    int y = 0;
    int y2 = 0;

    for (int i = 0; i < input[0].length(); i++) {
      switch (input[0].charAt(i)) {
        case '^' -> {
          if (i % 2 == 0) {
            y++;
          } else {
            y2++;
          }
        }
        case '>' -> {
          if (i % 2 == 0) {
            x++;
          } else {
            x2++;
          }
        }
        case '<' -> {
          if (i % 2 == 0) {
            x--;
          } else {
            x2--;
          }
        }
        case 'v' -> {
          if (i % 2 == 0) {
            y--;
          } else {
            y2--;
          }
        }
      }
      if (i % 2 == 0) {
        locSet.add(new Loc(x, y));
      } else {
        locSet.add(new Loc(x2, y2));
      }
    }
    return locSet.size();
  }

  static class Loc {
    int x;
    int y;
    Loc(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof Loc) {
        return ((Loc) o).x == this.x && ((Loc) o).y == this.y;
      }
      return false;
    }

    @Override
    public int hashCode() {
      return x ^ y;
    }
  }
}
