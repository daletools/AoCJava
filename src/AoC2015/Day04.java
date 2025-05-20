package AoC2015;

import common.Day;
import common.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Day04 extends Day {
  public static void main(String[] args) {
    Util.runDay(new Day04());
  }

  static String md5toHex(String s) {
    try {
      MessageDigest digest = MessageDigest.getInstance("MD5");
      digest.update(s.getBytes());
      return HexFormat.of().formatHex(digest.digest());
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public long partOne(String[] input) {
    String s = input[0];
    String hex;
    long num = -1;
    do {
      num++;
      hex = md5toHex(s + num);
    } while (
        !hex.startsWith("00000")
    );
    return num;
  }

  @Override
  public long partTwo(String[] input) {
    String s = input[0];
    String hex;
    long num = -1;
    do {
      num++;
      hex = md5toHex(s + num);
    } while (
        !hex.startsWith("000000")
    );
    return num;
  }
}
