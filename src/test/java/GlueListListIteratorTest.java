import org.junit.Test;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class GlueListListIteratorTest {

    @Test
    public void testSimpleListIterator() {

        GlueList<Integer> list = new GlueList<>();
        for (int i = 0; i <= 100; i++) {
            list.add(i);
        }

        ListIterator<Integer> listIterator = list.listIterator();
        System.out.println(listIterator.next());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.previous());

    }

    @Test(expected = NoSuchElementException.class)
    public void testThrowNoElement() {

        GlueList<Integer> a = new GlueList<>();
        a.add(1);
        a.add(2);

        ListIterator<Integer> listIterator = a.listIterator();
        System.out.println(listIterator.next());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.previous());

    }
}
