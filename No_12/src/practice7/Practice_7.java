/**
 * Modify Exercise 3 so that the catch clause logs
 * the results.
 */
package practice7;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Practice_7 {
    public static void main(String[] args){
        MyArray myArray = new MyArray(3);
        try{
            myArray.add(1);
            myArray.add(2);
            myArray.add(3);
            myArray.add(4);
        } catch (ArrayIndexOutOfBoundsException e){
            LogException.log(e);
        }
        try{
            myArray.get(-1);
            myArray.get(4);
        } catch (ArrayIndexOutOfBoundsException e){
            LogException.log(e);
        }
    }
}

class MyArray{
    private Integer[] arr;
    private Integer cursor = 0;
    public MyArray(Integer size){
        arr = new Integer[size];
    }
    public void add(Integer i){
        arr[cursor++] = i;
    }
    public Integer get(Integer i){
        return arr[i];
    }
}

class LogException{
    private static Logger logger = Logger.getLogger("I want AD");
    public static void log(Exception e){
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        logger.severe(stringWriter.toString());
    }
}
