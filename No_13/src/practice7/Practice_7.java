/**
 * Using the documentation for java.util.regex.Pattern
 * as a resource, write and test a regular expression
 * that checks a sentence to see that it begins with a
 * capital letter and ends with a period.
 */
package practice7;

public class Practice_7 {
    public static void main(String[] args){
        String str = "I love Rice.";
        String str2 = "I hate CMU!!!";
        String str3 = "i love Rice.";
        //这里加不加最后的$都可以,$表示末尾匹配
        System.out.println(str.matches("[A-Z].*\\.$"));
    }
}

