//Create a class with public, private, protected, and package-access
//fields and method members. Create an object of this class and see what kind of compiler
//messages you get when you try to access all the class members. Be aware that classes in the
//same directory are part of the “default” package. 

package com.java.se.package1;

import com.java.se.package2.Test;


public class Main {
    public static void main(String[] args) {
        Test var = new Test();
        System.out.println(var.a);
        System.out.println(var.b);
        System.out.println(var.c);

        Test.str();
        Test.str2();
        Test.str3();
    }
}
