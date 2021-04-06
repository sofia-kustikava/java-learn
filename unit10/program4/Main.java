//Add a method to the class Sequence.SequenceSelector that produces
//the reference to the outer class Sequence. 

public class Main {
    public static void main(String[] args) {
        Sequence seq = new Sequence(10);
        for (int i = 0; i < 10; i++) seq.add(Integer.toString(i));
        Selector sel = seq.selector();
        while (!sel.end()) {
            System.out.print(sel.current() + " ");
            sel.next();
        }
        sel.getSequence();
    }
}
