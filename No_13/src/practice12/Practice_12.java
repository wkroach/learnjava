/**
 * Modify Groups.java to count all unique words
 * with no initial capital letter.
 */
/**
 * (?m): 匹配多行
 * (?=pattern): 匹配以pattern开头/结尾的串  (?=[A-Z])\\w+表示匹配所有大写字母开头串, \\w+(?=[A-Z])表示匹配所有大写字母结尾的串
 * (?!pattern): 匹配不以pattern开头/结尾的串 (?![A-Z])\\w+表示匹配所有不以大写开头的串, \\w+(?![A-Z])表示匹配所有不以大写字母结尾的串
 */
package practice12;
import java.util.regex.*;
import java.util.*;

public class Practice_12 {
    public static void main(String[] args){
        String str = "I love Rice\n" + "I love UCSD\n" + "I love uiuc\n";
        Group.match(str);
    }
}

class Group{
    private static Pattern PATTERN = Pattern.compile("(?m)(\\b((?![A-Z])\\w+)\\b)");
    public static void match(String str){
        Set<String> set = new HashSet<>();
        Matcher matcher = PATTERN.matcher(str);
        while(matcher.find()){
            set.add(matcher.group());
        }
        System.out.println(set);
    }
}

