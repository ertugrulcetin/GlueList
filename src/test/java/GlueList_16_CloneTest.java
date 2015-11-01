import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_16_CloneTest {

    @SuppressWarnings("unchecked")
    @Test
    public void test_clone_simple() throws CloneNotSupportedException {

        GlueList<String> glueList = new GlueList<>();
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");

        GlueList<String> clonedList = (GlueList<String>) glueList.clone();

        assertEquals(false, clonedList == glueList);
        assertEquals(true, glueList.equals(clonedList));
        assertEquals(true, clonedList.getClass() == glueList.getClass());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void test_clone_big_data() {


        GlueList<String> glueList = new GlueList<>();
        for (int i = 0; i < 1_000_000; i++) {
            glueList.add("" + i);
        }

        System.gc();
        GlueList<String> clonedList = (GlueList<String>) glueList.clone();
        System.gc();

        assertEquals(false, clonedList == glueList);
        assertEquals(true, glueList.equals(clonedList));
        assertEquals(true, clonedList.getClass() == glueList.getClass());
    }


    @SuppressWarnings("unchecked")
    @Test
    public void test_clone_big_data_2() {


        GlueList<String> glueList = new GlueList<>();
        for (int i = 0; i < 10_000_000; i++) {
            glueList.add("" + i);
        }
        assertEquals(10_000_000, glueList.size());

        GlueList<String> clonedList = (GlueList<String>) glueList.clone();
        assertEquals(10_000_000, glueList.size());

        assertEquals(false, clonedList == glueList);
        assertEquals(true, glueList.equals(clonedList));
        assertEquals(true, clonedList.getClass() == glueList.getClass());
    }
}