//Modify all the exception types in Stormylnning.java so that they
//extend RuntimeException, and show that no exception specifications or try blocks are
//necessary. Remove the ‘//!’ comments and show how the methods can be compiled without
//specifications. 

public class StormyInning extends Wrap implements Storm {

    public StormyInning() throws RainedOut, BaseballException { }

    public StormyInning(String s) throws Foul, BaseballException { }

    void walk() throws PopFoul { }

    public void rainHard() throws RainedOut { }

    public void event() { }

    public void atBat() throws PopFoul { }

    public void event() throws RainedOut { }

    public static void main(String[] args) {
        
        Wrap wr = new Wrap();
        wr.runTimeExc(3);
        for (int i = 0; i < 4;i++)
        try {
            StormyInning si = new StormyInning();
            si.atBat();
            if (i < 3) wr.runTimeExc(i);
            else throw  PopFoul();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
