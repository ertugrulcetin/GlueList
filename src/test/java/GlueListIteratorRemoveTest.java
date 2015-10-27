import org.junit.Test;

import java.util.Iterator;

public class GlueListIteratorRemoveTest {

    @Test
    public void testIteratorRemove(){

        GlueList<Integer> a = new GlueList<>();

        a.add(1);
        a.add(2);

        Iterator<Integer> iterator = a.iterator();
        iterator.next();
        iterator.remove();
        System.out.println(iterator.next());
        iterator.remove();

        System.out.println(a);

    }
}
