package com.ertu.collection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ertu.collection.GlueList;

public class GlueList_12_ClearTest {

    @Test
    public void test_clear_size() {

        GlueList<String> glueList = new GlueList<>();
        for (int i = 0; i < 20; i++) {
            glueList.add("" + i);
        }
        assertEquals(20, glueList.size());

        glueList.clear();
        assertEquals(0, glueList.size());
        assertEquals(20, glueList.getInitialCapacity());
        assertEquals(true, TestUtil.isFirstAndLastNodesAreEqual(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_clear_initial_size() {

        GlueList<String> glueList = new GlueList<>(30);
        for (int i = 0; i < 20; i++) {
            glueList.add("" + i);
        }
        assertEquals(20, glueList.size());

        glueList.clear();

        assertEquals(0, glueList.size());
        assertEquals(30, glueList.getInitialCapacity());
        assertEquals(true, TestUtil.isFirstAndLastNodesAreEqual(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_clear_default_size() {

        GlueList<String> glueList = new GlueList<>();
        for (int i = 0; i < 5; i++) {
            glueList.add("" + i);
        }
        assertEquals(5, glueList.size());

        glueList.clear();

        assertEquals(0, glueList.size());
        assertEquals(10, glueList.getInitialCapacity());
        assertEquals(true, TestUtil.isFirstAndLastNodesAreEqual(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}
