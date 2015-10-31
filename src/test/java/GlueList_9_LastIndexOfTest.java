import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_9_LastIndexOfTest {

    @Test
    public void test_last_index_of_simple() {

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

        assertEquals(0, glueList.lastIndexOf("0"));
        assertEquals(1, glueList.lastIndexOf("1"));
        assertEquals(2, glueList.lastIndexOf("2"));
        assertEquals(3, glueList.lastIndexOf("3"));
        assertEquals(4, glueList.lastIndexOf("4"));
        assertEquals(5, glueList.lastIndexOf("5"));
        assertEquals(6, glueList.lastIndexOf("6"));
        assertEquals(8, glueList.lastIndexOf(null));

        assertEquals(-1, glueList.lastIndexOf("7"));

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_last_index_of_big_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 1_000; i++) {
            glueList.add("" + i);
            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }

        for (int i = 0; i < 1_000; i++) {
            assertEquals(i, glueList.lastIndexOf("" + i));
            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }

        assertEquals(-1, glueList.lastIndexOf("try me again !"));

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}