import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class GlueList_0_Benchmark {

    //    int dataCount = 1_000;
//    int dataCount = 10_000;
//    int dataCount = 100_000;
//    int dataCount = 500_000;
//    int dataCount = 1_000_000;
//    int dataCount = 5_000_000;
    int dataCount = 10_000_000;

  /*  @Test
    public void testPerformanceTest() {


        GapList<Integer> gapList = new GapList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount; i++) {
            gapList.add(i);
        }
        e = System.currentTimeMillis();

        System.out.println("Gap List: " + (e - s));
    }
*/

    @Test
    public void testGlueList() {

        GlueList<Integer> myList = new GlueList<>();

        long s, e;
        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount; i++) {
            myList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("My List: " + (e - s));

        TestUtil.printNodesInfo(myList);
    }

    @Test
    public void testArrayList() {

        ArrayList<Integer> arrList = new ArrayList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount; i++) {
            arrList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("ArrList: " + (e - s));
    }

    @Test
    public void testLinkedList() {

        LinkedList<Integer> linkedList = new LinkedList<>();


        long s, e;

        s = System.currentTimeMillis();
       /* for (String integer : linkedList) {
//                System.out.println(integer);
        }*/
        for (int i = 0; i < dataCount; i++) {
            linkedList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("Linked List: " + (e - s));
    }
}
