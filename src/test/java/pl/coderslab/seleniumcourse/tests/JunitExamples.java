package pl.coderslab.seleniumcourse.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JunitExamples {
    @Test
    public void shouldReturnValidAddResult() {
        // given
        int a = 2;
        int b = 40;
        // when
        int actual = 42;
        // then
        Assertions.assertEquals(42, actual);
    }
    @Test
    public void assertionsExample(){
        assertTrue(3>2);
        assertFalse(2>4);
    }

}
