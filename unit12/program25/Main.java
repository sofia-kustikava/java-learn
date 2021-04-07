//Create a three-level hierarchy of exceptions. Now create a base-class A
//with a method that throws an exception at the base of your hierarchy. Inherit B from A and
//override the method so it throws an exception at level two of your hierarchy. Repeat by
//inheriting class C from B. In main( ), create a C and upcast it to A, then call the method. 

public class Main {
    public static void main(String[] args) {
        A a = new C();
        try {
            a.method();
        }	catch(Exception3 e3) {
            System.out.println("Caught e3");
        }	catch(Exception2 e2) {
            System.out.println("Caught e2");
        }	catch(Exception1 e1) {
            System.out.println("Caught e1");
        }
    }
}
