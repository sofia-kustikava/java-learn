import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Vow {Set<String> vowels = new HashSet<String>();
    static String file = "C:\\UniqueWords.txt";
    int totalcount = 0;
    public Vow() {
        Collections.addAll(vowels, "A E I O U Y a e i o u y".split(" "));
    }

    private static String readFile() throws IOException {
        FileInputStream stream = new FileInputStream(file);
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            return Charset.defaultCharset().decode(bb).toString();
        }
        finally {
            stream.close();
        }
    }

    public void vowelCounter() throws IOException {
        for(String s : readFile().split(" ")){
            int inwordcount = 0;
            for (String c : s.split("")){
                if (this.vowels.contains(c)){
                    inwordcount++;
                }

            }
            System.out.println("Vowels count in word \"" + s + "\" is " + inwordcount);
            totalcount = totalcount + inwordcount;
        }
        System.out.println("Total number of vowels in file \"" + file + "\" is " + totalcount);
    }
}
