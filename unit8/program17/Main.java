//Using the Cycle hierarchy from Exercise 1, add a balance( ) method to
//Unicycle and Bicycle, but not to Tricycle. Create instances of all three types and upcast
//them to an array of Cycle. Try to call balance( ) on each element of the array and observe
//the results. Downcast and call balance( ) and observe what happens. 

public class Main {
    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();

        unicycle.ride(unicycle);
        bicycle.ride(bicycle);
        tricycle.ride(tricycle);
        Cycle[] cycles = {new Unicycle(),new Bicycle(),new Tricycle()};
        for (Cycle cycle1 : cycles) {
            cycle1.balance();
        }
    }
}
