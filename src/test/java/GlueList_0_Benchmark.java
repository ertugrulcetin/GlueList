import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Run tests one by one...
 */

public class GlueList_0_Benchmark {

    int dataCount500k = 500_000;
    int dataCount1m = 1_000_000;
    int dataCount10m = 10_000_000;


    @Test
    public void test_1_add_500k_linked_list() {

        List<Integer> linkedList = new LinkedList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount500k; i++) {
            linkedList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("LinkedList: " + (e - s));
    }

    @Test
    public void test_2_add_500k_array_list() {

        List<Integer> arrayList = new ArrayList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount500k; i++) {
            arrayList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("ArrayList: " + (e - s));
    }

    @Test
    public void test_3_add_500k_glue_list() {

        List<Integer> glueList = new GlueList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount500k; i++) {
            glueList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("GlueList: " + (e - s));
    }

    @Test
    public void test_4_add_1m_linked_list() {

        List<Integer> linkedList = new LinkedList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount1m; i++) {
            linkedList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("LinkedList: " + (e - s));
    }

    @Test
    public void test_5_add_1m_array_list() {

        List<Integer> arrayList = new ArrayList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount1m; i++) {
            arrayList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("ArrayList: " + (e - s));
    }

    @Test
    public void test_6_add_1m_glue_list() {

        List<Integer> glueList = new GlueList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount1m; i++) {
            glueList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("GlueList: " + (e - s));
    }

    @Test
    public void test_7_add_10m_linked_list() {

        List<Integer> linkedList = new LinkedList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount10m; i++) {
            linkedList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("LinkedList: " + (e - s));
    }

    @Test
    public void test_8_add_10m_array_list() {

        List<Integer> arrayList = new ArrayList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount10m; i++) {
            arrayList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("ArrayList: " + (e - s));
    }

    @Test
    public void test_9_add_10m_glue_list() {

        List<Integer> glueList = new GlueList<>();

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < dataCount10m; i++) {
            glueList.add(i);
        }
        e = System.currentTimeMillis();
        System.out.println("GlueList: " + (e - s));
    }
}
