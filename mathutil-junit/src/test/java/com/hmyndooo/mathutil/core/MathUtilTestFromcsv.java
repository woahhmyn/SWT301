/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmyndooo.mathutil.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author hmynd
 */
public class MathUtilTestFromcsv {

    @ParameterizedTest
    @CsvFileSource(
            resources = "/data/factorial_test_data.csv",
            numLinesToSkip = 1
    )
    void testGetFactorial_ValidInput_FromCsv(int input, long expected) {
        assertEquals(expected, MathUtil.getFactorial(input));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "20, 2432902008176640000"
    })
    void testGetFactorial_BoundaryValues(int input, long expected) {
        assertEquals(expected, MathUtil.getFactorial(input));
    }

    @ParameterizedTest
    @CsvSource({
        "-1",
        "21"
    })
    void testGetFactorial_InvalidInput_ThrowsException(int input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> MathUtil.getFactorial(input)
        );
    }
}
