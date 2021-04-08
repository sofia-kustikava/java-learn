//Look up the interface for java.lang.Class in the JDK documentation
//from http://java.sun.com. Write a program that takes the name of a class as a command-line
//argument, then uses the Class methods to dump all the information available for that class.
//Test your program with a standard library class and a class you create. 

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName(args[0]);

            Constructor<?>[] constructor = c.getConstructors();
            if (constructor.length > 0) {
                for (Constructor<?> con : constructor) {
                    System.out.println(con);
                }
            }
            Method[] methods = c.getMethods();
            if (methods.length > 0) {
                for (Method m : methods) {
                    System.out.println(m);
                }
            }
            Field[] fs = c.getFields();
            if (fs.length > 0) {
                for (Field f : fs) {
                    System.out.println(f);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
