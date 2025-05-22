package AoC2019;

import java.util.Scanner;

public class IntCom {
  private int programCounter;
  private final int[] tape;
  private int r1, r2, r3, r4, r5, r6, r7, r8;
  private int ir, mar;

  IntCom(int[] tape) {
    programCounter = 0;
    this.tape = tape;
    r1 = r2 = r3 = r4 = r5 = r6 = r7 = r8 = 0;
    ir = mar = 0;
  }

  IntCom(String[] input) {
    programCounter = 0;
    String[] s = input[0].split(",");
    tape = new int[s.length];

    for (int i = 0; i < s.length; i++) {
      tape[i] = Integer.parseInt(s[i]);
    }

  }

  int run() {
    while (tape[programCounter] != 99) {
      switch (tape[programCounter] % 100) {
        case 1 -> add();
        case 2 -> mul();
        case 3 -> input();
        case 4 -> output();
        case 99 -> {
          break;
        }
      }
    }
    return tape[0];
  }

  private void output() {
    ir = tape[programCounter];

    programCounter++;
    System.out.println(tape[programCounter]);
    programCounter++;
  }

  private void input() {
    ir = tape[programCounter];

    Scanner sc = new Scanner(System.in);
    r1 = sc.nextInt();
    programCounter++;
    r2 = tape[programCounter];
    tape[r2] = r1;
    programCounter++;
  }

  void write(int index, int value) {
    tape[index] = value;
  }

  private void add() {
    ir = tape[programCounter];

    programCounter++;
    r1 = tape[programCounter];
    programCounter++;
    r2 = tape[programCounter];
    programCounter++;
    r3 = tape[programCounter];
    tape[r3] = tape[r1] + tape[r2];
    programCounter++;
  }

  private void mul() {
    ir = tape[programCounter];

    programCounter++;
    r1 = tape[programCounter];
    programCounter++;
    r2 = tape[programCounter];
    programCounter++;
    r3 = tape[programCounter];
    tape[r3] = tape[r2] * tape[r1];
    programCounter++;
  }
}
