//Create both an ArrayList and a LinkedList, and fill each using the
//Countries.names( ) generator. Print each list using an ordinary Iterator, then insert one
//list into the other by using a Listlterator, inserting at every other location. Now perform the
//insertion starting at the end of the first list and moving backward.

import java.util.*;

public class Main {
    public static void insertion(ListIterator<String> iteA, ListIterator<String> iteB) {
        while (iteA.hasNext()) {
            iteA.next();
            if (iteB.hasNext()) {
                iteA.add(iteB.next() + " 2");
            }
        }
        while (iteB.hasNext()) {
            iteA.add(iteB.next());
            iteA.next();
        }
    }
    public static void inverseInsertion(ListIterator<String> iteA, ListIterator<String> iteB) {
        while (iteA.hasNext()) {
            iteA.next();
        }
        while (iteA.hasPrevious()) {
            iteA.previous();
            if (iteB.hasNext()) {
                iteA.add(iteB.next() + " 2");
                iteA.previous();
            }
        }
        while (iteB.hasNext()) {
            iteA.add(iteB.next());
        }
    }
    public static void main(String[] args) {
        List<String> al = new ArrayList<String>();
        List<String> ll = new LinkedList<String>();
        al.addAll(Countries.name());
        ll.addAll(Countries.name());
        System.out.println("ArrayList: \n" + al);
        System.out.println("LinkedList: \n" + al);
        
        ListIterator<String> alIte = al.listIterator();
        ListIterator<String> llIte = ll.listIterator();\
        inverseInsertion(alIte, llIte);
        System.out.println(al);
    }
}
