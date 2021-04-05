//Exercise 14: (2) Create three interfaces, each with two methods. Inherit a new interface
//that combines the three, adding a new method. Create a class by implementing the new
//interface and also inheriting from a concrete class. Now write four methods, each of which 
//takes one of the four interfaces as an argument. In main( ), create an object of your class
//and pass it to each of the methods.
//Exercise 15: (2) Modify the previous exercise by creating an abstract class and
//inheriting that into the derived class. 

public class Main{
    public static void main(String[] args) {
        DefaultClass test = new DefaultClass();
        test.method1();
        test.method2();
        test.method3();
        test.method4();
        test.method5();
        test.method6();
        test.method7();
        test.anotherMethod();
    }
}
