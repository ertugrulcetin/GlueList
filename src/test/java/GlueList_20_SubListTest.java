import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_20_SubListTest {

    @Test
    public void test_sub_list_simple() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 10; i++) {
            glueList.add("" + i);
        }

        GlueList<String> tempList = new GlueList<>(glueList.subList(0, 10));

        assertEquals(true, glueList.equals(tempList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(tempList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(tempList));
    }

    @Test
    public void test_sub_list_big_data() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 10_000; i++) {
            glueList.add("" + i);
        }

        GlueList<String> tempList = new GlueList<>(glueList.subList(0, 10_000));

        assertEquals(true, glueList.equals(tempList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(tempList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(tempList));
    }

    @Test
    public void test_sub_list_big_data_2() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 10_000; i++) {
            glueList.add("" + i);
        }

        GlueList<String> tempList = new GlueList<>(glueList.subList(5_000, 6501));

        GlueList<String> temp2 = new GlueList<>();
        for (int i = 5000; i <= 6500; i++) {
            temp2.add("" + i);
        }


        assertEquals(true, temp2.equals(tempList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(tempList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(tempList));
    }
}
