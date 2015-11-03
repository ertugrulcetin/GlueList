import org.junit.Test;

import java.util.ListIterator;

import static org.junit.Assert.assertEquals;

public class GlueList_19_ListIteratorTest {

    @Test
    public void test_list_iterator_simple() {

        GlueList<String> glueList = new GlueList<>(2);

        glueList.add("0");
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");

        ListIterator<String> listIterator = glueList.listIterator();

        for (int i = 0; i <= 3; i++) {
            assertEquals(true, listIterator.hasNext());
            assertEquals("" + i, listIterator.next());
        }
        for (int i = 3; i >= 0; i--) {
            assertEquals(true, listIterator.hasPrevious());
            assertEquals("" + i, listIterator.previous());
        }


        for (int i = 0; i <= 3; i++) {
            assertEquals(true, listIterator.hasNext());
            assertEquals("" + i, listIterator.next());
        }
        for (int i = 3; i >= 0; i--) {
            assertEquals(true, listIterator.hasPrevious());
            assertEquals("" + i, listIterator.previous());
        }
    }

    @Test
    public void test_list_iterator_go_to_end_and_back_to_beginning() {

        GlueList<String> glueList = new GlueList<>();
        for (int i = 0; i <= 5; i++) {
            glueList.add("" + i);
        }

        ListIterator<String> listIterator = glueList.listIterator();

        for (int i = 0; i <= 5; i++) {
            assertEquals(true, listIterator.hasNext());
            assertEquals("" + i, listIterator.next());
        }
        for (int i = 5; i >= 0; i--) {
            assertEquals(true, listIterator.hasPrevious());
            assertEquals("" + i, listIterator.previous());
        }


        for (int i = 0; i <= 5; i++) {
            assertEquals(true, listIterator.hasNext());
            assertEquals("" + i, listIterator.next());
        }
        for (int i = 5; i >= 0; i--) {
            assertEquals(true, listIterator.hasPrevious());
            assertEquals("" + i, listIterator.previous());
        }

        assertEquals(true, TestUtil.isFirstAndLastNodesAreEqual(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_go_to_end_and_back_to_beginning_with_moving_node_to_node() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i <= 100; i++) {
            glueList.add("" + i);
        }


        ListIterator<String> listIterator = glueList.listIterator();


        for (int i = 0; i <= 100; i++) {
            assertEquals(true, listIterator.hasNext());
            assertEquals("" + i, listIterator.next());
        }
        for (int i = 100; i >= 0; i--) {
            assertEquals(true, listIterator.hasPrevious());
            assertEquals("" + i, listIterator.previous());
        }


        for (int i = 0; i <= 100; i++) {
            assertEquals(true, listIterator.hasNext());
            assertEquals("" + i, listIterator.next());
        }
        for (int i = 100; i >= 0; i--) {
            assertEquals(true, listIterator.hasPrevious());
            assertEquals("" + i, listIterator.previous());
        }


        for (int i = 0; i <= 100; i++) {
            assertEquals(true, listIterator.hasNext());
            assertEquals("" + i, listIterator.next());
        }
        for (int i = 100; i >= 0; i--) {
            assertEquals(true, listIterator.hasPrevious());
            assertEquals("" + i, listIterator.previous());
        }


        for (int i = 0; i <= 100; i++) {
            assertEquals(true, listIterator.hasNext());
            assertEquals("" + i, listIterator.next());
        }
        for (int i = 100; i >= 0; i--) {
            assertEquals(true, listIterator.hasPrevious());
            assertEquals("" + i, listIterator.previous());
        }

        assertEquals(101, glueList.size());
        assertEquals(false, TestUtil.isFirstAndLastNodesAreEqual(glueList));
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_random_generated_values_iteration() {


        for (int i = 0; i < 1_000; i++) {

            int generatedValue = (int) (Math.random() * 10_000);
            while (generatedValue == 0) {
                generatedValue = (int) (Math.random() * 10_000);
            }

            GlueList<String> glueList = new GlueList<>(2);

            for (int j = 0; j <= generatedValue; j++) {
                glueList.add("" + j);
            }

            ListIterator<String> listIterator = glueList.listIterator();

            for (int a = 0; a <= generatedValue; a++) {
                assertEquals(true, listIterator.hasNext());
                assertEquals("" + a, listIterator.next());
            }

            for (int b = generatedValue; b >= 0; b--) {
                assertEquals(true, listIterator.hasPrevious());
                assertEquals("" + b, listIterator.previous());
            }

            for (int c = 0; c <= generatedValue; c++) {
                assertEquals(true, listIterator.hasNext());
                assertEquals("" + c, listIterator.next());
            }

            for (int d = generatedValue; d >= 0; d--) {
                assertEquals(true, listIterator.hasPrevious());
                assertEquals("" + d, listIterator.previous());
            }

            for (int a = 0; a <= generatedValue; a++) {
                assertEquals(true, listIterator.hasNext());
                assertEquals("" + a, listIterator.next());
            }

            for (int b = generatedValue; b >= 0; b--) {
                assertEquals(true, listIterator.hasPrevious());
                assertEquals("" + b, listIterator.previous());
            }

            for (int c = 0; c <= generatedValue; c++) {
                assertEquals(true, listIterator.hasNext());
                assertEquals("" + c, listIterator.next());
            }

            for (int d = generatedValue; d >= 0; d--) {
                assertEquals(true, listIterator.hasPrevious());
                assertEquals("" + d, listIterator.previous());
            }

            assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
            assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
        }
    }

    @Test
    public void test_list_iterator_nex_index_and_pre_index() {

        GlueList<String> glueList = new GlueList<>(2);

        glueList.add("0");
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");

        ListIterator<String> listIterator = glueList.listIterator();

        assertEquals("0", listIterator.next());
        assertEquals(1, listIterator.nextIndex());
        assertEquals(0, listIterator.previousIndex());

        assertEquals("0", listIterator.previous());
        assertEquals(0, listIterator.nextIndex());
        assertEquals(-1, listIterator.previousIndex());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_nex_index_and_pre_index_big_data() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i <= 1_000; i++) {
            glueList.add("" + i);
        }

        ListIterator<String> listIterator = glueList.listIterator();

        for (int i = 0; i <= 1_000; i++) {
            assertEquals("" + i, listIterator.next());
            assertEquals(i + 1, listIterator.nextIndex());
            assertEquals(i, listIterator.previousIndex());
        }

        for (int i = 1_000; i >= 0; i--) {
            assertEquals("" + i, listIterator.previous());
            assertEquals(i, listIterator.nextIndex());
            assertEquals(i - 1, listIterator.previousIndex());
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_set_simple() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i <= 100; i++) {
            glueList.add("" + i);
        }

        ListIterator<String> listIterator = glueList.listIterator();

        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set("X");
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        while (listIterator.hasPrevious()) {
            assertEquals("X", listIterator.previous());
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_add_simple() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i < 5; i++) {
            glueList.add("" + i);
        }

        ListIterator<String> listIterator = glueList.listIterator();

        for (int i = 0; i < 5; i++) {
            assertEquals("" + i, listIterator.next());
        }
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        listIterator.add("5");

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        assertEquals("5", listIterator.previous());
        assertEquals("4", listIterator.previous());
        assertEquals("3", listIterator.previous());
        assertEquals("2", listIterator.previous());
        assertEquals("1", listIterator.previous());
        assertEquals("0", listIterator.previous());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        for (int i = 0; i < 6; i++) {
            assertEquals("" + i, listIterator.next());
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        listIterator.remove();
        listIterator.previous();
        listIterator.remove();

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        for (int i = 3; i >= 0; i--) {
            assertEquals("" + i, listIterator.previous());
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_add_2() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i < 10; i++) {
            glueList.add("" + i);
        }

        ListIterator<String> listIterator = glueList.listIterator();


        for (int i = 0; i < 7; i++) {
            listIterator.next();
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));

        listIterator.add("X");

        assertEquals("7", listIterator.next());
        assertEquals("8", listIterator.next());
        assertEquals("9", listIterator.next());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_add_3() {

        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i < 10; i++) {
            glueList.add("" + i);
        }


        ListIterator<String> listIterator = glueList.listIterator();

        for (int i = 0; i < 7; i++) {
            listIterator.next();
        }

        listIterator.add("X");
        listIterator.add("X");

        assertEquals("7", listIterator.next());
        assertEquals("8", listIterator.next());
        assertEquals("9", listIterator.next());

        assertEquals("9", listIterator.previous());
        assertEquals("8", listIterator.previous());
        assertEquals("7", listIterator.previous());
        assertEquals("X", listIterator.previous());
        assertEquals("X", listIterator.previous());
        assertEquals("6", listIterator.previous());
        assertEquals("5", listIterator.previous());
        assertEquals("4", listIterator.previous());
        assertEquals("3", listIterator.previous());
        assertEquals("2", listIterator.previous());
        assertEquals("1", listIterator.previous());
        assertEquals("0", listIterator.previous());

        assertEquals(false, listIterator.hasPrevious());
        assertEquals(true, listIterator.hasNext());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_constructor_1() {

        GlueList<String> glueList = new GlueList<>();
        for (int i = 0; i < 10; i++) {
            glueList.add("" + i);
        }

        ListIterator<String> listIterator = glueList.listIterator(5);

        for (int i = 5; i <= 9; i++) {
            assertEquals("" + i, listIterator.next());
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_constructor_2() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 10; i++) {
            glueList.add("" + i);
        }

        ListIterator<String> listIterator = glueList.listIterator(7);

        assertEquals("6", listIterator.previous());
        assertEquals("5", listIterator.previous());
        assertEquals("4", listIterator.previous());
        assertEquals("3", listIterator.previous());
        assertEquals("2", listIterator.previous());
        assertEquals("1", listIterator.previous());
        assertEquals("0", listIterator.previous());

        for (int i = 0; i < 10; i++) {
            assertEquals("" + i, listIterator.next());
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_constructor_3() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 10; i++) {
            glueList.add("" + i);
        }

        ListIterator<String> listIterator = glueList.listIterator(10);

        assertEquals("9", listIterator.previous());
        assertEquals("8", listIterator.previous());
        assertEquals("7", listIterator.previous());
        assertEquals("6", listIterator.previous());
        assertEquals("5", listIterator.previous());
        assertEquals("4", listIterator.previous());
        assertEquals("3", listIterator.previous());
        assertEquals("2", listIterator.previous());
        assertEquals("1", listIterator.previous());
        assertEquals("0", listIterator.previous());

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_list_iterator_constructor_4() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 100; i++) {
            glueList.add("" + i);
        }

        ListIterator<String> listIterator = glueList.listIterator(32);

        for (int i = 32; i < 100; i++) {
            assertEquals("" + i, listIterator.next());
        }

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}
