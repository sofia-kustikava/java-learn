class Test extends AbstractClass {
    @Override
    void ac() {
        System.out.println("Abstract method");
    }
    public static void b() {
        AbstractClass b = new Test();
        b.ac();
        System.out.println("We created method B");
    }
}
