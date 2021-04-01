//Create a class called Tank that can be filled and emptied, and has a
//termination condition that it must be empty when the object is cleaned up. Write a
//finalize( ) that verifies this termination condition. In main( ), test the possible scenarios
//that can occur when your Tank is used. 

import com.java.se.lesson12.Tank;

public class Main {
    public static void main(String[] args) throws Throwable {
        Tank tank = new Tank();
        System.gc();

        tank.empty();
        tank.condition();
    }
}
