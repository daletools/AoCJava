package AoC2015;

import common.Day;
import common.Util;

public class Day08 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day08());
  }

  @Override
  public long partOne(String[] input) {
    long total = 0;
    long inMemory = 0;

    for (String s : input) {
      total += s.length();
      inMemory += parseString(s);
    }

    return total - inMemory;
  }

  private long parseString(String s) {
    if (s.startsWith("\"")) return parseString(s.substring(1));
    if (s.endsWith("\"")) return parseString(s.substring(0, s.length()-1));

    if (s.matches("^[a-z]+.*")) return 1 + parseString(s.substring(1));
    if (s.startsWith("\\\"") || s.startsWith("\\\\")) return 1 + parseString(s.substring(2));
    if (s.startsWith("\\x")) return 1 + parseString(s.substring(4));

    return s.length();
  }

  @Override
  public long partTwo(String[] input) {
    long total = 0;
    long inMemory = 0;

    for (String s : input) {
      total += s.length();
      inMemory += 2 + unparseString(s);
    }

    return inMemory - total;
  }

  private long unparseString(String s) {
    if (s.matches("^[^\\\\\"]+.*")) return 1 + unparseString(s.substring(1));
    if (s.startsWith("\"") || s.startsWith("\\")) return 2 + unparseString(s.substring(1));

    return s.length();
  }
}
