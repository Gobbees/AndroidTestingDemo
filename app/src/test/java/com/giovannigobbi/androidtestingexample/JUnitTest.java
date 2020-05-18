package com.giovannigobbi.androidtestingexample;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JUnitTest {

    private Calculator classUnderTest = new Calculator();

    @ParameterizedTest
    @MethodSource
    public void testInvalidOperations(final String operation) {
        assertThrows(InvalidOperationException.class, () -> classUnderTest.calculate(operation));
    }

    private static Stream<Arguments> testInvalidOperations() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("+3+"),
                Arguments.of("1-2-34"),
                Arguments.of("-4-2"),
                Arguments.of("+2"),
                Arguments.of("123..3"),
                Arguments.of("32423.435645.+234234"),
                Arguments.of("123/132/"),
                Arguments.of("123/132*")
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testValidOperations(final String operation, final Double expectedResult) {
        assertEquals(expectedResult, classUnderTest.calculate(operation), 0);
    }

    private static Stream<Arguments> testValidOperations() {
        return Stream.of(
                Arguments.of("1+2", 3d),
                Arguments.of("3+4.5", 7.5d),
                Arguments.of("1-2", -1d),
                Arguments.of("4.6/2.3", 2d),
                Arguments.of("12*2", 24d),
                Arguments.of("123.3-23.3", 100d),
                Arguments.of("32+12.66", 44.66d)
        );
    }


}
