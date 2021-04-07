public class ErrorEx {
    private A a;
    public void foo() {
        try {
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("NullPointerException");
        }
    }
}
