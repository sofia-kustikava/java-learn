//Modify Receipt.java so that the widths are all controlled by a single set of
//constant values. The goal is to allow you to easily change a width by changing a single value
//in one place. 

import java.util.*;

public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private int[] colWidth={15,5,10};
    public Receipt(){};
    public Receipt(int[] width){colWidth = width;}
    public void printTitle() {
        f.format("%-"+colWidth[0]+"s %"+colWidth[1]+"s %"+colWidth[2]+"s\n", "Item", "Qty", "Price");
        f.format("%-"+colWidth[0]+"s %"+colWidth[1]+"s %"+colWidth[2]+"s\n", "----", "---", "-----");
    }
    public void print(String name, int qty, double price) {
        f.format("%-"+colWidth[0]+".15s %"+colWidth[1]+"d %"+colWidth[2]+".2f\n", name, qty, price);
        total += price;
    }
    public void printTotal() {
        f.format("%-"+colWidth[0]+".15s %"+colWidth[1]+"d %"+colWidth[2]+".2f\n", "Tax", "", total*0.06);
        f.format("%-"+colWidth[0]+"s %"+colWidth[1]+"s %"+colWidth[2]+"s\n", "", "", "-----");
        f.format("%-"+colWidth[0]+".15s %"+colWidth[1]+"d %"+colWidth[2]+".2f\n", "Total", "",
                total * 1.06);
    }
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
