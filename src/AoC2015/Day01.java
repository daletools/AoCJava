package AoC2015;
import common.Day;
import common.Util;

import java.io.FileNotFoundException;

public class Day01 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day01());
  }

  @Override
  public long partOne(String[] input) {
    int floor = 0;
    for (char c : input[0].toCharArray()) {
      if (c == '(') {
        floor++;
      } else {
        floor--;
      }
    }
    return floor;
  }

  @Override
  public long partTwo(String[] input) {
    int floor = 0;
    for (int i = 0; i < input[0].length(); i++) {
      if (input[0].charAt(i) == '(') {
        floor++;
      } else {
        floor--;
      }
      if (floor == -1) return i;
    }
    return -1;
  }
}
