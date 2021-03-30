//Following Exercise 5, create a new Dog reference and assign it to spot’s
//object. Test for comparison using == and equals( ) for all references. 

public class Main {

    public static void main(String[] args) {
        Dog spot = new Dog();
        Dog scruffy = new Dog();
        spot.name = "Spot";
        scruffy.name = "Scruffy";
        spot.says = "Ruff!";
        scruffy.says = "Wurf!";
        System.out.println("The dog named " + spot.name + " said " + spot.says + ". But " + scruffy.name + " said " + scruffy.says);
        Dog otherDog = new Dog();
        spot = otherDog;
        System.out.println(spot == otherDog);
        System.out.println(spot.equals(otherDog));
    }
}
