import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_10_RemoveAllTest {

    @Test
    public void test_remove_all_simple() {

        GlueList<String> glueList = new GlueList<>();

        GlueList<String> tempList = new GlueList<>();
        for (int i = 0; i < 100; i++) {
            tempList.add("" + i);
            glueList.add("" + i);

            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        assertEquals(100, glueList.size());

        glueList.removeAll(tempList);

        assertEquals(0, glueList.size());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_remove_all_return_val() {

        GlueList<String> glueList = new GlueList<>();
        glueList.add("" + 1);
        glueList.add("" + 2);
        glueList.add("" + 3);

        GlueList<String> tempList = new GlueList<>();
        tempList.add("" + 4);
        tempList.add("" + 5);
        tempList.add("" + 6);

        boolean result = glueList.removeAll(tempList);

        assertEquals(false, result);
        assertEquals(3, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_remove_all_return_val_2() {

        GlueList<String> glueList = new GlueList<>();
        glueList.add("" + 1);
        glueList.add("" + 2);
        glueList.add("" + 3);
        glueList.add("" + 8);

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        GlueList<String> tempList = new GlueList<>();
        tempList.add("" + 4);
        tempList.add("" + 5);
        tempList.add("" + 6);
        tempList.add("" + 8);


        boolean result = glueList.removeAll(tempList);

        assertEquals(true, result);
        assertEquals(3, glueList.size());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}