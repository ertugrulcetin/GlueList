import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueList_11_RetainAllTest {

    @Test
    public void test_retain_all_simple() {

        GlueList<String> glueList = new GlueList<>();
        for (int i = 0; i < 10; i++) {
            glueList.add("" + i);
        }

        GlueList<String> tempList = new GlueList<>();
        tempList.add("1");
        tempList.add("2");
        tempList.add("3");

        glueList.retainAll(tempList);

        assertEquals(3, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_retain_all_big_data() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 100; i++) {
            glueList.add("" + i);
        }

        GlueList<String> tempList = new GlueList<>();
        tempList.add("51");
        tempList.add("52");
        tempList.add("53");
        tempList.add("54");

        glueList.retainAll(tempList);

        glueList.printClusteredWithAllocations();

        assertEquals(4, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_retain_all_big_data_2() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 100; i++) {
            glueList.add("" + i);
        }

        GlueList<String> tempList = new GlueList<>();
        for (int i = 0; i < 100; i += 5) {
            tempList.add("" + i);
        }

        glueList.printClusteredWithAllocations();

        glueList.retainAll(tempList);

        glueList.printClusteredWithAllocations();

        TestUtil.printNodesInfo(glueList);
        glueList.add("X");
//        glueList.printClusteredWithAllocations();
        TestUtil.printNodesInfo(glueList);


//        assertEquals(20, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_retain_all_small_data() {

        GlueList<String> glueList = new GlueList<>(2);
        for (int i = 0; i < 24; i++) {
            glueList.add("" + i);
        }

        GlueList<String> tempList = new GlueList<>(2);
        for (int i = 0; i < 24; i += 2) {
            tempList.add("" + i);
        }

        glueList.printClusteredWithAllocations();
        TestUtil.printNodesInfo(glueList);
        System.out.println("Size: " + glueList.size());
        System.out.println();
        System.out.println();

        glueList.retainAll(tempList);
        glueList.printClusteredWithAllocations();
        TestUtil.printNodesInfo(glueList);
        System.out.println("Size: " + glueList.size());
        System.out.println();
        System.out.println();



        System.out.println();
        System.out.println();

        glueList.add("X");

        for (int i = 0; i < 200; i++) {
            glueList.add("a");
        }
            glueList.add("a");

        glueList.printClusteredWithAllocations();
        TestUtil.printNodesInfo(glueList);
        glueList.printClusteredWithAllocations();

//        assertEquals(4, glueList.size());
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}
