public class Stem extends Root {
    Component1 component1 = new Component1(1);
    Component2 component2 = new Component2(2);
    Component3 component3 = new Component3(3);
    public Stem(String string) {
        super("Root");
        System.out.println(string);
    }
    public void dispose() {
        System.out.println("Disposing of " + this);
        super.dispose();
    }

    public String toString() {
        return "Stem";
    }
}
