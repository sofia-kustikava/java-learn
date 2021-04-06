public class Outer {
    class Inner {
        Inner() {
            System.out.println("Inner");
        }
    }
    public Inner test() {
        return new Inner();
    }
}
