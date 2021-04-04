public class Cycle {
    protected void ride(Cycle cycle) {
        System.out.println(cycle);
        System.out.println("Wheels: " + cycle.wheel());
    }
    protected int wheel() {
        return 0;
    }
}
