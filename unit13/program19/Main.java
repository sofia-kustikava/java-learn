//Building on the previous two exercises, write a program that examines
//Java source code and produces all the class names used in a particular program. 

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    private static final String SPLITER = "\n";
    private static boolean isInFormalAnnotation = false;
    public static String readFile(String path) {
        File inFile = new File(path);
        if( !inFile.exists() || !inFile.isFile() ) {
            System.out.println("Path ERROR! Check your path " + path);
            return null;
        }
        StringBuilder resultString = new StringBuilder();
        try {
            BufferedReader buffReader = new BufferedReader( new FileReader( inFile) );
            try {
                String textLine = new String("");
                while (true) {
                    textLine = buffReader.readLine();
                    if (textLine == null) {
                        break;
                    }
                    resultString.append(textLine + SPLITER);
                }
            } finally {
                buffReader.close();
            }
        } catch (IOException ioe) {
            System.out.println( "ERROR when reading the file " + inFile.getName() );
        }
        return resultString.toString();
    }


    public static String filterAnnotation(String path){
        StringBuilder resultBuilder = new StringBuilder();
        String content = readFile(path);
        if (content == null || content.isEmpty()) {
            System.out.println("Method scan() cannot read file " + path);
            return null;
        }
        String noSimpleAnnotation = new String("");
        String noFormalAnnotation = new String("");
        for (String line : content.split(SPLITER)) {
            //main procedure
            noSimpleAnnotation = eraseSimpleAnnotation(line);
            noFormalAnnotation= eraseFormalAnnotation(noSimpleAnnotation);
            if (noFormalAnnotation != null) {
                //System.out.println(noFormalAnnotation);
                resultBuilder.append(noFormalAnnotation + SPLITER);
            }
        }
        return resultBuilder.toString();
    }

    private static String eraseSimpleAnnotation(String line) {
        String simpleAnnotationRegex = "\\s//";
        Matcher simpleAnnotationMatcher = Pattern.compile(simpleAnnotationRegex).matcher(line);
        while (simpleAnnotationMatcher.find()) {
            if (!isInStringQuote(line.substring(0, simpleAnnotationMatcher.start()))) {
                return line.substring(0, simpleAnnotationMatcher.start());
            }
        }
        return line;
    }

    private static String eraseFormalAnnotation(String line) {
        String formalBeginRegex = "/\\*";
        String formalEndRegex = "\\*/";
        if (!isInFormalAnnotation) {
            Matcher formalBeginMatcher = Pattern.compile(formalBeginRegex).matcher(line);
            while (formalBeginMatcher.find()) {
                if (!isInStringQuote(line.substring(0,formalBeginMatcher.start()))) {
                    isInFormalAnnotation = true;
                    String subLine = line.substring(formalBeginMatcher.start());
                    Matcher formalEndMatcher = Pattern.compile(formalEndRegex).matcher(subLine);
                    if (formalEndMatcher.find()) {
                        isInFormalAnnotation = false;
                        return line.replace(subLine.substring(0,formalEndMatcher.end()),"");
                    }
                    return line.replace(subLine,"");
                }
            }
        } else {
            Matcher formalEndMatcher = Pattern.compile(formalEndRegex).matcher(line);
            if (formalEndMatcher.find()) {
                isInFormalAnnotation = false;
            }
            return null;
        }
        return line;
    }

    private static boolean isInStringQuote(String prefix) {
        String doubleQuoteRegex = "(^|\\s*)\".*?[^\\\\]\"|\"\"";
        Matcher doubleQuoteMatcher = Pattern.compile(doubleQuoteRegex).matcher(prefix);
        if(! doubleQuoteMatcher.find()) {
            String singleQuoteRegex = "[^\\\\]\"";
            Matcher singleQuoteMatcher = Pattern.compile(singleQuoteRegex).matcher(prefix);
            return singleQuoteMatcher.find();
        } else {
            return isInStringQuote(prefix.replaceFirst(doubleQuoteRegex, ""));
        }
    }

    private static String filterLiteralString(String content) {
        if (content == null || content.isEmpty()) {
            System.out.println("filterLiteralString() get null content!");
            return null;
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (String line : content.split(SPLITER)) {
            resultBuilder.append(eraseLiteralString(line) + SPLITER);
        }
        return resultBuilder.toString();
    }
    
    private static String eraseLiteralString(String line) {
        String doubleQuoteRegex = "(^|\\s*)\".*?[^\\\\]\"|\"\"";
        Matcher doubleQuoteMatcher = Pattern.compile(doubleQuoteRegex).matcher(line);
        while (doubleQuoteMatcher.find()) {
            line = line.replace(doubleQuoteMatcher.group(),"");
        }
        return line;
    }

    private static String filterEmptyLine(String content) { //删除空行
        if (content == null || content.isEmpty()) {
            System.out.println("filterEmptyLine() get null content!");
            return null;
        }
        String emptyRegex = "(?m)^\\s*$";
        StringBuilder resultBuilder = new StringBuilder();
        Matcher emptyMatcher = Pattern.compile(emptyRegex).matcher("");
        for (String line : content.split(SPLITER)) {
            emptyMatcher = emptyMatcher.reset(line);
            if (!emptyMatcher.find()) {
                resultBuilder.append(line + SPLITER);
            }
        }
        return resultBuilder.toString();
    }

    private static Set<String> segmentWords(String content) {
        if (content == null || content.isEmpty()) {
            System.out.println("segmentWords() get null content!");
            return null;
        }
        Set<String> wordsFound = new HashSet<String>();
        String wordsRegex = "\\W([A-Z]\\w*)";
        Matcher wordsMatcher = Pattern.compile(wordsRegex).matcher("");
        for (String line : content.split(SPLITER)) {
            wordsMatcher = wordsMatcher.reset(line);
            while (wordsMatcher.find()) {
                wordsFound.add(wordsMatcher.group(1));
            }
        }
        return wordsFound;
    }

    private static void start(String path) {
        String noAnnotation = filterAnnotation(path);
        String noLiteral = filterLiteralString(noAnnotation);
        String meaningfulCode = filterEmptyLine(noLiteral);
        Set<String> className = segmentWords(meaningfulCode);
        System.out.println(className);
    }

    private static void testUnitFilterAnnotation() {
        String wrongPath = "/Users/Mark/java/com/learnjava/Main.java";
        String rightPath = "/Users/Sofia/java/com/learnjava/Main.java";
        Main.filterAnnotation(rightPath);
        Main.filterAnnotation(wrongPath);
    }

    private static void testIsInStringQuote(String prefix) {
        System.out.println(isInStringQuote(prefix));
    }
    private static void testUnitEraseLiteralString(String phrase) {
        System.out.println(eraseLiteralString(phrase));
    }
    private static void testUnitFilterLiteralString(String content) {
        System.out.println(filterLiteralString(content));
    }
    private static void testUnitStart() {
        String wrongPath = "/Users/Mark/java/com/learnjava/Main.java";
        String rightPath= "/Users/Sofia/java/com/learnjava/Main.java";
        Main.start(rightPath);
        Main.start(wrongPath);
    }
    private static void testUnitDoubleQuotePattern(String regex) {
        String path = "/Users/Sofia/text.txt";
        Matcher doubleQuoteMatcher = Pattern.compile(regex).matcher("");
        String content = readFile(path);
        for(String line : content.split(SPLITER)) {
            doubleQuoteMatcher = doubleQuoteMatcher.reset(line);
            System.out.println("FOUND");
            while (doubleQuoteMatcher.find()) {
                System.out.println("    >>>" + doubleQuoteMatcher.group());
            }

        }
    }
    private static void testUnitDoubleQuoteReplace(String regex) {
        String path = "/Users/Sofia/text.txt";
        Matcher doubleQuoteMatcher = Pattern.compile(regex).matcher("");
        String content = readFile(path);
        for(String line : content.split(SPLITER)) {
            doubleQuoteMatcher = doubleQuoteMatcher.reset(line);
            System.out.println("FOUND");
            while (doubleQuoteMatcher.find()) {
                System.out.println("    >>>" + doubleQuoteMatcher.group());
                line = line.replace(doubleQuoteMatcher.group(),"");
            }
            System.out.println(line);
        }
    }
    public static void main(String[] args) {
        String testPatternString = "a" + "b //Comment" + "c" + "d";
        String testPatternString2 = "\"a\" + \"b //Comment";
        Main.testUnitStart();
        String doubleQuoteRegex1 = "\".*\"";
        String doubleQuoteRegex2 = "\".*?\"";
        String doubleQuoteRegex3 = "[^\\\\]\".*?[^\\\\]\"";
        String doubleQuoteRegex4 = "[^\\\\]\".*?[^\\\\]\"|^\".*?[^\\\\]\"|\"\"";
        String doubleQuoteRegex5 = "(^|\\s*)\".*?[^\\\\]\"|\"\"";
    }
}
