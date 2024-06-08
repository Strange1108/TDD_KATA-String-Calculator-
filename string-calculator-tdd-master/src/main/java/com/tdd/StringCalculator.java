package com.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private int calledCount = 0;

    public int add(String numbers) {
        calledCount++;
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String numbersWithoutDelimiter = numbers;

        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(\\[.*?]|.?)\n(.*)").matcher(numbers);
            matcher.matches();
            delimiter = parseDelimiters(matcher.group(1));
            numbersWithoutDelimiter = matcher.group(2);
        }

        String[] nums = numbersWithoutDelimiter.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String num : nums) {
            int parsedNum = Integer.parseInt(num);
            if (parsedNum < 0) {
                negatives.add(parsedNum);
            }
            if (parsedNum <= 1000) {
                sum += parsedNum;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }

    private String parseDelimiters(String delimiterString) {
        StringBuilder delimiter = new StringBuilder();
        Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(delimiterString);
        while (matcher.find()) {
            if (delimiter.length() > 0) {
                delimiter.append("|");
            }
            delimiter.append(Pattern.quote(matcher.group(1)));
        }
        if (delimiter.length() == 0) {
            delimiter.append(Pattern.quote(delimiterString));
        }
        return delimiter.toString();
    }

    public int getCalledCount() {
        return calledCount;
    }
}
