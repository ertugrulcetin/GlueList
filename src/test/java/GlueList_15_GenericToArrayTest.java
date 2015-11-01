import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GlueList_15_GenericToArrayTest {
    @Test
    public void test_generic_to_array_size_0() {

        GlueList<String> glueList = new GlueList<>();

        Object[] objectArr = glueList.toArray(new String[0]);

        assertEquals(String[].class, objectArr.getClass());

        List<Object> list = Arrays.asList(objectArr);
        assertEquals(true, glueList.equals(list));

        assertEquals(0, objectArr.length);
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }


    @Test
    public void test_generic_to_array_size_1() {

        GlueList<Integer> glueList = new GlueList<>();
        glueList.add(1);

        Object[] objectArr = glueList.toArray(new Integer[1]);

        assertEquals(Integer[].class, objectArr.getClass());

        List<Object> list = Arrays.asList(objectArr);
        assertEquals(true, glueList.equals(list));

        assertEquals(1, objectArr.length);
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }

    @Test
    public void test_generic_to_array_size_15() {

        GlueList<Integer> glueList = new GlueList<>();
        for (int i = 0; i < 15; i++) {
            glueList.add(i);
        }

        Object[] objectArr = glueList.toArray(new Integer[15]);
        assertEquals(Integer[].class, objectArr.getClass());


        List<Object> list = Arrays.asList(objectArr);
        assertEquals(true, glueList.equals(list));

        assertEquals(15, objectArr.length);
        assertEquals(true, TestUtil.isNodesStartingAndEndingIndexesAreTrue(glueList));
        assertEquals(true, TestUtil.isNodesElementDataPointerSameWithNodeArrayLength(glueList));
    }
}
