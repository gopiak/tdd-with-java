package com.github.webdevgopi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}