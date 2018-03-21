/**
 * Create a class with a method that takes a String
 * argument and produces a result that swaps each
 * pair of characters in that argument. Adapt the
 * class to work with
 * interfaceprocessor.Apply.process()
 */
/**
 * 实现一个适配器(Adapter)设计模式，用Process配合SwapStringAdapter调用一个
 * 交换相邻字符的swapString方法
 */
package practice11;
import java.util.*;
public class Practice_11 {
    public static void main(String[] args){
        String s = "12";
        Apply.process(new SwapStringAdapter(new SwapString()), s);
    }
}

interface Processor{
    String name();
    Object process(Object s);
}

class Apply{
    public static void process(Processor p, Object s){
       System.out.println("Using Processor " + p.name());
       System.out.println(p.process(s));
    }
}

class SwapStringAdapter implements Processor{
    SwapString swapString;
    public SwapStringAdapter(SwapString swapString){
        this.swapString = swapString;
    }
    @Override
    public String name(){
        return swapString.name();
    }
    @Override
    public String process(Object s){
        return swapString.swapString((String)s);
    }
}

class SwapString{
    public String name(){
        return getClass().getSimpleName();
    }

    //可以将swapString变成static方法，使结构更加好
    public String swapString(String s){
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length-1; i += 2){
           char tmp = array[i];
           array[i] = array[i+1];
           array[i+1] = tmp;
        }
        return new String(array);
    }
}
