/**
 * Write a program to determine whether an array
 * of char is a primitive type or a true object.
 */
/**
 * 所有Type[]数组全部是类，类类型为class [name
 * 如果Type为基本类型int, char....则name为基本类型首字母大写如class [C. class [I
 * 其他类型则为class [类型全名
 */
package practice10;
import java.util.*;
public class Practice_10 {
    public static void main(String[] args){
       char[] arr = {'I', 'L', 'o', 'v', 'e', 'R', 'i', 'c', 'e'};
       int[] arri = {1};
       double[] arrd = {1.0};
       Character[] arrc = {'i'};
       Exception[] arre = {new Exception()};
       System.out.println(arr.getClass());
       System.out.println(arri.getClass());
       System.out.println(arrd.getClass());
       System.out.println(arrc.getClass());
       System.out.println(arre.getClass());
    }
}
