import org.junit.Test;

public class GlueListIndexOfTest {

    @Test
    public void testSimpleIndexOf() {

        GlueList<String> list = new GlueList<>(2);

        list.add("ertu"); // 0
        list.add("selin");// 1
        list.add("cansu");// 2
        list.add("mehmet");// 5
        list.add("kerem");// 3
        list.add("burcu");// 4
        list.add("boğa");// 6
        list.add("osman");// 7
        list.add("aysun");// 8
        list.add("emre");// 9
        list.add("demir");// 10
        list.add("kıvanç");// 11
        list.add(null);// 12


        System.out.println(list.indexOf("ertu"));
        System.out.println(list.indexOf("selin"));
        System.out.println(list.indexOf("cansu"));
        System.out.println(list.indexOf("mehmet"));
        System.out.println(list.indexOf("kerem"));
        System.out.println(list.indexOf("burcu"));
        System.out.println(list.indexOf("boğa"));
        System.out.println(list.indexOf("osman"));
        System.out.println(list.indexOf("aysun"));
        System.out.println(list.indexOf("emre"));
        System.out.println(list.indexOf("demir"));
        System.out.println(list.indexOf("kıvanç"));
        System.out.println(list.indexOf(null));
        System.out.println(list.indexOf("seriiinnn"));

    }
}
