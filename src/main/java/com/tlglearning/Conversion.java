package com.tlglearning;

public class Conversion {

    private static final char DIGIT_CHAR_BASE = 0;

    public static int convertToDecimal(String binary){
        int value = 0;
        for(char c : binary.toCharArray()){
            value = (value *2) + c-'0';
        }
        return value;
    }

    //radix is a number base
    //check for a plus or minus at start of input
    // needs to be [2,10] or throw exception

    /**
     *
     * @param representation
     * @param radix
     * @return
     * @throws IllegalArgumentException if {@code radix <2 || radix > 10}.
     */
    public static int parse(String representation, int radix) throws IllegalArgumentException{
        if(radix < 2 || radix > 10){
            throw new IllegalArgumentException("Radix must be greater than 2 and less than 10");
        }
//        if(representation.startsWith("-")){
//            throw new IllegalArgumentException("This starts with a negative!");
//        }
        char[] digits = representation.toCharArray();
        char firstDigit = digits[0];
        boolean hasSign = firstDigit == '+' || firstDigit == '-';
        int sign = (hasSign && firstDigit == '-') ? -1 : 1;
        int value = 0;

        for(int i = (hasSign ? 1 :0); i < digits.length; i++){
            char digitChar = digits[i];
            int digitValue = digitChar - DIGIT_CHAR_BASE;
            value = value * radix + digitValue;
        }
        return value * sign;
//        int sum = Integer.parseInt(representation, 2);
//        String base = Integer.toString(sum, 8);
//        System.out.println(base);
//        return 0;
    }

}
