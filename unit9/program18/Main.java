//Create a Cycle interface, with implementations Unicycle, Bicycle
//and Tricycle. Create factories for each type of Cycle, and code that uses these factories

public class Main {
    public static void rideCycle(MainFactory factory) {
        Cycle c = factory.makeCycle();
        c.ride();
    }

    public static void main(String[] args) {
        rideCycle(new Factory1());
        rideCycle(new Factory2());
    }
}
