import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GlueList_4_AddAllTest {

    @Test(expected = NullPointerException.class)
    public void test_add_all_fail() {

        GlueList<String> a = new GlueList<>();
        a.addAll(null);
    }

    @Test
    public void test_add_all_false() {

        GlueList<String> glueList = new GlueList<>();

        ArrayList<String> arrayList = new ArrayList<>();

        boolean result = glueList.addAll(arrayList);

        assertEquals(false, result);

        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_all_when_list_just_created() {

        GlueList<String> glueList = new GlueList<>();

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add("" + i);
        }

        glueList.addAll(arrayList);

        assertTrue(glueList.equals(arrayList));
        assertEquals(100, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_all_when_list_just_created_but_has_big_initial_capacity() {

        GlueList<String> glueList = new GlueList<>(100);

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add("" + i);
        }

        glueList.addAll(arrayList);

        assertTrue(glueList.equals(arrayList));
        assertEquals(100, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_all_no_remained_storage() {

        GlueList<String> glueList = new GlueList<>(2);
        glueList.add("1");
        glueList.add("2");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");

        glueList.addAll(arrayList);

        assertEquals(5, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_all_collection_len_less_than_remained_storage() {

        GlueList<String> glueList = new GlueList<>(10);
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");

        glueList.addAll(arrayList);

        assertEquals(10, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_all_collection_len_greater_than_remained_storage() {

        GlueList<String> glueList = new GlueList<>(10);
        glueList.add("1");
        glueList.add("2");
        glueList.add("3");
        glueList.add("4");
        glueList.add("5");
        glueList.add("6");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        arrayList.add("13");

        glueList.addAll(arrayList);

        assertEquals(13, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_add_all_collection_len_greater_than_remained_storage_2() {

        GlueList<String> glueList = new GlueList<>(2);
        glueList.add("1");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");

        glueList.addAll(arrayList);

        assertEquals(10, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}
