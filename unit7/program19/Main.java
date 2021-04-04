//Create a class with a blank final reference to an object. Perform the
//initialization of the blank final inside all constructors. Demonstrate the guarantee that the
//final must be initialized before use, and that it cannot be changed once initialized. 

public class Main {
    private final Test a;

    public Main() {
        a = new Test(1);
    }
    public Main(int x) {
        a = new Test(x);
    }

    public static void main(final String args[]) {
        new Main();
        new Main(21);
    }
}
