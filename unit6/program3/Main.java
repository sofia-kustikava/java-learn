//Create a class in a package. Create an instance of your class outside of that
//package.

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
