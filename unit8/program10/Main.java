//Create a base class with two methods. In the first method, call the
//second method. Inherit a class and override the second method. Create an object of the
//derived class, upcast it to the base type, and call the first method. Explain what happens. 

public class Main {
    public static void main(String[] args) {
        Test1 derivedClass1 = new Test2();
        derivedClass1.met1();
    }
}
