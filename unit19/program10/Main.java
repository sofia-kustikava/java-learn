//Modify class VendingMachine (only) using EnumMap so that one
//program can have multiple instances of VendingMachine. 

public class Main{
    public static void main(String[] args) {
        VendingMachine vm1=new VendingMachine();
        Generator<Input> gen=new RandomInputGenerator();
        vm1.run(gen);
        vm1.reset();
        vm1.run(gen);

        VendingMachine vm2=new VendingMachine();
        vm2.run(gen);
    }
}
