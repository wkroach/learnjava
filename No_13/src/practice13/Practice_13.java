/**
 * Modify StartEnd.java so that it uses Groups.POEM as
 * input, but still produces positive outputs for find(),
 * lookingAt() and matches().
 */
/**
 * find(): 一直找到匹配的子串，直到串的结尾
 * lookingAt(): 从串的最开头开始匹配，并只匹配成功一次
 * matches(): 从串的最开头开始匹配，且只有整个串都能匹配才算匹配成功
 */
package practice13;
import java.util.regex.*;
import java.util.*;

public class Practice_13 {
    private static Pattern pattern = Pattern.compile("(?m)\\b((?=[A-Z])\\w+)\\b");
    public static void main(String[] args){
        //find()和lookingAt()可以匹配
       String str = "I love Rice\n" + "I hate UIUC\n" + "I hate CMU\n";
       //find()可以匹配
       String str2 = "i love Rice";
       //find(), lookingAt(), matches()都可以匹配
       String str3 = "IloveRice";
       Matcher matcher = pattern.matcher(str3);
       while(matcher.find()){
           System.out.printf("find(): %s start(): %s end(): %s\n", matcher.group(),matcher.start(), matcher.end());
       }
       if(matcher.lookingAt()){
           System.out.printf("lookingAt(): %s start(): %s end(): %s\n", matcher.group(), matcher.start(), matcher.end());
       }
       if(matcher.matches()){
           System.out.printf("matches(): %s start(): %s end(): %s\n", matcher.group(), matcher.start(), matcher.end());
       }
    }
}

