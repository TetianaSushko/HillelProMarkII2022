import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamNullTest {

    @Test
    void convert() {
        List<String> list = new ArrayList<>();
        list.add("a");

        StreamNull sn = new StreamNull();

        List<Pair> l = sn.convert(list);

        Assertions.assertEquals(1, l.size());
        Assertions.assertEquals("a", l.get(0).getlCase());
        Assertions.assertEquals("A", l.get(0).getuCase());

    }

    @Test
    void convert1() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add(null);
        list.add(null);
        list.add("b");

        StreamNull sn = new StreamNull();
        List<Pair> l = sn.convert(list);
        Assertions.assertEquals(2, l.size());
    }


    @Test
    void convert2() {
        List<String> list = null;
        StreamNull sn = new StreamNull();
        List<Pair> l = sn.convert(list);
        Assertions.assertEquals(0, l.size());
    }
}