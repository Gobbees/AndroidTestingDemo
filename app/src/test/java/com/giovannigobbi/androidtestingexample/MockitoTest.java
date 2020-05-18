package com.giovannigobbi.androidtestingexample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {
    private Calculator classUnderTest = mock(Calculator.class);

    @Test
    public void testException() {
        when(classUnderTest.calculate("123+123")).thenThrow(new InvalidOperationException());
        when(classUnderTest.calculate("10+40")).thenReturn(50d);

        assertEquals(50d, classUnderTest.calculate("10+40"), 0);
        assertThrows(InvalidOperationException.class, () -> classUnderTest.calculate("123+123"));
    }
}
