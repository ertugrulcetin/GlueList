import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GlueListRetainAll {

    @Test
    public void testRetainAll(){

        GlueList<Integer> a = new GlueList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        a.retainAll(list);

        System.out.println(a);

    }


}
