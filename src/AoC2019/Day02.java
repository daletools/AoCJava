package AoC2019;

import common.Day;
import common.Util;

public class Day02 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day02());
  }

  @Override
  public long partOne(String[] input) {
    IntCom ic = new IntCom(input);
    ic.write(1, 12);
    ic.write(2, 2);
    return ic.run();
  }

  @Override
  public long partTwo(String[] input) {

    for (int noun = 0; noun < 100; noun++) {
      for (int verb = 0; verb < 100; verb++) {
        IntCom ic = new IntCom(input);
        ic.write(1, noun);
        ic.write(2, verb);
        int result = ic.run();
        if (result == 19690720) {
          return 100 * noun + verb;
        }
      }
    }

    return -1;
  }
}
