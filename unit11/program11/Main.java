//Write a method that uses an Iterator to step through a Collection and
//print the toString( ) of each object in the container. Fill all the different types of
//Collections with objects and apply your method to each container. 

import java.util.*;

public class Main {
    public static Collection populate(Collection<Object> c){
        Random rand = new Random();
        for(int i = 0; i <5; i++)
            c.add(rand.nextInt(9));
        return c;
    }
    public static void goPrint(Collection<Object> c){
        Iterator<Object> it = c.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();
    }
    public static void main(String[] args){
        goPrint(populate(new ArrayList<Object>()));
        goPrint(populate(new LinkedList<Object>()));
        goPrint(populate(new HashSet<Object>()));
        goPrint(populate(new TreeSet<Object>()));
        goPrint(populate(new LinkedHashSet<Object>()));
    }
}
