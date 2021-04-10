public class Elements<T> {
    private T mainClass;

    public Elements(T mainClass) {
        this.mainClass = mainClass;
    }

    public T getMainClass() {
        return mainClass;
    }

    public void setMainClass(T mainClass) {
        this.mainClass = mainClass;
    }
}
