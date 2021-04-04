//Create a class with a static final field and a final field and
//demonstrate the difference between the two. 

public class Main {
    public static void main(final String args[]) {
        Test test  = new Test(1);
        System.out.println(test.a);
        Test.b = 1; //error
        System.out.println(test.b);
    }
}
