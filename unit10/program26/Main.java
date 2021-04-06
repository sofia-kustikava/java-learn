//Create a class with an inner class that has a non-default constructor
//(one that takes arguments). Create a second class with an inner class that inherits from the
//first inner class. 

public class Main {
    public static void main(String[] args) {
        OutClass outClassMain = new OutClass();
        OutClass2 outClassMain2 = new OutClass2();
        OutClass2.InnerClass2 innerClass2 = outClassMain2.new InnerClass2(outClassMain,10);
        System.out.println("This is " + innerClass2.a);
    }
}
