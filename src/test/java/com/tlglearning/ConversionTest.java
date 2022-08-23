package com.tlglearning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ConversionTest {

    @Test
    void convertToDecimal() {
        assertEquals(173, Conversion.convertToDecimal("10101101"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "parse-valid.csv", numLinesToSkip = 1)
    void parse_valid(String representation, int radix, int expected){
        assertEquals(expected, Conversion.parse(representation, radix));
    }

}