import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPerformanceTest {

    //    int dataCount = 1_000;
//    int dataCount = 10_000;
//    int dataCount = 100_000;
//    int dataCount = 500_000;
//    int dataCount = 1_000_000;
    int dataCount = 5_000_000;
//    int dataCount = 10_000_000;

    /*  @Test
      public void testPerformanceTest() {


          TreeList<Integer> treeList = new TreeList<>();

          long s, e;

          s = System.currentTimeMillis();
          for (int i = 0; i < dataCount; i++) {
              treeList.add(i);
          }
          e = System.currentTimeMillis();
          System.out.println("TreeList: " + (e - s));
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
    }

    @Test
    public void testArrayList() {

        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < dataCount; i++) {
            arrList.add(i);
        }

        long s, e;

        s = System.currentTimeMillis();
       /* for (String integer : arrList) {
//                System.out.println(integer);
        }*/
        int i = 0, j = arrList.size();
        for (; i < j; i++) {

            arrList.remove(i);
            i = 0;
            j = arrList.size();
        }
        arrList.remove(0);
//        arrList.removeAll(tempList);
        e = System.currentTimeMillis();
        System.out.println("Array List: " + (e - s));
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
