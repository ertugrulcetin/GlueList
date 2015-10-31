import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_3_AddWithIndexTest {

    @Test
    public void test_add_index_0() {

        GlueList<String> glueList = new GlueList<>(2);

        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add(0, "Ertu");
        glueList.add(0, "Can");
        assertEquals(2, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add(0, "Selin");
        glueList.add(0, "İrem");
        assertEquals(4, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add(0, "Berk");
        glueList.add(0, "Kerem");
        assertEquals(6, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    //adds last node...
    @Test
    public void test_add_after_add_index() {

        GlueList<String> glueList = new GlueList<>(2);

        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add("Ertu");
        glueList.add("Can");
        assertEquals(2, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add(2, "Can");
        glueList.add(3, "Kerem");
        assertEquals(4, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add(4, "Selçuk");
        glueList.add(5, "Mehmet");
        assertEquals(6, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add(6, "Burak");
        assertEquals(7, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_amid() {

        GlueList<String> glueList = new GlueList<>(2);

        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add("a");
        glueList.add("b");
        assertEquals(2, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add("c");
        glueList.add("d");
        assertEquals(4, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add("e");
        glueList.add("f");
        assertEquals(6, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add("g");
        glueList.add("h");
        assertEquals(8, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add("i");
        glueList.add("j");
        assertEquals(10, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add(2, "x");
        glueList.add(3, "y");
        assertEquals(12, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_add_fail() {

        GlueList<String> glueList = new GlueList<>(2);

        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add("a");
        glueList.add("b");
        assertEquals(2, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.add(3, "c");
    }

    @Test
    public void test_add_big_data() {

        GlueList<String> glueList = new GlueList<>(2);

        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        for (int i = 0; i < 100; i++) {
            glueList.add("a");
            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }

        glueList.add(9, "X");
        glueList.add(14, "X");
        assertEquals(102, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        assertEquals("X", glueList.get(9));
        assertEquals("X", glueList.get(14));

        glueList.add(102, "C");
        assertEquals(103, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}