import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class GlueListIterativeTest {

    @Test
    public void testIterative() {


        GlueList<String> a = new GlueList<>(2);
        a.add("1");
        a.add("2");
        for (String s : a) {
            System.out.println(s);
        }

        for (String s : a) {
            System.out.println(s);
        }

        Iterator<String> iterator = a.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }

    @Test
    public void testIterateBigData(){

        GlueList<Integer> list = new GlueList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void testToString(){

        GlueList<Integer> list = new GlueList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        System.out.println(list);
    }
}
