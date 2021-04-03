package com.java.se.package1;

public class Test1 {
    Test2 test2;
    public Test1() {
        if (test2 == null) {
            test2 = new Test2();
            System.out.println(test2 + " has been created inside " + this);
        } else {
            System.out.println("Ops");
        }
    }
    public String toString() {
        return "Test1";
    }
}
