package com.github.webdevgopi;

public class StringCalculator {

  public int add(String s) {
    s = s.trim();
    if (s.isEmpty()) {
      return 0;
    }
    String[] nums = s.split(",");
    int sum = 0;
    for (String num : nums
    ) {
      sum = sum + Integer.parseInt(num);
    }
    return sum;
  }

  public static void main(String[] args) {
    StringCalculator s = new StringCalculator();
    String str = new String("1,2,3,4,5");
    System.out.println(s.add(str));
  }
}
