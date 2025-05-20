package AoC2015;

import common.Day;
import common.Util;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Day06 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day06());
  }

  @Override
  public long partOne(String[] input) throws NoSuchAlgorithmException {
    boolean[][] lights = new boolean[1000][1000];

    for (String line : input) {
      String[] parts = line.split(" ");
      if (parts.length == 4) {  //length of 4 indicates a toggle instruction
        int[] start = Arrays.stream(parts[1].split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] end = Arrays.stream(parts[3].split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        for (int row = start[0]; row <= end[0]; row++) {
          for (int col = start[1]; col <= end[1]; col++) {
            lights[row][col] = !lights[row][col];
          }
        }
      } else {
        int[] start = Arrays.stream(parts[2].split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] end = Arrays.stream(parts[4].split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        if (parts[1].length() == 2) { //length of 2 indicates "on"
          for (int row = start[0]; row <= end[0]; row++) {
            for (int col = start[1]; col <= end[1]; col++) {
              lights[row][col] = true;
            }
          }
        } else {  //off
          for (int row = start[0]; row <= end[0]; row++) {
            for (int col = start[1]; col <= end[1]; col++) {
              lights[row][col] = false;
            }
          }
        }
      }
    }

    long sum = 0;

    for (boolean[] row : lights) {
      for (boolean light : row) {
        if (light) sum++;
      }
    }

    return sum;
  }

  @Override
  public long partTwo(String[] input) {
    long[][] lights = new long[1000][1000];

    for (String line : input) {
      String[] parts = line.split(" ");
      if (parts.length == 4) {  //length of 4 indicates a toggle instruction
        int[] start = Arrays.stream(parts[1].split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] end = Arrays.stream(parts[3].split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        for (int row = start[0]; row <= end[0]; row++) {
          for (int col = start[1]; col <= end[1]; col++) {
            lights[row][col] += 2;
          }
        }
      } else {
        int[] start = Arrays.stream(parts[2].split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] end = Arrays.stream(parts[4].split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

        if (parts[1].length() == 2) { //length of 2 indicates "on"
          for (int row = start[0]; row <= end[0]; row++) {
            for (int col = start[1]; col <= end[1]; col++) {
              lights[row][col]++;
            }
          }
        } else {  //off
          for (int row = start[0]; row <= end[0]; row++) {
            for (int col = start[1]; col <= end[1]; col++) {
              lights[row][col] = Math.max(0, lights[row][col] - 1);
            }
          }
        }
      }
    }

    long sum = 0;

    for (long[] row : lights) {
      for (long light : row) {
        sum += light;
      }
    }

    return sum;
  }
}
