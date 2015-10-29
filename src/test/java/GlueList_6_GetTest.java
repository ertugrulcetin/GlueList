import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GlueList_6_GetTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_get_fail() {

        GlueList<String> glueList = new GlueList<>();
        glueList.get(0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_get_fail_2() {

        GlueList<String> glueList = new GlueList<>();
        glueList.add("1");
        glueList.add("2");
        glueList.get(3);
    }

    @Test
    public void test_get_simple_data() {

        GlueList<String> glueList = new GlueList<>(2);
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");
        glueList.add("4");
        glueList.add("5");
        glueList.add("6");
        glueList.add("7");
        glueList.add("8");
        glueList.add("9");
        glueList.add("10");

        assertEquals("1", glueList.get(0));
        assertEquals("2", glueList.get(1));
        assertEquals("3", glueList.get(2));
        assertEquals("4", glueList.get(3));
        assertEquals("5", glueList.get(4));
        assertEquals("6", glueList.get(5));
        assertEquals("7", glueList.get(6));
        assertEquals("8", glueList.get(7));
        assertEquals("9", glueList.get(8));
        assertEquals("10", glueList.get(9));
    }

    @Test
    public void test_get_big_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 100_000; i++) {
            glueList.add("" + i);
        }

        for (int i = 0; i < 100_000; i++) {
            assertEquals("" + i, glueList.get(i));
        }
    }

    @Test
    public void test_get_with_add_all() {

        GlueList<String> glueList = new GlueList<>();

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");

        for (int i = 0; i < 10; i++) {
            glueList.addAll(arrayList);
        }

        assertEquals(100, glueList.size());

        int j = 0;
        for (int i = 0; i < 100; i++) {

            if (j % 10 == 0) {
                j = 0;
            }

            assertEquals("" + (j + 1), glueList.get(i));
            j++;
        }
    }
}
