public class Tank {
    private boolean empty = false;

    public void empty() {
        empty = true;
    }
    public boolean isEmpty() {
        return empty;
    }
    public void condition() throws Throwable {
        this.finalize();
    }
    public void finalize() throws Throwable {
        if (empty) {
            System.out.println("Tank is empty");
            super.finalize();
        }
    }
}
