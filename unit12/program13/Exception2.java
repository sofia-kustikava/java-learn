public class Exception2 extends Exception{
    public String toString() {
        return "Exception2";
    }

    public void throwExc2() throws Exception2{
        throw new Exception2();
    }
}
