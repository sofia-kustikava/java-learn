import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Set;

class MapClass {
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    LinkedHashMap<Integer, String> linkedmap = new LinkedHashMap<Integer, String>();

    public void fillMap(){
        Random rand = new Random(42);
        int k;
        for (int i=0; i<10; i++){
            k = rand.nextInt(i+20);
            map.put(k, Integer.toString(k));
        }
        System.out.println("Hash code order: " + map);
    }

    public void remap(){
        Set<Integer> keyset = map.keySet();
        Iterator<Integer> it;
        int temp;
        int smallest;
        int iterations = keyset.size();
        for (int i = 0; i < iterations; i++) {
            it = keyset.iterator();
            smallest = it.next();
            it = keyset.iterator();
            while(it.hasNext()) {
                temp = it.next();
                if (temp < smallest) smallest = temp;
            }
            linkedmap.put(smallest, map.get(smallest));
            keyset.remove(smallest);
        }
        System.out.println("Sorted (insertion order): " + linkedmap);
    }
}
