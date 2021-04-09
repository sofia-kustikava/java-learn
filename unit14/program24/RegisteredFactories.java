//Add Null Objects to RegisteredFactories.java.

public class RegisteredFactories {
    public static void main(String[] args) {
        public static final Part NULL =new Part();
        for(int i = 0; i < 10; i++)
            System.out.println(NullPart.createRandom());
    }
}
