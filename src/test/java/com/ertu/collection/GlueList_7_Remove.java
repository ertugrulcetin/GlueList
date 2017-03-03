package com.ertu.collection;

import org.junit.Test;

import com.ertu.collection.GlueList;

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

        assertEquals(true, TestUtil.isFirstAndLastNodesAreEqual(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
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
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.remove(1);
        glueList.remove(0);
        assertEquals(0, glueList.size());

        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
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
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.remove(1);
        glueList.remove(0);

        assertEquals(0, glueList.size());
        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_remove_big_data() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 10_000; i++) {
            glueList.add("" + i);
            assertEquals(i + 1, glueList.size());
        }

        assertEquals(10_000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        for (int i = 0; i < 5_000; i++) {
            glueList.remove("" + i);
        }

        assertEquals(5_000, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        for (int i = 5_000; i < 10_000; i++) {
            glueList.remove("" + i);
        }

        assertEquals(0, glueList.size());
        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_remove_with_get() {

        GlueList<String> glueList = new GlueList<>(2);
        glueList.add("a");//0
        glueList.add("b");//1
        glueList.add("c");//2
        glueList.add("d");//3
        glueList.add("e");//4
        glueList.add("f");//5
        glueList.add("g");//6
        glueList.add("h");//7
        glueList.add("i");//8
        glueList.add("j");//9

        glueList.remove("i");
        assertEquals("j", glueList.get(8));
        assertEquals(9, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.remove(8);
        assertEquals("h", glueList.get(7));
        assertEquals(8, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.remove("a");
        glueList.remove("b");
        assertEquals("f", glueList.get(3));
        assertEquals(6, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        assertEquals("c", glueList.remove(0));
        assertEquals("g", glueList.remove(3));
        assertEquals(4, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        assertEquals(true, glueList.remove("f"));
        assertEquals(3, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        glueList.remove(0);
        glueList.remove(0);
        glueList.remove(0);
        assertEquals(0, glueList.size());

        assertEquals(false, glueList.remove("a"));
        assertEquals(false, glueList.remove("b"));
        assertEquals(false, glueList.remove("c"));
        assertEquals(false, glueList.remove("d"));
        assertEquals(false, glueList.remove("e"));
        assertEquals(false, glueList.remove("f"));
        assertEquals(false, glueList.remove("g"));
        assertEquals(false, glueList.remove("h"));
        assertEquals(false, glueList.remove("i"));
        assertEquals(false, glueList.remove("j"));

        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_remove_each_deletion() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 1_000; i++) {
            glueList.add("" + i);
        }

        GlueList<String> tempGlueList = new GlueList<>(glueList);

        int i = 0;
        while (glueList.size() != 0) {

            assertEquals(tempGlueList.get(i++), glueList.remove(0));

            assertEquals(tempGlueList.size() - i, glueList.size());

            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }

        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}
