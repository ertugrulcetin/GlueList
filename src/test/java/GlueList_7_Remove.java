import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_7_Remove {

    @Test
    public void test_remove_is_first_and_last_equals() {

        GlueList<String> glueList = new GlueList<>(2);
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");
        glueList.add("4");

        glueList.remove(2);
        glueList.remove(2);

        assertEquals(true, glueList.first == glueList.last);
    }

    @Test
    public void test_remove_until_first_and_last_become_equal() {

        GlueList<String> glueList = new GlueList<>(2);
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");
        glueList.add("4");

        glueList.remove(3);
        glueList.remove(2);
        assertEquals(2, glueList.size());

        glueList.remove(1);
        glueList.remove(0);
        assertEquals(0, glueList.size());

        assertEquals(true, glueList.first == glueList.last);
    }

    @Test
    public void test_remove_and_last_node_has_2_cell() {

        GlueList<String> glueList = new GlueList<>(2);
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");
        glueList.add("4");
        assertEquals(4, glueList.size());

        glueList.remove(0);
        glueList.remove(1);
        assertEquals(2, glueList.size());

        glueList.remove(1);
        glueList.remove(0);
        assertEquals(0, glueList.size());
    }
}
