//Start with a number that is all binary ones. Left shift it, then use the
//unsigned right-shift operator to right shift through all of its binary positions, each time
//displaying the result using Integer.toBinaryString( ).

public class Main {
    public static void main(String[] args) {
        int i = -1 << 1;
        for (int j = 0; j < 32; j++) {
            System.out.println(Integer.toBinaryString(i));
            i = rightShift(i);
        }
    }
    static int rightShift(int i) {
        return i >>> 1;
    }
}
