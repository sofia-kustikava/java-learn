//Modify StormyInning.java by adding an UmpireArgument
//exception type and methods that throw this exception. Test the modified hierarchy. 

public class StormyInning extends Inning implements Storm {
    public UmpireException() 
            throws Umpire1 { }
    public StormyInning()
            throws RainedOut, BaseballException { }

    public StormyInning(String s)
            throws Foul, BaseballException { }

    public void rainHard() throws RainedOut { }

    public void event() { }

    public void atBat() throws PopFoul { }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
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
            System.out.println("Main Exception");
        } catch (Umpire1 umpire1) {
            umpire1.printStackTrace();
        }
    }
}
