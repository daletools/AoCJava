package AoC2015;

import common.Day;
import common.Util;

import java.util.Arrays;

public class Day02 extends Day {

  public static void main(String[] args) {
    Util.runDay(new Day02());
  }

  @Override
  public long partOne(String[] input) {
    long total = 0;

    for (String parcel : input) {
      total += getNeededWrappingPaper(parcel);
    }

    return total;
  }

  long getNeededWrappingPaper(String parcel) {
    int[] sides = Arrays
        .stream(parcel.split("x"))
        .mapToInt(Integer::parseInt)
        .toArray();

    int side1 = sides[0] * sides[1];
    int side2 = sides[0] * sides[2];
    int side3 = sides[1] * sides[2];

    return 2L * (side1 + side2 + side3) + Math.min(Math.min(side1, side2), side3) ;
  }

  @Override
  public long partTwo(String[] input) {
    long total = 0;

    for (String parcel : input) {
      total += getNeededRibbon(parcel);
    }

    return total;
  }

  long getNeededRibbon(String parcel) {
    int[] sides = Arrays
        .stream(parcel.split("x"))
        .mapToInt(Integer::parseInt)
        .toArray();

    int perimeter1 = sides[0] * 2 + sides[1] * 2;
    int perimeter2 = sides[0] * 2 + sides[2] * 2;
    int perimeter3 = sides[1] * 2 + sides[2] * 2;

    return Math.min(Math.min(perimeter1, perimeter2), perimeter3) + (long) sides[0] * sides[1] * sides[2];
  }
}
