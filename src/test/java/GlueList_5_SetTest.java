import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_5_SetTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_set_fail() {

        GlueList<String> glueList = new GlueList<>();
        glueList.add("1");

        glueList.set(1, "2");
    }

    @Test
    public void test_set() {

        GlueList<String> glueList = new GlueList<>(2);
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");
        assertEquals(3, glueList.size());

        glueList.set(2, "X");
        assertEquals("X", glueList.get(2));
    }

    @Test
    public void test_set_big_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 100; i++) {
            glueList.add("" + i);
        }
        assertEquals(100, glueList.size());

        glueList.set(95, "X");
        glueList.set(96, "X");
        glueList.set(97, "X");
        glueList.set(98, "X");
        glueList.set(99, "X");


        assertEquals("X", glueList.get(95));
        assertEquals("X", glueList.get(96));
        assertEquals("X", glueList.get(97));
        assertEquals("X", glueList.get(98));
        assertEquals("X", glueList.get(99));
    }
}