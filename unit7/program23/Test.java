public class Test {
    private int a = 5;
    protected int b;

    void Sum() {
        System.out.println("a = " + a + ". b = " + b);
        b = 10;
    }
    private  static  int x1 = print("Initialised 1");
    static int print (String s) {
        System.out.println(s);
        return 20;
    }
}
