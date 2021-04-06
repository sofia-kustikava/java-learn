import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;

class Count {
    HashMap<String, Integer> words = new HashMap<String, Integer>();
    static String file = "C:\\Text.txt";

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

    public void wordCounter() throws IOException {
        int totalcountintext;
        for(String s : readFile().split(" ")){
            if (this.words.containsKey(s)){
                totalcountintext = words.get(s);
                words.remove(s);
                words.put(s, ++totalcountintext);
            } else{
                words.put(s, 1);
            }
        }
        System.out.println("The count for each word in file \"" + file + "\" is " + words);
    }
}
