//For each of the basic conversion types in the above table, write the most
//complex formatting expression possible. That is, use all the possible format specifiers
//available for that conversion type. 

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        char u = 'a';
        int v = 121243432 ;
        double x = 179.543;
        System.out.println("u = ‘a’");
        f.format("s: %1$-15.15s\n", u);
         f.format("d: %d\n", v);
        f.format("c: %1$-15c\n", u);
        f.format("b: %1$-15.5b\n", u);
         f.format("f: %f\n", x);
         f.format("e: %e\n", x);
         f.format("x: %x\n", v);
        f.format("h: %1$-15.5h\n", u);
    }
}
