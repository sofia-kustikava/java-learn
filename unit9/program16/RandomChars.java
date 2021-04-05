import java.util.*;
import java.nio.*;

class RandomChars implements Readable{
    private int count;
    RandomChars(int count){
        this.count = count;
    }
    private static Random rand = new Random(42);
    public int next() { return rand.nextInt(86) + 40; } //Sets range from 40 to 126 (ASCII table)
    public int read(CharBuffer buff){
        if (count-- == 0) return -1;
        for(int i = 0; i < count; i++) {
            buff.append((char)this.next() + " ");
        }
        buff.append(" ");
        return count;
    }
}
