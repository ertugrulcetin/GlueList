import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GlueListAddIterator {

    @Test
    public void testAddIterator() {

        GlueList<Integer> glueList = new GlueList<>();

        ListIterator<Integer> listIterator = glueList.listIterator();
        listIterator.add(1);
//
        System.out.println(glueList);

        List<Integer> list = new ArrayList<>();

        ListIterator<Integer> arrListItr = list.listIterator();
        arrListItr.add(1);
        System.out.println(list);
    }
}
