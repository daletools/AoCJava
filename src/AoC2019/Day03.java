package AoC2019;

import common.Day;
import common.Loc;
import common.Util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Day03 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day03());
  }

  @Override
  public long partOne(String[] input) {
    TreeSet<Loc> wireOne = new TreeSet<>();
    TreeSet<Loc> wireTwo = new TreeSet<>();
    Loc origin = new Loc(0, 0);

    traceWire(wireOne, input[0]);
    traceWire(wireTwo, input[1]);

    int closestIntersection = Integer.MAX_VALUE;
    wireOne.retainAll(wireTwo);

    for (Loc loc : wireOne) {
      closestIntersection = Math.min(loc.manhattanDistanceTo(origin), closestIntersection);
    }

    return closestIntersection;
  }

  void traceWire(TreeSet<Loc> trace, String input) {
    int x = 0;
    int y = 0;

    for (String wire : input.split(",")) {
      char direction = wire.charAt(0);
      int distance = Integer.parseInt(wire.substring(1));

      for (int i = 0; i < distance; i++) {
        switch (direction) {
          case 'L' -> x--;
          case 'R' -> x++;
          case 'U' -> y++;
          case 'D' -> y--;
        }
        trace.add(new Loc(x, y));
      }

    }
  }

  @Override
  public long partTwo(String[] input) {
    HashMap<Loc, Integer> wireOne = new HashMap<>();
    HashMap<Loc, Integer> wireTwo = new HashMap<>();

    traceSteps(wireOne, input[0]);
    traceSteps(wireTwo, input[1]);

    int minSteps = Integer.MAX_VALUE;

    for (Loc loc : wireOne.keySet()) {
      if (wireTwo.containsKey(loc)) {
        minSteps = Math.min(minSteps, wireOne.get(loc) + wireTwo.get(loc));
      }
    }

    return minSteps;
  }

  void traceSteps(HashMap<Loc, Integer> trace, String input) {
    int x = 0;
    int y = 0;
    int steps = 0;
    for (String wire : input.split(",")) {
      char direction = wire.charAt(0);
      int distance = Integer.parseInt(wire.substring(1));
      for (int i = 0; i < distance; i++) {
        switch (direction) {
          case 'L' -> x--;
          case 'R' -> x++;
          case 'U' -> y++;
          case 'D' -> y--;
        }
        steps++;
        Loc loc = new Loc(x, y);
        if (!trace.containsKey(loc)) {
          trace.put(loc, steps);
        }
      }
    }
  }

}
