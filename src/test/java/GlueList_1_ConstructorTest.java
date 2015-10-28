import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GlueList_1_ConstructorTest {

    @Test
    public void test_default_constructor() {

        GlueList<String> glueList = new GlueList<>();

        assertEquals(0, glueList.size());
        assertEquals(10, glueList.last.getElementDataLength());
    }

    @Test
    public void test_initial_capacity() {

        GlueList<String> glueList = new GlueList<>(20);

        assertEquals(0, glueList.size());
        assertEquals(20, glueList.last.getElementDataLength());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_initial_capacity_fail() {

        GlueList<String> glueList = new GlueList<>(-1);
    }

    @Test(expected = NullPointerException.class)
    public void test_collection_constructor_fail() {

        GlueList<String> glueList = new GlueList<>(null);
    }

    @Test
    public void test_collection_constructor() {

        List<String> dataList = new LinkedList<>();

        dataList.add("1");
        dataList.add("2");
        dataList.add("3");
        dataList.add("4");
        dataList.add("5");

        GlueList<String> glueList = new GlueList<>(dataList);

        assertEquals(dataList.size(), glueList.size());
    }

    @Test
    public void test_collection_constructor_2() {

        List<String> dataList = new LinkedList<>();

        dataList.add("1");
        dataList.add("2");
        dataList.add("3");
        dataList.add("4");
        dataList.add("5");

        GlueList<String> glueList = new GlueList<>(dataList);
        glueList.add("6");

        assertNotEquals(dataList.size(), glueList.size());
    }
}
