/**
 * Modify the regular expression in ShowMethods.java to
 * also strip off the keywords native and final.
 * (Hint: Use the OR operator '|'.)
 */
/**
 * getMethods: 返回所有继承自父类和自己的public方法
 * getDeclaredMethods: 返回所有自己的方法，无论public, private, protected, package
 * \\w+\\.可以匹配函数和类名之前的路径如java.util.等
 */
package practice17;
import java.util.*;
import java.util.regex.*;
import java.lang.reflect.*;
public class ShowMethods {
    private static Pattern pattern = Pattern.compile("(\\w+\\.|native\\s|final\\s)");
    private void test(){}
    public static void main(String[] args){
       if(args.length < 1){
           System.exit(0);
       }
       try{
           Class<?> c = Class.forName(args[0]);
           Method[] methods = c.getMethods();
           Method[] declaredMethods = c.getDeclaredMethods();
           Constructor[] constructors = c.getConstructors();
           Constructor[] declaredConstructors = c.getDeclaredConstructors();

           System.out.println("methods: ");
           for(Method method: methods){
               System.out.println(pattern.matcher(method.toString()).replaceAll(""));
           }
           System.out.println("declaredMethods: ");
           for(Method method: declaredMethods){
               System.out.println(pattern.matcher(method.toString()).replaceAll(""));
           }
           System.out.println("constructor: ");
           for(Constructor constructor : constructors){
               System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
           }
           System.out.println("declaredConstructors: ");
           for(Constructor constructor: declaredConstructors){
               System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
           }
       } catch (ClassNotFoundException e){
           System.out.println(e);
       }
    }
}
