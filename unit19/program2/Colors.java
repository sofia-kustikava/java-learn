import java.util.Random;

enum Colors {
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;

    private static Random rand=new Random();

    public static Colors next(){
        return values()[rand.nextInt(values().length)];
    }
}
