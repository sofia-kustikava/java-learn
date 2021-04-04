public class Hamster extends Rodent{
    public void move() {
        System.out.println("Hamster moves");
    }

    public void gnaw() {
        System.out.println("Hamster gnaws");
    }
    public void dispose() {
        System.out.println("Dispose of Hamster");
        super.dispose();
    }
}
