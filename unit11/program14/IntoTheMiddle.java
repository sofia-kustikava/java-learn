import java.util.*;

public class IntoTheMiddle {
    LinkedList<Integer> list = new LinkedList<Integer>();

    public void insert(Integer i){
        ListIterator<Integer> listiterator = list.listIterator();
        int c = 0;
        while (listiterator.hasNext()){
            listiterator.next();
            c++;
        }
        list.add((c/2+(c%2)), i);
        System.out.println("Inserting " + c);
    }
}
