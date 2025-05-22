package AoC2016;

import common.Day;
import common.Util;

import java.util.HashSet;
import java.util.Objects;

public class Day01 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day01());
  }

  @Override
  public long partOne(String[] input) {
    int x = 0;
    int y = 0;
    enum Facing { NORTH, EAST, SOUTH, WEST }
    Facing facing = Facing.NORTH;

    for (String dir : input[0].split(", ")) {
      switch (facing) {
        case NORTH -> facing = dir.charAt(0) == 'R' ? Facing.EAST : Facing.WEST;
        case EAST -> facing = dir.charAt(0) == 'R' ? Facing.SOUTH : Facing.NORTH;
        case SOUTH -> facing = dir.charAt(0) == 'R' ? Facing.WEST : Facing.EAST;
        case WEST -> facing = dir.charAt(0) == 'R' ? Facing.NORTH : Facing.SOUTH;
      }

    int distance = Integer.parseInt(dir.substring(1));
        switch (facing) {
          case NORTH -> y += distance;
          case EAST -> x += distance;
          case SOUTH -> y -= distance;
          case WEST -> x -= distance;
        }

    }

    return Math.abs(x) + Math.abs(y);
  }

  @Override
  public long partTwo(String[] input) {
    int x = 0;
    int y = 0;
    enum Facing { NORTH, EAST, SOUTH, WEST }
    HashSet<Loc> locs = new HashSet<>();
    locs.add(new Loc(x, y));

    Facing facing = Facing.NORTH;

    for (String dir : input[0].split(", ")) {
      switch (facing) {
        case NORTH -> facing = dir.charAt(0) == 'R' ? Facing.EAST : Facing.WEST;
        case EAST -> facing = dir.charAt(0) == 'R' ? Facing.SOUTH : Facing.NORTH;
        case SOUTH -> facing = dir.charAt(0) == 'R' ? Facing.WEST : Facing.EAST;
        case WEST -> facing = dir.charAt(0) == 'R' ? Facing.NORTH : Facing.SOUTH;
      }

      for (int i = 0; i < Integer.parseInt(dir.substring(1)); i++) {
        switch (facing) {
          case NORTH -> y++;
          case EAST -> x++;
          case SOUTH -> y--;
          case WEST -> x--;
        }
        if (!locs.add(new Loc(x, y))) return Math.abs(x) + Math.abs(y);
      }
    }

    return 0;
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
      if (!(o instanceof Loc loc)) return false;
      return x == loc.x && y == loc.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
