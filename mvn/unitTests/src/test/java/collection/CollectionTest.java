package collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTest {

    @Test
    void add() {
        List<String> list = new ArrayList<>();
        Assertions.assertTrue(list.add("1"));
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("1", list.get(0));
    }

    @Test
    void testAdd() {
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }

    @Test
    void contain() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void clear() {
    }

    @Test
    void size() {
    }
}