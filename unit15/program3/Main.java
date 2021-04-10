//Create and test a SixTuple generic. 

public class Main {
    public static class SixTuple<A,B,C,D,E,F> {
        private A a;
        private B b;
        private C c;
        private D d;
        private E e;
        private F f;
        public SixTuple(A a,B b,C c,D d,E e,F f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
        public String toString() {
            return "A=" + a + ", " + "B=" + b + ", " + "C=" + c + ", " + "D=" + d + ", " + "E=" + e + ", " + "F=" + f;
        }
    }
    public static void main(String[] args) {
        SixTuple<String,Integer,Double,Float,Boolean,Long> myTuple = new SixTuple<>("Hello",0xfff,111.111,222.222f,true,333l);
        System.out.println(myTuple);
    }
}
