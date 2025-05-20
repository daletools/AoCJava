package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Util {
  public static String[] readLines(String fileName) {
    File file = new File("src/" + fileName);
    ArrayList<String> lines = new ArrayList<>();

    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        lines.add(scanner.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.err.println("File '" + fileName + "' not found. Continuing read without.");
    }

    return lines.toArray(new String[0]);
  }

  public static void runDay(Day day) {
    System.out.println("=== Running " + day.getClass().getSimpleName() + " ===");

    String[] test = readLines("test.txt");
    String[] input = readLines("input.txt");

    runTests(day, test);
    runSolutions(day, input);
  }

  private static void runTests(Day day, String[] testInput) {
    if (testInput.length > 0) {
      System.out.println("\n[TEST CASES]");
      System.out.println("Part 1 test: " + day.partOne(testInput));
      System.out.println("Part 2 test: " + day.partTwo(testInput));
    } else {
      System.err.println("Warning: No test data found - skipping tests");
    }
  }

  private static void runSolutions(Day day, String[] mainInput) {
    if (mainInput.length > 0) {
      System.out.println("\n[SOLUTIONS]");
      System.out.println("Part 1: " + day.partOne(mainInput));
      System.out.println("Part 2: " + day.partTwo(mainInput));
    } else {
      System.err.println("Warning: No input data found - skipping solutions");
    }
  }
}