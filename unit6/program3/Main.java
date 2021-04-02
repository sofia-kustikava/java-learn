//Create two packages: debug and debugoff, containing an identical class
//with a debug( ) method. The first version displays its String argument to the console, the 
//second does nothing. Use a static import line to import the class into a test program, and
//demonstrate the conditional compilation effect

package com.java.se;
import static com.java.se.debug.Test.debug;
import static com.java.se.debugoff.Test.debug;

public class Main {
    private static boolean isDebug = true;
    public static void main(String[] args) {
        if (isDebug) {
            debug("Ok");
        } else {
            debug();
        }
    }
}
