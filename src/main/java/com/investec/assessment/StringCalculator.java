package com.investec.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {


    public int Add(String input) throws InvalidOutputException {
        List<String> numbers;
        if(input.isEmpty()){
            return 0;
        }
        numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(input.split(",")));

        if(numbers.size() > 2){
            throw new InvalidOutputException("Too many numbers in input");

        }
        return addAllListElements(numbers);
    }

    private int addAllListElements(List<String> numbers){
        int output = 0;
        for(String number: numbers){
            output += Integer.parseInt(number);
        }
        return output;
    }

    public class InvalidOutputException extends Exception {

        public InvalidOutputException(String message) {
            super(message);
        }
    }
}
