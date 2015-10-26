import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPerformanceTest {

    int dataCount = 30_000_000;

    @Test
    public void testPerformanceTest() {

    }

    @Test
    public void testGlueList() {

        GlueList<Integer> myList = new GlueList<>();

        for (int i = 0; i < dataCount; i++) {
            myList.add(i);
        }

        long s, e;

        s = System.currentTimeMillis();
        for (Integer integer : myList) {
//                System.out.println(integer);
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
        for (Integer integer : arrList) {
//                System.out.println(integer);
        }
        e = System.currentTimeMillis();
        System.out.println("Array List: " + (e - s));
    }

    @Test
    public void testLinkedList() {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < dataCount; i++) {
            linkedList.add(i);
        }

        long s, e;

        s = System.currentTimeMillis();
        for (Integer integer : linkedList) {
//                System.out.println(integer);
        }
        e = System.currentTimeMillis();
        System.out.println("Linked List: " + (e - s));
    }
}
