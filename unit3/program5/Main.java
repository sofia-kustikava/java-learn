import com.java.se.lesson12.Dog;

public class Main {

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        dog1.name = "Spot";
        dog2.name = "Scruffy";
        dog1.says = "Ruff!";
        dog2.says = "Wurf!";
        System.out.println("The dog named " + dog1.name + " said " + dog1.says + ". But " + dog2.name + " said " + dog2.says);
    }
}
