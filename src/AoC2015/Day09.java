package AoC2015;

import common.Day;
import common.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Day09 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day09());
  }

  @Override
  public long partOne(String[] input) {
    long[][] adjMatrix = createAdjMatrix(input);
    long min = Long.MAX_VALUE;

    HashSet<Long> visited = new HashSet<>();

    for (int i = 0; i < adjMatrix.length; i++) {
      for (int j = 0; j < adjMatrix[i].length; j++) {
        if (adjMatrix[i][j] == 0) continue;

      }
    }

    return min;
  }

  @Override
  public long partTwo(String[] input) {
    return 0;
  }

  long[][] createAdjMatrix(String[] input) {
    SortedSet<String> cities = new TreeSet<>();

    for (String line : input) {
      String[] parts = line.split(" ");
      cities.add(parts[0]);
      cities.add(parts[2]);
    }
    long[][] adjMatrix = new long[cities.size()][cities.size()];
    ArrayList<String> cityList = new ArrayList<>(cities);

    for (String line : input) {
      String[] parts = line.split(" ");
      adjMatrix[cityList.indexOf(parts[0])][cityList.indexOf(parts[2])] = Long.parseLong(parts[4]);
      adjMatrix[cityList.indexOf(parts[2])][cityList.indexOf(parts[0])] = Long.parseLong(parts[4]);
    }

    return adjMatrix;
  }

  static class Route {
    long weight;

  }
}
