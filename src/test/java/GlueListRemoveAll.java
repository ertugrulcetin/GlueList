import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GlueListRemoveAll {

    @Test
    public void testRemoveAll() {

        GlueList<Integer> a = new GlueList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        List<Integer> b = new ArrayList<>();
        b.add(0);
        b.add(2);
        b.add(3);

        boolean as = b.removeAll(a);

        a.removeAll(b);

        System.out.println(a);
    }
}
