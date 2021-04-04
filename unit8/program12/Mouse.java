public class Mouse extends Rodent {
    public void move() {
        System.out.println("Mouse moves");
    }

    public void gnaw() {
        System.out.println("Mouse gnaws");
    }
    public void dispose() {
        System.out.println("Dispose of Mouse");
        super.dispose();
    }
}
