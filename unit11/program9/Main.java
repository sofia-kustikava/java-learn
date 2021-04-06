//Modify innerclasses/Sequence.java so that Sequence works with an
//Iterator instead of a Selector. 

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for(int i = 0; i < 10; i++)
            sequence.add(i);
        Iterator<Object> selector = sequence.getIterator();
        while(selector.hasNext()) {
            System.out.print(selector.next() + " ");
        }
    }
}
