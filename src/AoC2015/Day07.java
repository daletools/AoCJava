package AoC2015;

import common.Day;
import common.Util;

import java.util.*;


public class Day07 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day07());
  }
  @Override
  public long partOne(String[] input) {
    HashMap<String, Character> map = new HashMap<>();
    ArrayList<String[]> instructions = splitInput(input);

    return run(instructions, map);
  }

  @Override
  public long partTwo(String[] input) {
    HashMap<String, Character> map = new HashMap<>();
    ArrayList<String[]> instructions = splitInput(input);

    map.put("b", (char) partOne(input));

    instructions.removeIf(s -> s.length > 1 && s[1].trim().equals("b"));

    return run(instructions, map);
  }

  ArrayList<String[]> splitInput(String[] input) {
    ArrayList<String[]> output = new ArrayList<>();

    for (String s : input) {
      output.add(s.split("->"));
    }
    output.sort(Comparator.comparing(it -> it[0].split(" ").length));

    return output;
  }

  long run(ArrayList<String[]> instructions, HashMap<String, Character> map) {
    while (!instructions.isEmpty()) {
      TreeSet<Integer> fulfilled = new TreeSet<>(Collections.reverseOrder());
      int curr = instructions.size();

      for (int i = 0; i < instructions.size(); i++) {
        String[] instruction = instructions.get(i)[0].trim().split(" ");
        String target = instructions.get(i)[1].trim();

        switch (instruction.length) {
          case 1 -> {
            if (instruction[0].matches("^\\d+$")) {
              map.put(target, (char) Integer.parseInt(instruction[0]));
              fulfilled.add(i);
            } else {
              if (map.containsKey(instruction[0])) {
                map.put(target, map.get(instruction[0]));
                fulfilled.add(i);
              }
            }
          }

          case 2 -> {
            if (instruction[0].equals("NOT") && map.containsKey(instruction[1])) {
              map.put(target, (char) ~map.get(instruction[1]));
              fulfilled.add(i);
            }
          }

          case 3 -> {
            switch (instruction[1]) {
              case "LSHIFT" -> {
                if (map.containsKey(instruction[0])) {
                  map.put(target, (char) (map.get(instruction[0]) << Integer.parseInt(instruction[2])));
                  fulfilled.add(i);
                }
              }
              case "RSHIFT" -> {
                if (map.containsKey(instruction[0])) {
                  map.put(target, (char) (map.get(instruction[0]) >> Integer.parseInt(instruction[2])));
                  fulfilled.add(i);
                }
              }
              case "AND" -> {
                if (instruction[0].matches("^\\d+$")) {
                  if (map.containsKey(instruction[2])) {
                    map.put(target, (char) (map.get(instruction[2]) & Integer.parseInt(instruction[0])));
                    fulfilled.add(i);
                  }
                } else if (instruction[2].matches("^\\d+$")) {
                  map.put(target, (char) (map.get(instruction[2]) & Integer.parseInt(instruction[2])));
                  fulfilled.add(i);
                } else {
                  if (map.containsKey(instruction[0]) && map.containsKey(instruction[2])) {
                    map.put(target, (char) (map.get(instruction[0]) & map.get(instruction[2])));
                    fulfilled.add(i);
                  }
                }
              }
              case "OR" -> {
                if (instruction[0].matches("^\\d+$")) {
                  if (map.containsKey(instruction[2])) {
                    map.put(target, (char) (map.get(instruction[2]) | Integer.parseInt(instruction[0])));
                    fulfilled.add(i);
                  }
                } else if (instruction[2].matches("^\\d+$")) {
                  map.put(target, (char) (map.get(instruction[2]) | Integer.parseInt(instruction[2])));
                  fulfilled.add(i);
                } else {
                  if (map.containsKey(instruction[0]) && map.containsKey(instruction[2])) {
                    map.put(target, (char) (map.get(instruction[0]) | map.get(instruction[2])));
                    fulfilled.add(i);
                  }
                }
              }
            }
          }
        }
      }


      while (!fulfilled.isEmpty()) {
        Integer f = fulfilled.pollFirst();
        if (f != null) {
          instructions.remove((int) f);
        } else {
          break;
        }
      }

      if (instructions.size() == curr) {
        System.out.println("uh oh");
      }
    }

    return map.getOrDefault("a", '0');
  }
}
