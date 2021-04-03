public class Root {
    Component1 component1 = new Component1(1);
    Component2 component2 = new Component2(2);
    Component3 component3 = new Component3(3);
    public Root(String string) {
        System.out.println("Root");
    }
    protected void dispose(){
        System.out.println("Disposing of Root");
    }

    @Override
    public String toString() {
        return "Root";
    }
}
