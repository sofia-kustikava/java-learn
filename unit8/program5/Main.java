//Starting from Exercise 1, add a wheels( ) method in Cycle, which
//returns the number of wheels. Modify ride( ) to call wheels( ) and verify that
//polymorphism works. 

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
