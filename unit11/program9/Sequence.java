import java.util.*;

public class Sequence {
    private List<Object> items;
    public Sequence() { items = new ArrayList<Object>(); }
    public void add(Object x) {
        items.add(x);
    }
    public Iterator<Object> getIterator(){
        return items.iterator();
    }
}
