abstract class Inning {
    public Inning() throws BaseballException, UmpireException {
    }

    public void event() throws BaseballException, UmpireException {
    }
    public abstract void atBat() throws Strike, Foul, Umpire1;
    public void walk() {}
}
