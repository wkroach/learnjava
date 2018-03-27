/**
 * Write a method that takes an object and
 * recursively prints all the classes in that
 * object's hierarchy.
 */
/**
 * getInterfaces(): 返回类的所有接口数组
 * getSuperclass(): 返回类的父类，如果类没有父类则返回null
 */
package practice8;

import java.util.*;
public class Practice_8 {
    public static void fun(Object object){
        Class c = object.getClass();
        while(c != null){
            System.out.println(c);
            for(Class tmp: c.getInterfaces()){
                System.out.println(tmp);
            }
            c = c.getSuperclass();
        }
    }
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        fun(arr);
        System.out.println();
        fun(new NullPointerException());
    }
}
