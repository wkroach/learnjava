/**
 *  Modify Receipt.java so that the widths are all
 *  controlled by a single set of constant values.
 *  The goal is to allow you to easily change a
 *  width by changing a single value in one place.
 */

/**
 * 修改一处位置便能修改整个字符串的格式
 * 比较好的做法是将格式字符串单独提出来
 * 再分别用静态常量表示width和precision
 */
package practice4;
import java.util.*;
import java.io.*;

public class Practice_4 {
    public static final int WIDTH = 10;
    public static final int PRECISION = 5;
    public static final String FRMT= "%-" + WIDTH + "." + PRECISION;
    public static final String IFRMT = "%-" + WIDTH;
    public static void main(String[] args){
        String iFrmt = IFRMT + "d";
        String dFrmt = FRMT + "f";
        String sFrmt = FRMT + "s";
        Formatter f = new Formatter(System.out);
        f.format(iFrmt+dFrmt+sFrmt,100, 3.1415926, "I love Rice");
    }
}
