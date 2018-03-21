/**
 * java中的String自己是永远不会变的，只能是创建新的String
 * 因此使用StringBuilder往往性能和内存使用比String更好
 */
package practice1;

public class Practice_1 {
    public static void fun(String s){
        s += "CMU";
    }
    public static void main(String[] args){
        String s = "I want AD from ";
        fun(s);
        System.out.println(s);
    }
}
