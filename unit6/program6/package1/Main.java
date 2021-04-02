//Create a class with protected data. Create a second class in the same file
//with a method that manipulates the protected data in the first class

package com.java.se.package1;

public class Main {
    public static void main(String[] args) {
        First first = new First();
        new Second().args(first);
    }

    static class First {
        protected int a = 10;
        protected int b = 5;
    }

    static class Second {
        public void args(First first) {
            first.a++;
            first.b--;

        }
    }

}
