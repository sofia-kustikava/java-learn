public class BitTest {
    public void binaryPrint(int q) {
        if (q == 0) {
            System.out.print(0);
        } else {
            int nlz = Integer.numberOfLeadingZeros(q);
            q <<= nlz;
            for (int p = 0; p < 32 - nlz; p++) {
                int n = (Integer.numberOfLeadingZeros(q) == 0) ? 1 : 0;
                System.out.print(n);
                q <<= 1;
            }
        }
        System.out.println("");
    }
}
