import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_13_TrimToSizeTest {

    @Test
    public void test_trim_to_size_1() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i < 15; i++) {
            glueList.add("" + i);
        }
        assertEquals(15, glueList.size());

        glueList.trimToSize();
        assertEquals(15, glueList.size());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_trim_to_size_2() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i < 14; i++) {
            glueList.add("" + i);
        }
        assertEquals(14, glueList.size());

        glueList.trimToSize();
        assertEquals(14, glueList.size());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_trim_to_size_3() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i <= 17; i++) {
            glueList.add("" + i);
        }
        assertEquals(18, glueList.size());


        glueList.trimToSize();
        assertEquals(18, glueList.size());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_trim_to_size_4() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i <= 18; i++) {
            glueList.add("" + i);
        }
        assertEquals(19, glueList.size());

        glueList.trimToSize();
        assertEquals(19, glueList.size());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_trim_to_size_5() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i < 14; i++) {
            glueList.add("" + i);
        }
        assertEquals(14, glueList.size());


        glueList.trimToSize();
        assertEquals(14, glueList.size());

        glueList.add("14");
        glueList.add("15");


        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_trim_to_size_6() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i < 1_000; i++) {
            glueList.add("" + i);
        }

        assertEquals(1_000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.trimToSize();

        assertEquals(1_000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        for (int i = 1_000; i < 3_000; i++) {
            glueList.add("" + i);
            glueList.trimToSize();
        }

        assertEquals(3_000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        for (int i = 0; i < 500; i++) {
            glueList.remove(i);
        }
        assertEquals(2_500, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.trimToSize();

        assertEquals(2_500, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        for (int i = 0; i < 500; i++) {
            glueList.add("" + i);
            glueList.trimToSize();
        }
        glueList.trimToSize();

        assertEquals(3_000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        assertEquals(3_000, glueList.size());
        assertEquals(false, TestUtil.isFirstAndLastNodesAreEqual(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_trim_to_size_7() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i < 14; i++) {
            glueList.add("" + i);
        }
        assertEquals(14, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.trimToSize();
        assertEquals(14, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.remove("13");
        assertEquals(13, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        for (int i = 0; i < 8; i++) {
            glueList.add("" + (13 + i));
            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }

        assertEquals(21, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}