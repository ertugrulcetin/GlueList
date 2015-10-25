import org.junit.Test;

public class GlueListSubListTest {

    @Test
    public void testSubList() {

        GlueList<Integer> list = new GlueList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        System.out.println(list.subList(5, 5));
    }
}
