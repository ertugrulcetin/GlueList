import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPerformanceTest {

    int dataCount = 10_000_000;

    @Test
    public void testPerformanceTest() {

    }

    @Test
    public void testGlueList() {

        GlueList<Integer> myList = new GlueList<>();

        long s, e;

        s = System.currentTimeMillis();
        /*for (String integer : myList) {
//                System.out.println(integer);
        }*/
        for (int i = 0; i < dataCount; i++) {
            myList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("My List: " + (e - s));
    }

    @Test
    public void testArrayList() {

        ArrayList<Integer> arrList = new ArrayList<>();


        long s, e;

        s = System.currentTimeMillis();
       /* for (String integer : arrList) {
//                System.out.println(integer);
        }*/
        for (int i = 0; i < dataCount; i++) {
            arrList.add(i);
        }
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
