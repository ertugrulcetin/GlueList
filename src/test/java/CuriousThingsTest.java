import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.assertEquals;

public class CuriousThingsTest {

    @Test
    public void testRemoveRange() {

        ArrayList<Integer> a = new ArrayList<>();
        GlueList<Integer> glueList = new GlueList<>(2);
        for (int i = 0; i < 20; i++) {
            glueList.add(i);
            a.add(i);
        }

        System.out.println(glueList.subList(10,16));
        System.out.println(a.subList(10,16));

        System.out.println(glueList);
    }

    @Test
    public void testPrintNodesInfo() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 100; i++) {
            glueList.add("" + i);
        }

        TestUtil.printNodesInfo(glueList);
    }

    @Test
    public void testDataTest() {

        GlueList.Node node = new GlueList.Node(null, null, 0);

        int newStartingIndex = node.startingIndex - 1;
        node.startingIndex = (--node.startingIndex < 0) ? 0 : node.startingIndex;

        System.out.println(node.startingIndex);
    }

    @Test
    public void testRemoveAll() {

        ArrayList<String> arrayList = new ArrayList<>();
        GlueList<String> glueList = new GlueList<>(2);

        for (int i = 0; i < 20; i++) {
            glueList.add("" + i);
            arrayList.add("" + i);
        }

        glueList.printClustered();
        glueList.printClusteredWithAllocations();

        glueList.removeAll(arrayList);

        glueList.printClustered();
        glueList.printClusteredWithAllocations();
    }

    @Test
    public void testGet() {

        GlueList<String> glueList = new GlueList<>();

        for (int i = 0; i < 1_000_000; i++) {
            glueList.add("" + i);
        }

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            glueList.get(500_000);
        }
        e = System.currentTimeMillis();
        System.out.println("Get: " + (e - s));
    }

    @Test
    public void testGetArayList() {

        ArrayList<String> glueList = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            glueList.add("" + i);
        }

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            glueList.get(9_999_000);
        }
        e = System.currentTimeMillis();
        System.out.println("ArrayList Get: " + (e - s));
    }

    @Test
    public void testGetLinkedList() {
        LinkedList<String> glueList = new LinkedList<>();

        for (int i = 0; i < 1_000_000; i++) {
            glueList.add("" + i);
        }

        long s, e;

        s = System.currentTimeMillis();
        for (int i = 0; i < 1_0; i++) {
            glueList.get(500_999);
        }
        e = System.currentTimeMillis();
        System.out.println("Get: " + (e - s));
    }

    @Test
    public void testArrayListListIterator() {

        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        ListIterator<Integer> listIterator = a.listIterator();
        System.out.println(listIterator.next());
    }

    @Test
    public void testArrayListRemoveVal() {

        List<String> list = new ArrayList<>(25);
        list.add("ertu");
        list.add("can");
        list.add("selin");
        list.add("kerem");
        list.add("musti");
        list.add("emra");

        list.remove(1);
        assertEquals("selin", list.get(1));

        list.remove(3);
        assertEquals("emra", list.get(3));
    }

    @Test
    public void testAddressesInRam() {

        for (int i = 0; i < 100_000; i++) {
            System.out.println(new Deneme());
        }
    }

    @Test
    public void testClearAll() {

        GlueList<Integer> list = new GlueList<>(2);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);

        list.clear();
        System.out.println();
    }

    static class Deneme {

    }


    @Test
    public void testArrayListTest() {

        List<String> a = new ArrayList<>(10);
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        a.add(null);

        System.out.println(Arrays.toString(a.toArray()));

        List<String> b = new ArrayList<>(10);
        b.addAll(a);

        System.out.println(b);
    }

    @Test
    public void testArrayCopy() {

        String[] str = new String[]{"a", "b"};
        String[] a = Arrays.copyOf(str, 5);

        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testNative() {

        Aga[] arr = new Aga[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Aga(i);
        }

        Aga[] bArr = new Aga[100];

        int counter = 10_000_000;

        long s, e;


        /*{
            s = System.currentTimeMillis();

            for (int i = 0; i < counter; i++) {
                for (int j = 0; j < arr.length; j++) {
                    bArr[j] = arr[j];
                }
            }
            e = System.currentTimeMillis();
            System.out.println("For: " + (e - s));
        }*/

        {

            s = System.currentTimeMillis();
            for (int i = 0; i < counter; i++) {
                System.arraycopy(arr, 0, bArr, 0, arr.length);
            }
            e = System.currentTimeMillis();
            System.out.println("Native: " + (e - s));
        }
    }

    private static class Aga {
        private int a;
        private int b;
        private int c;

        public Aga(int a) {
            this.a = a;
        }

        public Aga(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }

    @Test
    public void test() {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        GlueList<String> a = new GlueList<>();
        a.addAll(0, list);

//        ListIterator<String> listIterator = a.listIterator();
//        listIterator.add("Selam");

        System.out.println(a);
    }
}
