package AoC2015;

import common.Day;
import common.Util;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Day05 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day05());
  }

  @Override
  public long partOne(String[] input) throws NoSuchAlgorithmException {
    long count = 0;
    for (String s : input) {
      if (isNice(s)) {
        count++;
      }
    }
    return count;
  }

  boolean isNice(String s) {
    long numVowels = 0;
    boolean repeat = false;
    boolean forbidden = false;
    String[] badStrings = {"ab", "cd", "pq", "xy"};
    char prev  = s.charAt(0);
    if ("aeiou".contains(String.valueOf(prev))) numVowels++;

    for (int i = 1; i < s.length(); i++) {
      char curr = s.charAt(i);
      if (prev == curr) repeat = true;
      if ("aeiou".contains(String.valueOf(curr))) numVowels++;
      String pair = String.valueOf(prev) + String.valueOf(curr);
      if (Arrays.asList(badStrings).contains(pair)) {
        forbidden = true;
        break;
      }
      prev = curr;
    }

    return (numVowels > 2) && repeat && !forbidden;
  }

  @Override
  public long partTwo(String[] input) {
    long count = 0;
    for (String s : input) {
      if (isNiceRedux(s)) {
        count++;
      }
    }
    return count;
  }

  boolean isNiceRedux(String s) {
    boolean hasSandwich = false;
    boolean hasNonOverlappingPair = false;
    Map<String, Integer> pairPositions = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      if (i >= 2 && s.charAt(i) == s.charAt(i - 2)) {
        hasSandwich = true;
        if (hasNonOverlappingPair) {
          return true;
        }
      }

      if (i >= 1) {
        String pair = s.substring(i - 1, i + 1);
        Integer prevPos = pairPositions.get(pair);
        if (prevPos != null && prevPos < i - 2) {
          hasNonOverlappingPair = true;

          if (hasSandwich) {
            return true;
          }
        }
        pairPositions.putIfAbsent(pair, i - 1);
      }


    }

    return false;
  }
}
