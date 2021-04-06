public class B {
    U[] arrayU = new U[5];
    void setSaveU(U u, int i) {
        arrayU[i] = u;
    }
    void nullU(int i) {
        arrayU[i] = null;
    }
    void movesU(U[] u) {
        int i = 0;
        while ((i != u.length) && (u[i]!=null)) {
            arrayU[i].method1();
            arrayU[i].method2();
            arrayU[i].method3();
            i++;
        }
    }
}
