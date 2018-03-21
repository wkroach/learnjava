/**
 * Modify Turtle.java so that it sends all output to System.err.
 */
package practice3;
import java.util.*;
import java.io.*;

public class Practice_3 {
    public static void main(String[] args){
       Turtle turtle = new Turtle("wuke", new Formatter(System.err));
       ArrayList<String> arr = new ArrayList<>();
       arr.add("CMU");
       turtle.move(arr);
       arr.add("UCSD");
       turtle.move(arr);
       arr.add("UIUC");
       turtle.move(arr);
    }
}

class Turtle{
    private String name;
    private Formatter formatter;
    public Turtle(){};
    public Turtle(String name, Formatter formatter){
        this.name = name;
        this.formatter = formatter;
    }
    public void move(List<String> arr){
        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            if(sb.length() != 0){
               sb.append(" and ");
            }
            sb.append(s);
        }
       formatter.format("%s want AD from %s\n", name, sb.toString());
    }
}
