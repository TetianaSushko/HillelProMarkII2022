import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CollectTest {
    @Test
    void testCollectionSize(){
        ArrayList<String> strList = new ArrayList<>();
        Assertions.assertEquals(0, strList.size());

        strList.add("1");
        Assertions.assertEquals(1, strList.size());

        strList.remove(0);
        Assertions.assertEquals(0, strList.size());
    }

    @Test
    void testCollectionAdd(){
        ArrayList<String> strList = new ArrayList<>();

        Assertions.assertTrue(strList.add("1"));
        Assertions.assertEquals(1, strList.size());

        Assertions.assertTrue(strList.add("2"));
        Assertions.assertEquals(2, strList.size());
    }
}