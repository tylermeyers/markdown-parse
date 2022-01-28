// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )

        String[] contentsArray = markdown.split("\n");
        for(String s: contentsArray){
            if(s.contains("[") && s.contains("]") && s.contains("(") && s.contains(")") && !s.startsWith("!"))
                toReturn.add(s.substring(s.indexOf("(")+1, s.length()-1));
        }

        return toReturn;
        /* int currentIndex = 0;
        String[] contentsArray = markdown.split("\n");
        for(String s: contentsArray){
            if(s.indexOf("[")==0){
                while(currentIndex < markdown.length()) {
                    int nextOpenBracket = markdown.indexOf("[", currentIndex);
                    int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
                    int openParen = markdown.indexOf("(", nextCloseBracket);
                    int closeParen = markdown.indexOf(")", openParen);
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                    currentIndex = closeParen + 1;
                }
            }
        } */
        /*
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }
        //*/
        //return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}