import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_8_IndexOfTest {

    @Test
    public void test_index_of_simple() {

        GlueList<String> glueList = new GlueList<>();
        glueList.add("0");
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");
        glueList.add("4");
        glueList.add("5");
        glueList.add("6");
        glueList.add(null);
        glueList.add(null);

        assertEquals(9, glueList.size());

        assertEquals(0, glueList.indexOf("0"));
        assertEquals(1, glueList.indexOf("1"));
        assertEquals(2, glueList.indexOf("2"));
        assertEquals(3, glueList.indexOf("3"));
        assertEquals(4, glueList.indexOf("4"));
        assertEquals(5, glueList.indexOf("5"));
        assertEquals(6, glueList.indexOf("6"));
        assertEquals(7, glueList.indexOf(null));

        assertEquals(-1, glueList.indexOf("7"));

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_index_of_big_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 1_000; i++) {
            glueList.add("" + i);
            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }

        for (int i = 0; i < 1_000; i++) {
            assertEquals(i, glueList.indexOf("" + i));
            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }

        assertEquals(-1, glueList.indexOf("try me !"));

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}