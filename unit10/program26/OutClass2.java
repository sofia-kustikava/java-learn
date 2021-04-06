public class OutClass2 {
    class InnerClass2 extends OutClass.InnerClass {
        InnerClass2(OutClass outClass,int a) {
            outClass.super(a);
        }
    }
}
