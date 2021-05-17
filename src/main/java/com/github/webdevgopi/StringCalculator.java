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
    String msg = "";
    for (String num : nums
    ) {
      int temp = Integer.parseInt(num);
      if (temp < 0) {
        msg = msg + " " + temp;
      }
      if (temp > 1000) {
        temp = temp % 1000;
      }
      sum = sum + temp;
    }
    if (!msg.isEmpty()) {
      throw new IllegalArgumentException("negatives not allowed ->" + msg);
    }

    return sum;
  }

  public static void main(String[] args) {
    StringCalculator s = new StringCalculator();
    String str = new String("//;\n1;2;-3\n4\n-5;6");
    System.out.println(s.add(str));
  }
}
