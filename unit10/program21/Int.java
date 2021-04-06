public interface Int {
    String method();
    static class Nest {
        static void  innerMethod(Int a) {
            System.out.println(a.method());
        }
    }
}
