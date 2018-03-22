/**
 * Create a class that contains int, long, float and double
 * and String fields. Create a constructor for this class
 * that takes a single String argument, and scans that
 * string into the various fields. Add a toString() method
 * and demonstrate that your class works correctly.
 */
/**
 * Java String 判等特性：
 * ==: 比较引用
 * equals(): 比较值
 * 重要：String默认初始化时，String s1 = "abc"; String s2 = "abc; 由于已有一个"abc"引用，则编译器默认不再新建引用，而是直接使用s1
 *      如果不使用默认初始化， String s1 = new String("abc"); String s2 = new String("abc")，则这是两个引用，==返回false
 */
package practice20;

import java.util.Arrays;
import java.util.Scanner;

public class Practice_20 {
    public static void main(String[] args){
       String str = "int:100, long:1000000, float:3.14, double:3.1415926, String:I love Rice";
       A a = new A(str);
       System.out.println(a);
    }
}

class A{
    private Integer i;
    private Long l;
    private Float f;
    private Double d;
    private String s;

    public A(String str){
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter("\\s*,\\s*");
        while(scanner.hasNext()) {
            String tmps = scanner.next();
            String[] arr = tmps.split(":");
            if("int".equals(arr[0])){
                i = Integer.valueOf(arr[1]);
            } else if("long".equals(arr[0])){
                l = Long.valueOf(arr[1]);
            } else if("float".equals(arr[0])){
                f = Float.valueOf(arr[1]);
            } else if("double".equals(arr[0])){
                d = Double.valueOf(arr[1]);
            } else if("String".equals(arr[0])){
                s = arr[1];
            }
        }
    }

    @Override
    public String toString() {
        return i.toString() + " " + l.toString() + " " +  f.toString() + " " +  d.toString() + " " + s;
    }
}
