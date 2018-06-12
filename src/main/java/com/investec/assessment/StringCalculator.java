package com.investec.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int Add(String input) throws InvalidOutputException {
        List<String> numbers = new ArrayList<>();
        String delimeter = getDelimiter(input);
        try {
            numbers.addAll(Arrays.asList(input.split(delimeter)));
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

    private String getDelimiter(String input){
        return "[,\n]";
    }

    public class InvalidOutputException extends Exception {

        public InvalidOutputException(String message) {
            super(message);
        }
    }
}
