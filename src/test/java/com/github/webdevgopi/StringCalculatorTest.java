package com.github.webdevgopi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

  @Test
  @DisplayName("Test for empty string")
  public void testForEmptyString() {
    StringCalculator myUnit = new StringCalculator();

    int result = myUnit.add("");

    assertEquals(0, result);
  }

  @Test
  @DisplayName("Test for string with one integer")
  public void testForStringWithOneInteger() {
    StringCalculator myUnit = new StringCalculator();

    int result = myUnit.add("5");
    assertEquals(5, result);

  }

  @Test
  @DisplayName("Test for string with two integers")
  public void testForStringWithTwoIntegers() {
    StringCalculator myUnit = new StringCalculator();

    int result = myUnit.add("2,3");
    assertEquals(5, result);
  }

  @Test
  @DisplayName("Test for string with newlines instead of commas")
  public void testForStringWithNewlines() {
    StringCalculator myUnit = new StringCalculator();

    int result = myUnit.add("1\n2,3\n4,5\n55\n5\n6");
    assertEquals(81, result);
  }

  @Test
  @DisplayName("Test for string with variable delimiter")
  public void testForStringWithVariableDelimiter() {
    StringCalculator myUnit = new StringCalculator();

    int result1 = myUnit.add("//:\n1:2:3\n4\n5:6\n7");
    assertEquals(28, result1);
    int result2 = myUnit.add("//~\n1~2\n3~4\n5~6\n7");
    assertEquals(28, result2);
  }

  @Test
  @DisplayName("Test for string with negative integers")
  public void testForStringWithNegativeIntegers() {
    StringCalculator myUnit = new StringCalculator();

    Throwable ex1 = assertThrows(IllegalArgumentException.class,
        () -> myUnit.add("//:\n1:2:-1\n4\n5:6\n7"));
    assertEquals("negatives not allowed -> -1", ex1.getMessage());

    Throwable ex2 = assertThrows(IllegalArgumentException.class,
        () -> myUnit.add("//:\n1:2:-1\n-4\n5:6\n-7"));
    assertEquals("negatives not allowed -> -1 -4 -7", ex2.getMessage());
  }
}