//Create a class that contains int, long, float and double fields. Create a
//toString( ) method for this class that uses String.format( ), and demonstrate that your
//class works correctly. 

public class Main {
    private static final int i = 999;
    private static final long l = 99999L;
    private static final float f = 99999.00f;
    private static final double d = 99999999.00;

    public String toString() {
        return String.format("Int: %1$-15d Long: %2$-15d Float: %3$-15.1f Double: %4$-15.7e", i, l, f, d);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main);
    }
}
