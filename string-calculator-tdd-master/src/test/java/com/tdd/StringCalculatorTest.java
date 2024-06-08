package com.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testOneNumber() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testUnknownAmountOfNumbers() {
        assertEquals(6, calculator.add("1,2,3"));
    }

    @Test
    public void testNewLineBetweenNumbers() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,2,-3"));
    }

    @Test
    public void testGetCalledCount() {
        calculator.add("1,2");
        calculator.add("3");
        assertEquals(2, calculator.getCalledCount());
    }

    @Test
    public void testIgnoreNumbersGreaterThan1000() {
        assertEquals(2, calculator.add("1001,2"));
    }

    @Test
    public void testDelimitersOfAnyLength() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testMultipleDelimiters() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testMultipleDelimitersLongerThanOneChar() {
        assertEquals(6, calculator.add("//[**][%%]\n1**2%%3"));
    }
}
