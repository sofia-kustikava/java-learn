public class B extends A {
    public B(String string) {
        super(1);
        System.out.println("B");
        System.out.println(this);
    }

    public String str() {
        return "B";
    }
}
