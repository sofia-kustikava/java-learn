//Create a class called Dog containing two Strings: name and says. In
//main( ), create two dog objects with names “spot” (who says, “Ruff!”) and “scruffy” (who
//says, “Wurf!”). Then display their names and what they say.

public class Main {

    public static void main(String[] args) {
        Dog spot = new Dog();
        Dog scruffy = new Dog();
        spot.name = "Spot";
        scruffy.name = "Scruffy";
        spot.says = "Ruff!";
        scruffy.says = "Wurf!";
        System.out.println("The dog named " + spot.name + " said " + spot.says + ". But " + scruffy.name + " said " + scruffy.says);
    }
}
