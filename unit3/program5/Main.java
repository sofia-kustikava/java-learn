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
