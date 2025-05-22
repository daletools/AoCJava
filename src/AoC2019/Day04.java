package AoC2019;

import common.Day;
import common.Util;

public class Day04 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day04());
  }

  @Override
  public long partOne(String[] input) {
    int sum = 0;
    String[] parts = input[0].split("-");
    int lower = Integer.parseInt(parts[0]);
    int upper = Integer.parseInt(parts[1]);

    for (int i = lower; i <= upper; i++) {
      if (checkPassword(String.valueOf(i))) {
        sum++;
      }
    }

    return sum;
  }

  boolean checkPassword(String password) {
    boolean length = password.length() == 6;
    boolean digits = password.matches("^[0-9]{6}$");
    boolean nonDecreasing = true;
    boolean hasDouble = false;
    char last = password.charAt(0);
    for (int i = 1; i < password.length(); i++) {
      char current = password.charAt(i);
      if (current == last) {
        hasDouble = true;
      }
      if (current < last) {
        nonDecreasing = false;
        break;
      }
      last = current;
    }
    return length && digits && nonDecreasing && hasDouble;
  }

  @Override
  public long partTwo(String[] input) {
    int sum = 0;
    String[] parts = input[0].split("-");
    int lower = Integer.parseInt(parts[0]);
    int upper = Integer.parseInt(parts[1]);

    for (int i = lower; i <= upper; i++) {
      if (checkPasswordImproved(String.valueOf(i))) {
        sum++;
      }
    }

    return sum;
  }

  boolean checkPasswordImproved(String password) {
    boolean length = password.length() == 6;
    boolean digits = password.matches("^[0-9]{6}$");
    boolean nonDecreasing = true;
    boolean hasDouble = false;
    char last = password.charAt(0);
    for (int i = 1; i < password.length(); i++) {
      char current = password.charAt(i);
      if (current == last) {
        if (i == 1 || password.charAt(i - 2) != last) {
          if (i == password.length() - 1 || password.charAt(i + 1) != current) {
            hasDouble = true;
          }
        }
      }
      if (current < last) {
        nonDecreasing = false;
        break;
      }
      last = current;
    }
    return length && digits && nonDecreasing && hasDouble;
  }
}
