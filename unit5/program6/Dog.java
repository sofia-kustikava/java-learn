public class Dog {
    public void bark() {
        System.out.println("Say something");
    }
    public void bark(String woof) {
        System.out.println("Say " + woof);
    }

    public void bark2(String woof, int times) {
        System.out.println("Dog said " + woof + " for " + times + " times!");
    }
    public void bark2(int times, String woof) {
        System.out.println("For " + times + " times the dog said " + woof);
    }
}
