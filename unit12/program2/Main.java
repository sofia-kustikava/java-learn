//Define an object reference and initialize it to null. Try to call a method
//through this reference. Now wrap the code in a try-catch clause to catch the exception. 

public class Main {
    public static void main(String[] args) {
        ErrorEx errorEx = new ErrorEx();
        errorEx.foo();
    }
}
