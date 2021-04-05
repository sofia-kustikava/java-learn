//Create a class that produces a sequence of chars. Adapt this class so
//that it can be an input to a Scanner object. 

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomChars(5));
        while(s.hasNext())
            System.out.print(s.next() + " ");
    }
}
