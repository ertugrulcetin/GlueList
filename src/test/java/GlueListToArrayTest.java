import org.junit.Test;

import java.util.Arrays;

public class GlueListToArrayTest {


    @Test
    public void testSimpleToArray() {

        GlueList<Integer> l = new GlueList<>(20);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        System.out.println(Arrays.toString(l.toArray()));
    }

    @Test
    public void testSimpleGenericToArray() {

        GlueList<Integer> l = new GlueList<>(20);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        System.out.println(Arrays.toString(l.toArray(new Integer[1])));
    }
}
