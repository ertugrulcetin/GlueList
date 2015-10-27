import org.junit.Test;

import java.util.List;
import java.util.ListIterator;

public class GlueListIteratorSet {

    @Test
    public void testIteratorSet() {


        List<Integer> glueList = new GlueList<>();
        for (int i = 0; i < 10; i++) {
            glueList.add(0);
        }

        ListIterator<Integer> listIterator = glueList.listIterator();
        listIterator.next();
        listIterator.set(1);
        System.out.println(listIterator.previous());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
    }
}
