public class Factory2 implements MainFactory{
    @Override
    public Cycle makeCycle() {
        return new Bicycle();
    }
}
