# TDD Kata 1 - String Calculator

This exercise is designed to help you learn Test-Driven Development (TDD) by implementing a simple string calculator. Follow the tasks incrementally and ensure to write tests before implementing the functionality.

## Instructions

1. **Initial Setup:**
    - Create a class `StringCalculator` with a method `public int Add(String numbers)`.

2. **Handling Basic Inputs:**
    - The method can take 0, 1, or 2 numbers and return their sum.
    - For an empty string, it should return 0.
    - Examples:
        - `""` should return `0`
        - `"1"` should return `1`
        - `"1,2"` should return `3`

3. **Incremental Testing:**
    - Start with the simplest test case of an empty string.
    - Move on to tests for one and two numbers.
    - Write tests incrementally and refactor after each passing test.

4. **Handling Multiple Numbers:**
    - Allow the `Add` method to handle an unknown number of numbers.

5. **Handling New Lines Between Numbers:**
    - Allow the `Add` method to handle new lines between numbers in addition to commas.
    - Examples:
        - `"1\n2,3"` should return `6`
    - Invalid input such as `"1,\n"` does not need to be tested.

6. **Supporting Different Delimiters:**
    - To change a delimiter, the beginning of the string will contain a separate line in the format:
      `"//[delimiter]\n[numbers…]"`.
    - Example:
        - `"//;\n1;2"` should return `3` (delimiter is `;`).

7. **Handling Negative Numbers:**
    - Calling `Add` with a negative number should throw an exception "negatives not allowed" along with the negative number.
    - If there are multiple negatives, the exception message should list all of them.

8. **Counting Method Calls:**
    - Add a method `public int GetCalledCount()` to `StringCalculator` that returns how many times `Add()` was invoked.
    - Use TDD to implement this method.

9. **Triggering Events:**
    - Add an event to the `StringCalculator` class named `public event Action<string, int> AddOccurred` that triggers after every `Add()` call.
    - Example:
        ```csharp
        string givenInput = null;
        sc.AddOccurred += delegate(string input, int result)
        {
            givenInput = input;
        };
        ```

10. **Ignoring Large Numbers:**
    - Numbers bigger than 1000 should be ignored.
    - Example:
        - `"2,1001"` should return `2`.

11. **Delimiters of Any Length:**
    - Delimiters can be of any length using the format `"//[delimiter]\n"`.
    - Example:
        - `"//[***]\n1***2***3"` should return `6`.

12. **Multiple Delimiters:**
    - Allow multiple delimiters using the format `"//[delim1][delim2]\n"`.
    - Examples:
        - `"//[*][%]\n1*2%3"` should return `6`.
        - `"//[**][%%]\n1**2%%3"` should return `6`.

## Additional Information

For more details, visit [Roy Osherove's website](https://osherove.com) or contact roy@osherove.com.

## Example Usage

```java
StringCalculator sc = new StringCalculator();
System.out.println(sc.add("")); // 0
System.out.println(sc.add("1")); // 1
System.out.println(sc.add("1,2")); // 3
System.out.println(sc.add("1\n2,3")); // 6
System.out.println(sc.add("//;\n1;2")); // 3
