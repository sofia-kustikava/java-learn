//Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle.
//Demonstrate that an instance of each type can be upcast to Cycle via a ride( ) method.

public class Main {
    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();

        unicycle.ride(unicycle);
        bicycle.ride(bicycle);
        tricycle.ride(tricycle);

    }
}
