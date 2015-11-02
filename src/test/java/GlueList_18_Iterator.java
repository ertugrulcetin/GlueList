import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class GlueList_18_Iterator {

    @Test
    public void test_iterator_has_next() {

        GlueList<String> glueList = new GlueList<>();
        for (int i = 0; i < 10; i++) {
            glueList.add("" + i);
        }

        Iterator<String> iterator = glueList.iterator();

        assertEquals(true, iterator.hasNext());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_iterator_simple() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 10; i++) {
            glueList.add("" + i);
        }

        Iterator<String> iterator = glueList.iterator();

        for (int i = 0; i < 10; i++) {

            assertEquals(true, iterator.hasNext());
            assertEquals("" + i, iterator.next());

            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }

        assertEquals(false, iterator.hasNext());

        assertEquals(false, TestUtil.isFirstAndLastNodesAreEqual(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test(expected = NoSuchElementException.class)
    public void test_iterator_fail() {

        GlueList<String> glueList = new GlueList<>();
        for (int i = 0; i < 5; i++) {
            glueList.add("" + i);
        }

        Iterator<String> iterator = glueList.iterator();

        for (int i = 0; i < 5; i++) {
            assertEquals("" + i, iterator.next());
        }

        assertEquals("6", iterator.next());
    }

    @Test(expected = IllegalStateException.class)
    public void test_iterator_remove_fail() {

        GlueList<String> glueList = new GlueList<>();
        for (int i = 0; i < 5; i++) {
            glueList.add("" + i);
        }

        Iterator<String> iterator = glueList.iterator();
        iterator.remove();
    }

    @Test
    public void test_iterator_remove_simple() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 5; i++) {
            glueList.add("" + i);
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        Iterator<String> iterator = glueList.iterator();

        int j = glueList.size();
        for (int i = 0; i < 5; i++) {

            assertEquals(true, iterator.hasNext());
            assertEquals("" + i, iterator.next());
            iterator.remove();
            assertEquals(--j, glueList.size());

            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }

        assertEquals(0, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_iterator_remove_2() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 5; i++) {
            glueList.add("" + i);
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        Iterator<String> iterator = glueList.iterator();
        iterator.next();//0
        iterator.next();//1
        iterator.next();//2 - 0
        iterator.remove();//2 - 0

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        assertEquals("3", iterator.next());
        iterator.remove();
        assertEquals("4", iterator.next());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_iterator_remove_3() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 9; i++) {
            glueList.add("" + i);
        }

        Iterator<String> iterator = glueList.iterator();
        iterator.next();//0
        iterator.next();//1
        iterator.next();//2 - 0
        iterator.next();//3 - 0
        iterator.next();//4 - 0
        iterator.remove();//4
        iterator.next();//5 - 0
        iterator.remove();//5

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        assertEquals("6", iterator.next());
        assertEquals("7", iterator.next());
        assertEquals("8", iterator.next());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_iterator_remove_4() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 7; i++) {
            glueList.add("" + i);
        }

        Iterator<String> iterator = glueList.iterator();
        for (int i = 0; i < 7; i++) {
            iterator.next();
        }

        iterator.remove();

        assertEquals(false, iterator.hasNext());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_iterator_remove_big_data() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 100_000; i++) {
            glueList.add("" + i);
        }

        Iterator<String> iterator = glueList.iterator();

        int size = glueList.size();
        for (int i = 0; i < 100_000; i++) {

            assertEquals(true, iterator.hasNext());
            assertEquals("" + i, iterator.next());

            iterator.remove();

            assertEquals(--size, glueList.size());

            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }

        assertEquals(0, glueList.size());
        assertEquals(true, TestUtil.isItCorrectAfterAllDataDeleted(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}