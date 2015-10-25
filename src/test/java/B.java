public class B extends A {

    public static void a() {
        System.out.println("B.a()");
    }

    public static void main(String[] args) {


        A a = new B();
        a.a();
    }

    public B() {
    }
}
