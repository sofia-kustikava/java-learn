//Exercise 5: (2) Create a class called Dog with an overloaded bark( ) method. This
//method should be overloaded based on various primitive data types, and print different types
//of barking, howling, etc., depending on which overloaded version is called. Write a main( )
//that calls all the different versions.
//
//Exercise 6: (1) Modify the previous exercise so that two of the overloaded methods have
//two arguments (of two different types), but in reversed order relative to each other. Verify
//that this works. 

import com.java.se.lesson12.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.bark("Woof");

        dog.bark2("Woooof", 4);
        dog.bark2(7, "Woof");
    }
}
