//Write a program that demonstrates that autoboxing works for all the
//primitive types and their wrappers. 


public class Main {
    public static void main (String[] args){
        Integer integer = 5;  //autoboxing
        int i = integer;
        float pi = 3.14f;
        Float f = pi;
        Boolean bool = true;
        boolean b = bool;
        System.out.println(i + " = " + integer);
        System.out.println(pi + " = " + f);
        System.out.println(bool + ", just " + b);
    }
}
