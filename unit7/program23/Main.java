//Prove that class loading takes place only once. Prove that loading may
//be caused by either the creation of the first instance of that class or by the access of a static
//member. 

public class Main extends Test{
    private int k = print("Initialised Main.k");
    public Main() {
        print("k = " + k);
        print("b = " + b);
    }
    private static int x2 = print("Initialized 2");

    public static void main(final String args[]) {
        print("Constructor Main");
        Main test = new Main();
    }
}
