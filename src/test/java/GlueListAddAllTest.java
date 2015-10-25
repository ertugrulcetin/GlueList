import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GlueListAddAllTest {

    @Test
    public void testSimpleAddAll(){

        GlueList<Integer> list = new GlueList<>();

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        list.addAll(a);
        System.out.println(list);
    }

    @Test
    public void testAddAllSimple(){

        GlueList<Integer> list = new GlueList<>(5);

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        List<Integer> b = new ArrayList<>();
        b.add(8);
        b.add(8);



        list.addAll(a);
        list.addAll(b);
        System.out.println(list);
    }
}
