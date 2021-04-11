//Using Countries, fill a Set multiple times with the same data and verify
//that the Set ends up with only one of each instance. Try this with HashSet,
//LinkedHashSet, and TreeSet. 

import java.util.*;

public class Main {
    public static void main(String[] args) {
        public static void main (String[]args){

            Set<String> a = new HashSet<String>(Countries.names(6));

            Set<String> b = new TreeSet<String>(Countries.names(6));

            Set<String> ls = new LinkedHashSet<String>(Countries.names(6));

            System.out.println(a);

            System.out.println(b);

            System.out.println(c);


        }
    }
}
