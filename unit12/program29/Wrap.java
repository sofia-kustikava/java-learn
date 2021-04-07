public class Wrap {
    void runTimeExc(int type) {
        try {
            switch (type) {
                case 0: throw new BaseballException();
                case 1: throw new RuntimeException();
                default: return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e)
        }
    }
}
