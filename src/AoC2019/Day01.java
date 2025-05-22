package AoC2019;

import common.Day;
import common.Util;

public class Day01 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day01());
  }

  @Override
  public long partOne(String[] input) {
    long sum = 0;

    for (String s : input) {
      sum += (long) Math.floor(Double.parseDouble(s) / 3) - 2;
    }

    return sum;
  }

  @Override
  public long partTwo(String[] input) {
    long sum = 0;

    for (String s : input) {
      long fuel = (long) Math.floor(Double.parseDouble(s) / 3) - 2;
      sum += fuel;
      while (fuel > 0) {
        fuel = (long) Math.floor((double) fuel / 3) - 2;
        sum += Math.max(0, fuel);
      }
    }

    return sum;
  }
}
