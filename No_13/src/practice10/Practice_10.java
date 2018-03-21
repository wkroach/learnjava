/**
 * For the phrase "Java now has regular expressions"
 * evaluate whether the following expressions will find a
 * match:
 *
 * ^Java                匹配以Java开头的串
 * \Breg.*              匹配reg.*，\B表示reg前必须不是空白符, \b表示词分界处，即这个词前或者后没有词，一般为空白符或开头结尾
 * n.w\s+h(a|i)s        \s表示空白符
 * s?                   略
 * s*                   略
 * s+                   略
 * s{4}                 {n}表示重复n次
 * s{1}.
 * s{0,3}               {n,m}表示可重复n-m次
 */

package practice10;
import java.util.ArrayList;
import java.util.regex.*;

public class Practice_10 {
    public static void main(String[] args){
        String str = "Java now has regular expressions";
        String[] arr = {"^Java",
                        "\\Breg.*",
                        "n.w\\s+h(a|i)s",
                        "s?",
                        "s*",
                        "s+",
                        "s{4}",
                        "s{1}",
                        "s{0,3}"};
        for(String reg: arr) {
            TestRegular.regMatch(reg, str);
        }
    }
}

class TestRegular{
    public static void regMatch(String regx, String str){
        System.out.printf("regx: %s     source: %s\n", regx, str);
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.print("Match \"" + matcher.group() + "\" at positions" + matcher.start() + "-" + (matcher.end()-1));
            System.out.printf(" matched string: %s\n", str.substring(matcher.start(), matcher.end()));
        }
    }
}
