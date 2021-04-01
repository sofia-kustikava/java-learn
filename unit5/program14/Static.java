public class Static {
    static String name1 = "Yana";
    static String name2;

    static {
        name2 = "Katya";}

    public static void result() {
        System.out.println("My name is " + name1);
        System.out.println("My name is " + name2);
    }
}
