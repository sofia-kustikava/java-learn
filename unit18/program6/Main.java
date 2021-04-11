//Use ProcessFiles to find all the Java source-code files in a particular
//directory subtree that have been modified after a particular date. 

import java.io.*;
import java.text.*;
import java.util.*;

public class ModifiedAfter6 {
    public static void main(final String[] args) {
        if(args.length != 2) {
            System.out.println("(mm/dd/yyyy)");
            return;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                Date modDate = new Date(file.lastModified());
                try {
                    if(modDate.after(sdf.parse(args[1])))
                        System.out.println(file);
                } catch(ParseException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "java").start(args);
    }
}
