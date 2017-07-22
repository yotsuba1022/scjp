package idv.carl.scjp.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Carl Lu
 */
public class ListAddDemoTest {

    @Test
    public void testAddToNonFixedSizeList() {
        List<String> nonFixedSizeList = new ArrayList<>();
        nonFixedSizeList.add("Que");
        ListAddDemo.addToList("Pa so!!!", nonFixedSizeList);
        assertEquals(2, nonFixedSizeList.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddToFixedSizeList() {
        List<String> fixedSizeList = Arrays.asList("Que", "pa");
        fixedSizeList.add("so");
    }

}
