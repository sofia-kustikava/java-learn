//Fill a HashMap with key-value pairs. Print the results to show
//ordering by hash code. Extract the pairs, sort by key, and place the result into a
//LinkedHashMap. Show that the insertion order is maintained. 

public class Main {
    public static void main(String[] args) {
        MapClass hm = new MapClass();
        hm.fillMap();
        hm.remap();
    }
}
