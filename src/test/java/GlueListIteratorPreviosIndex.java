import org.junit.Test;

import java.util.ListIterator;

public class GlueListIteratorPreviosIndex {

    @Test
    public void testIteratorPreviosIndex(){

        GlueList<Integer> a = new GlueList<>();

        ListIterator<Integer> listIterator  = a.listIterator();
        System.out.println(listIterator.previousIndex());
        System.out.println(listIterator.hasPrevious());

    }

}
