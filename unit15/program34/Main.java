//Create a self-bounded generic type that contains an abstract method
//that takes an argument of the generic type parameter and produces a return value of the 
//generic type parameter. In a non-abstract method of the class, call the abstract method
//and return its result. Inherit from the self-bounded type and test the resulting class.

public class Main {
    private static abstract class SelfBoundsGeneric<T extends SelfBoundsGeneric<T>> {
        public abstract T aMethod(T t);
        public T method(T t) {
            System.out.println(t);
            return aMethod(t);
        }
    }
    private static class A extends SelfBoundsGeneric<A> {
        private static int count = 0;
        private final int ID = ++count;
        public String toString() {
            return "ID " + ID;
        }
        public A aMethod(A a) {
            return a;
        }
    }
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        a1.method(a2);
    }
}
