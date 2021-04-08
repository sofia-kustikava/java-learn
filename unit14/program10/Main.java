//Write a program to determine whether an array of char is a primitive
//type or a true Object. 

public class Main {
    public static void main(String[] args){
        char[] c={'i','r','a','d'};
        System.out.println(c instanceof char[]);
        System.out.println(c instanceof Object);
        System.out.println(c.getClass().getName()); //[C there
        System.out.println(c.getClass().getSuperclass().getName());
        System.out.println(c.length);
    }
}
