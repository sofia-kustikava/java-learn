//Modify DirList.java (or one of its variants) so that the FilenameFilter
//opens and reads each file (using the net.mindview.util.TextFile utility) and accepts the
//file based on whether any of the trailing arguments on the command line exist in that file. 

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(final String[] args) {
        File path = new File("/Users/Sofia/projects/com/java/second/package6");
        String[] list;
        final String p;
        if(args.length == 0){
            p=".*gen.*";
        }else{
            p=args[0];
        }

        list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(p);
            public boolean accept(File dir, String name) {
                boolean result=false;
                try{
                    BufferedReader br=new BufferedReader(new FileReader(new File(dir.getAbsolutePath()+"/"+name)));
                    while(true){
                        String line=br.readLine();
                        if(line==null){break;}
                        if(pattern.matcher(line).matches()){
                            result=true;
                        }
                    }
                }catch(Exception e){
                    System.out.println("Can't open that file:  "+dir.getAbsolutePath()+name);
                }
                return result;
            }
        });

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem+":   contains "+p);
    }
}
