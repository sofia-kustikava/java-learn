public class Factory1 implements MainFactory{
    @Override
    public Cycle makeCycle() {
        return new Unicycle();
    }
}
