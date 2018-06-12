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

    private int addAllListElements(List<String> numbers){
        int output = 0;
        for(String number: numbers){
            if(number.isEmpty()){
                continue;
            }
            output += Integer.parseInt(number);
        }
        return output;
    }

    private String getDelimiterAndFormatInput(String input){
        if(input.indexOf("//") == 0 && input.indexOf("\n") == 3){
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
