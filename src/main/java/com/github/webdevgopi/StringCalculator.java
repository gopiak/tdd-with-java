package com.github.webdevgopi;

import java.util.Arrays;

public class StringCalculator {

  public int add(String s) {

    String regex = "[\n,]";
    if (s.startsWith("//")) {
      regex = "[\n" + s.substring(2, 3) + "]";
      s = s.substring(3);
    }
    s = s.trim();
    if (s.isEmpty()) {
      return 0;
    }
    String[] nums = s.split(regex);
    int sum = 0;
    for (String num : nums
    ) {
      sum = sum + Integer.parseInt(num);
    }
    return sum;
  }

  public static void main(String[] args) {
    StringCalculator s = new StringCalculator();
    String str = new String("//;\n1;2;3\n4\n5;6");
    System.out.println(s.add(str));
  }
}
