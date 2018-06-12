package com.investec.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private String delimiter = "[,\n]";

    public int Add(String input) throws InvalidInputException {
        List<String> numbers = new ArrayList<>();

        input = extractDelimiterAndInput(input);
        numbers.addAll(Arrays.asList(input.split(delimiter)));
        return addAllListElements(numbers);
    }

    private int addAllListElements(List<String> numbers) throws InvalidInputException {
        int output = 0;
        int addend;
        for (String number : numbers) {
            if (number.isEmpty() || Integer.parseInt(number) > 1000) {
                continue;
            }
            addend = Integer.parseInt(number);
            if (addend < 0) {
                throw new InvalidInputException("Negatives not allowed: " + addend);
            }
            output += addend;
        }
        return output;
    }

    private String extractDelimiterAndInput(String input) {
        if (input.startsWith("//")){
            int index = input.indexOf("\n");
            delimiter = input.substring(2, index);
            if(delimiter.split("]").length>1){
                delimiter = "["+delimiter+"]";
            }
            input = input.substring(index+1);
        } else {
            delimiter = "[,\n]";
        }
        return input;
    }

    public class InvalidInputException extends Exception {

        public InvalidInputException(String message) {
            super(message);
        }
    }
}
