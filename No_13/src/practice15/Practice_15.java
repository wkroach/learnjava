/**
 * Modify JGrep.java to accept flags as arguments (e.g.,
 * Pattern.CASE_INSENSITIVE, Pattern.MULTILINE).
 */
/**
 * Scanner从File文件构造时，需要添加try-catch, 因为重载的从File初始化的Scanner构造器有FileNotFoundException声明
 */
package practice15;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Practice_15 {
    public static void main(String[] args){
       Pattern pattern = Pattern.compile("\\b((?=[A-Z])\\w+)\\b", Pattern.MULTILINE);
       File file = new File("No_13/src/universities.txt");
       try {
           Scanner scanner = new Scanner(file);
           int id = 0;
           while(scanner.hasNextLine()){
               String str = scanner.nextLine();
               System.out.println(str);
               Matcher matcher = pattern.matcher(str);
               while(matcher.find()){
                   System.out.printf("%d %s\n", ++id, matcher.group());
               }
               //System.out.println(str);
           }
       }catch (Exception e){
           System.err.println(e);
       }
    }
}
