/**
 * Modify the previous exercise so that it uses
 * Class.getDeclaredFields() to also display
 * information about the fields in a class.
 */
/**
 * getDeclairedFields()返回Field的数组，存放的是类的所有域
 */
package practice9;
import java.lang.reflect.Field;
import java.util.*;
public class Practice_9 {
    public static void fun(Class c){
        if(c == null){
            return ;
        }
        System.out.println(c + " 's fields:");
        for(Field field: c.getDeclaredFields()){
            System.out.println(field);
        }
        for(Class tmp: c.getInterfaces()){
            fun(tmp);
        }
        fun(c.getSuperclass());
    }
    public static void main(String[] args){
       ArrayList<Integer> arr = new ArrayList<>();
       fun(arr.getClass());
    }
}
