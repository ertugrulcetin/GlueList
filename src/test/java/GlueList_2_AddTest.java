import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_2_AddTest {

    @Test
    public void test_add_few_data() {

        GlueList<String> glueList = new GlueList<>();

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

        assertEquals(10, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_100_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 100; i++) {
            glueList.add("" + i);
        }

        assertEquals(100, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_1000_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 1000; i++) {
            glueList.add("" + i);
        }

        assertEquals(1000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_10_000_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 10_000; i++) {
            glueList.add("" + i);
        }

        assertEquals(10_000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_100_000_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 100_000; i++) {
            glueList.add("" + i);
        }

        assertEquals(100_000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_1_000_000_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 1_000_000; i++) {
            glueList.add("" + i);
        }


        assertEquals(1_000_000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_10_000_000_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 10_000_000; i++) {
            glueList.add("" + i);
        }

        assertEquals(10_000_000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}