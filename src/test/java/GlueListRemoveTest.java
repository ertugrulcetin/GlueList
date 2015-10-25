import org.junit.Test;

import java.util.Arrays;

public class GlueListRemoveTest {

    @Test
    public void testSimpleRemove() {

        GlueList<String> list = new GlueList<>(2);

        list.add("ertu"); // 0
        list.add("selin");// 1
        list.add("cansu");// 2
        list.add("kerem");// 3
        list.add("burcu");// 4
        list.add("mehmet");// 5
        list.add("boğa");// 6
        list.add("osman");// 7
        list.add("aysun");// 8
        list.add("emre");// 9
        list.add("demir");// 10
        list.add("kıvanç");// 11
        list.add("sadık");// 12

        System.out.println();
        System.out.println(list);
        System.out.println();

        list.remove(0);
        System.out.println(list.get(0));

        list.remove(0);
        System.out.println(list.get(0));

        list.remove(0);
        System.out.println(list.get(0));

        list.remove(3);
        System.out.println(list.get(0));

        System.out.println();
        System.out.println(list);

    }

    @Test
    public void testSimpleRemove2(){

        GlueList<String> list = new GlueList<>(2);

        list.add("ertu"); // 0
        list.add("selin");// 1
        list.add("cansu");// 2
        list.add("kerem");// 3
        list.add("burcu");// 4
        list.add("mehmet");// 5
        list.add("boğa");// 6
        list.add("osman");// 7
        list.add("aysun");// 8
        list.add("emre");// 9
        list.add("demir");// 10
        list.add("kıvanç");// 11
        list.add("sadık");// 12

        System.out.println();
        System.out.println(list);
        System.out.println();

        list.remove(0);
        System.out.println(list.get(0));


        list.remove(3);
        System.out.println(list.get(3));

        list.remove(3);
        System.out.println(list.get(3));

        System.out.println();
        System.out.println(list);
    }

    @Test
    public void testToArray(){

        GlueList<String> list = new GlueList<>(2);

        list.add("ertu"); // 0
        list.add("selin");// 1
        list.add("cansu");// 2
        list.add("kerem");// 3
        list.add("burcu");// 4
        list.add("mehmet");// 5
        list.add("boğa");// 6
        list.add("osman");// 7
        list.add("aysun");// 8
        list.add("emre");// 9
        list.add("demir");// 10
//        list.add("kıvanç");// 11
//        list.add(null);// 12

        Object[] objectsArr = list.toArray();
        System.out.println(Arrays.toString(objectsArr));

        String[] gl = list.toArray(new String[0]);
        System.out.println(Arrays.toString(gl));


    }
}
