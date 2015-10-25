import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {


    @Test
    public void testPerformanceTest() {

       /* try {
            System.out.println("Program is getting ready...");
            Thread.sleep(5000);
            System.out.println("Program is starting...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

            String a = "asda";
        int b = 2;

        int dataCount = 1_000;

        GlueList<Integer> myList = new GlueList<>();
        ArrayList<Integer> arrList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100_000; i++) {
            list.add(i);
        }

        long s, e;

        {
            s = System.currentTimeMillis();
            for (int i = 0; i < dataCount; i++) {
                myList.addAll(list);
            }
            e = System.currentTimeMillis();
            System.out.println("My List: " + (e - s));
        }

        /*{
            s = System.currentTimeMillis();
            for (int i = 0; i < dataCount; i++) {
                arrList.addAll(list);
            }
            e = System.currentTimeMillis();
            System.out.println("Array List: " + (e - s));
        }*/

        /*{
            s = System.currentTimeMillis();
            for (int i = 0; i < dataCount; i++) {
                linkedList.addAll(list);
            }
            e = System.currentTimeMillis();
            System.out.println("Linked List: " + (e - s));
        }*/
    }
}
