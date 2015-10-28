import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GlueList_3_AddWithIndexTest {

    @Test
    public void test_add_index_0() {

        GlueList<String> glueList = new GlueList<>(2);

        glueList.add(0, "Ertu");
        glueList.add(0, "Can");
        assertEquals(2, glueList.size());

        glueList.add(0, "Selin");
        glueList.add(0, "İrem");
        assertEquals(4, glueList.size());

        glueList.add(0, "Berk");
        glueList.add(0, "Kerem");
        assertEquals(6, glueList.size());
    }

    //adds last node...
    @Test
    public void test_add_after_add_index() {

        GlueList<String> glueList = new GlueList<>(2);

        glueList.add("Ertu");
        glueList.add("Can");
        assertEquals(2, glueList.size());

        glueList.add(2, "Can");
        glueList.add(3, "Kerem");
        assertEquals(4, glueList.size());

        glueList.add(4, "Selçuk");
        glueList.add(5, "Mehmet");
        assertEquals(6, glueList.size());

        glueList.add(6, "Burak");
        assertEquals(7, glueList.size());
    }

    @Test
    public void test() {

        ArrayList<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");

        a.add(2, "3");
    }
}
