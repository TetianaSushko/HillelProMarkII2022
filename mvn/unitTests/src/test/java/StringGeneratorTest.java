import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringGeneratorTest {

    @Test
    void generateString() {
        StringGenerator sg = new StringGenerator();
        String result = sg.generateString(5);
        Assertions.assertEquals(5, result.length());
    }

    @Test
    void valueString(){
        Assertions.assertEquals(
                "aaaaa",
                new StringGenerator().generateString(5)
        );

    }
}