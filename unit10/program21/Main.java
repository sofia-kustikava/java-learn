//Create an interface that contains a nested class that has a static method
//that calls the methods of your interface and displays the results. Implement your interface
//and pass an instance of your implementation to the method. 

public class Main implements Int {
    public String method() {
        int i = 0;
        i++;
        return Integer.toString(i);
    }
    public static void main(String[] args) {
        Int.Nest.innerMethod(new Main());
    }
}
