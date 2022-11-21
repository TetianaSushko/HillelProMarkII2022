import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    @Test
    void sum() {
       int result = Calculate.sum(1,1);
       assertEquals(2, result);
    }

    @Test
    void mult() {
        int result = Calculate.mult(1,1);
        assertEquals(1, result);
    }

    @Test
    void sub() {
        int result = Calculate.sub(1,1);
        assertEquals(0, result);
    }

    @Test
    void divZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            Calculate.div(1,0);
        });
    }

    @Test
    void div() {
        double result = Calculate.div(1,1);
        assertEquals(1, result);
    }
}