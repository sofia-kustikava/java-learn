//Write a method that takes two String arguments and uses all the
//boolean comparisons to compare the two Strings and print the results. For the == and !=,
//also perform the equals( ) test. In main( ), call your method with some different String
//objects. 

public class Main {
    static void compare(String s1, String s2) {
        System.out.println(s1 + " != " + s2 + " : " + !(s1).equals(s2));
        System.out.println(s1 + " equals " + s2 + " : " + s1.equals(s2));
    }
    public static void main(String[] args) {
        compare("Lara","Lara");
        compare("Sofia","Sonya");
    }
}
