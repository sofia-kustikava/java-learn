//Modify ListFeatures.java so that it uses Integers (remember
//autoboxing!) instead of Pets, and explain any difference in results. 

import java.util.*;

public class Main {
    public static List<Integer> IntegersToList(int last) {
        Random rand = new Random(47);
        List<Integer> intlist = new ArrayList<Integer>();
        for(int i = 0; i < last; i++)
            intlist.add(rand.nextInt(47));
        return intlist;
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> Integers = IntegersToList(7);
        System.out.println("1: " + Integers);
        Integer h = 1;
        Integers.add(h); 
        System.out.println("2: " + Integers);
        System.out.println("3: " + Integers.contains(h));
        Integers.remove(h); 
        Integer p = Integers.get(2);
        System.out.println("4: " + p + " " + Integers.indexOf(p));
        Integer cymric = 2;
        System.out.println("5: " + Integers.indexOf(cymric));
        System.out.println("6: " + Integers.remove(cymric));
        System.out.println("7: " + Integers.remove(p));
        System.out.println("8: " + Integers);
        Integers.add(3, 3);
        System.out.println("9: " + Integers);
        List<Integer> sub = Integers.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + Integers.containsAll(sub));
        Collections.sort(sub); 
        System.out.println("sorted subList: " + sub);
        System.out.println("11: " + Integers.containsAll(sub));
        Collections.shuffle(sub, rand);
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + Integers.containsAll(sub));
        List<Integer> copy = new ArrayList<Integer>(Integers);
        sub = Arrays.asList(Integers.get(1), Integers.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<Integer>(Integers); 
        copy.remove(2); 
        System.out.println("14: " + copy);
        copy.removeAll(sub); 
        System.out.println("15: " + copy);
        copy.set(1, 5); 
        System.out.println("16: " + copy);
        copy.addAll(2, sub); 
        System.out.println("17: " + copy);
        System.out.println("18: " + Integers.isEmpty());
        Integers.clear(); 
        System.out.println("19: " + Integers);
        System.out.println("20: " + Integers.isEmpty());
        Integers.addAll(IntegersToList(4));
        System.out.println("21: " + Integers);
        Object[] o = Integers.toArray();
        System.out.println("22: " + o[3]);
        Integer[] pa = Integers.toArray(new Integer[0]);
        System.out.println("23: " + pa[3]);
    }
}
