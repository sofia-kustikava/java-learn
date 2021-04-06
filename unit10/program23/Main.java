//Create an interface U with three methods. Create a class A with a
//method that produces a reference to a U by building an anonymous inner class. Create a
//second class B that contains an array of U. B should have one method that accepts and stores
//a reference to a U in the array, a second method that sets a reference in the array (specified
//by the method argument) to null, and a third method that moves through the array and calls
//the methods in U. In main( ), create a group of A objects and a single B. Fill the B with U
//references produced by the A objects. Use the B to call back into all the A objects. Remove
//some of the U references from the B. 

public class Main {
    public static void main(String[] args) {
        A[] arrayA = new A[5];
        for (int i = 0; i < 5; i++) {
            arrayA[i] = new A();
        }
        B methodsB = new B();
        for (int i = 0; i < 5; i++) {
            methodsB.setSaveU(arrayA[i].takeU(), i);
        }
        methodsB.movesU(methodsB.arrayU);
        methodsB.nullU(4);
    }
}
