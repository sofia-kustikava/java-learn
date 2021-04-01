//Exercise 3: Create a class with a default constructor (one that takes no arguments)
//that prints a message. Create an object of this class.
//Exercise 4: Add an overloaded constructor to the previous exercise that takes a
//String argument and prints it along with your message. 

public class Main {
    public Main(){

        System.out.println("Overload");

    }

    public Main(String message){

        System.out.println(message);

    }

    public static void main (String[] args){
        new Main();
        new Main("Overload");
    }
}
