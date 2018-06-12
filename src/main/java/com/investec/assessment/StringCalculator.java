package com.investec.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {


    public int Add(String input) throws InvalidOutputException {
        List<String> numbers = new ArrayList<>();
        try {
            numbers.addAll(Arrays.asList(input.split(",")));
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

    public class InvalidOutputException extends Exception {

        public InvalidOutputException(String message) {
            super(message);
        }
    }
}
