/**
 * Using the documentation for java.util.regex.Pattern
 * as a resource, replace all the vowels in
 * Splitting.knights with underscores.
 */

/**
 * String的正则替换要用replaceAll或者replaceFirst
 * 如果想大小写都替换，在正则式最开始写(?i)
 */
package practice9;

public class Practice_9 {
    public static void main(String[] args){
         String str = "Then, when YOU have found the shrubbery, you must "+
                    "cut down the mightiest tree in the forest..."+
                    "with... a herring!";
        System.out.println(str.replaceAll("[aeiouAEIOU]", "_"));
        //(?i)表示对大小写不敏感，大小写都考虑
        System.out.println(str.replaceAll("(?i)[aieou]", "_"));
        //replace只能按照字符匹配，不能按照正则匹配
        System.out.println(str.replace('y', 'i'));
    }
}
