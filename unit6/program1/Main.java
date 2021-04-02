//Create a class in a package. Create an instance of your class outside of that
//package. 

package com.java.se.package1;

import com.java.second.package3.Edu;


public class Main {
    public static void main(String[] args) {

        Edu name = new Edu();
        name.hello("Anya");
    }

}
