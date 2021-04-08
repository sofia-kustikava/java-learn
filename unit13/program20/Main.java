//Create a class that contains int, long, float and double and String
//fields. Create a constructor for this class that takes a single String argument, and scans that
//string into the various fields. Add a toString( ) method and demonstrate that your class
//works correctly. 

public class Main {
    String s;
    int i;
    long l;
    float f;
    double d;

    public Main(String str) {
        String[] strings = str.split(" ");

        try {
            this.i = Integer.parseInt(strings[0]);
            this.l = Long.parseLong(strings[1]);
            f = Float.parseFloat(strings[2]);
            d = Double.parseDouble(strings[3]);
            s = strings[4];
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
    }

    public String toString() {
        return "int i = " + i + "\nlong l = " + l +
                "\nfloat f = " + f + "\ndouble d = " + d +
                "\nstring s = " + s;
    }

    public static void main(String[] args) {
//        Main main = new Main("14 12.2 12");
        System.out.println(new Main("1 23123 21.1f sdf sdf"));
    }
}
