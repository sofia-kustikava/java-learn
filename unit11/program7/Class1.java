public class Class1 {
    static int i = 1;
    int num;
    Class1() {
        num = 1;
        System.out.println("Number " + i++);
    }
    public String toString() {
        return "Number " + num;
    }
}
