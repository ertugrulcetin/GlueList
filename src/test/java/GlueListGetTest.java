import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GlueListGetTest {

    @Test
    public void testSimpleGet() {

        GlueList<String> list = new GlueList<>(2);
        list.add("ertu"); // 0
        list.add("selin");// 1
        list.add("cansu");// 2
        list.add("kerem");// 3
        list.add("burcu");// 4
        list.add("mehmet");// 5
        list.add("boğa");// 6
        list.add("osman");// 7
        list.add("aysun");// 8
        list.add("emre");// 9
        list.add("demir");// 10
        list.add("kıvanç");// 11
        list.add(null);// 12

        assertEquals("ertu", list.get(0));
        assertEquals("selin", list.get(1));
        assertEquals("cansu", list.get(2));
        assertEquals("kerem", list.get(3));
        assertEquals("burcu", list.get(4));
        assertEquals("mehmet", list.get(5));
        assertEquals("boğa", list.get(6));
        assertEquals("osman", list.get(7));
        assertEquals("aysun", list.get(8));
        assertEquals("emre", list.get(9));
        assertEquals("demir", list.get(10));
        assertEquals("kıvanç", list.get(11));
        assertEquals(null, list.get(12));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGet0Index() {

        GlueList<Integer> list = new GlueList<>();
        System.out.println(list.get(0));
    }
}