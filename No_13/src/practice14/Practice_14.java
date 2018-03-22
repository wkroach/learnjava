/**
 *  Rewrite SplitDemo using String.split().
 */
/**
 * split(str, limit): limit表示最后分割出的字符串数目上限
 */
package practice14;
import java.util.regex.*;
import java.util.*;

public class Practice_14 {
    public static void  main(String[] args){
        String str = "I!!love!!Rice!!Rice!!love!!me";
        SplitDemo.regxSplitDemo(str);
        SplitDemo.splitDemo(str);
    }
}

class SplitDemo{
    public static void regxSplitDemo(String str){
        System.out.println("Regex split");
        System.out.println(Arrays.toString(Pattern.compile("!!").split(str)));
        System.out.println(Arrays.toString(Pattern.compile("!!").split(str, 3)));
    }
    public static void splitDemo(String str){
        System.out.println("String split");
        System.out.println(Arrays.toString(str.split("!!")));
        System.out.println(Arrays.toString(str.split("!!", 3)));
    }
}
