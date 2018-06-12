package com.investec.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private String delimiter = "[,\n]";

    public int Add(String input) throws InvalidOutputException {
        List<String> numbers = new ArrayList<>();
        try {
            input = getDelimiterAndFormatInput(input);
            numbers.addAll(Arrays.asList(input.split(delimiter)));
            return addAllListElements(numbers);
        }catch(NullPointerException e){
            throw new InvalidOutputException("Can not add null");
        }
    }

    private int addAllListElements(List<String> numbers) throws InvalidOutputException {
        int output = 0;
        int addend;
        for(String number: numbers){
            try {
                if (number.isEmpty() || Integer.parseInt(number) > 1000) {
                    continue;
                }
                addend = Integer.parseInt(number);
                if (addend < 0) {
                    throw new InvalidOutputException("Negatives not allowed: " + addend);
                }
                output += addend;
            }catch(NumberFormatException e){
                throw new InvalidOutputException("Input not supported");
            }
        }
        return output;
    }

    private String getDelimiterAndFormatInput(String input){
        if(input.startsWith("//") && input.substring(3).startsWith("\n")){
            delimiter = input.substring(2,3);
            input = input.substring(4);
        }else {
            delimiter = "[,\n]";
        }
        return input;
    }

    public class InvalidOutputException extends Exception {

        public InvalidOutputException(String message) {
            super(message);
        }
    }
}
