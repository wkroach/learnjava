/**
 * Create two exception classes, each of which
 * performs its own logging automatically.
 * Demonstrate that these work.
 */
package practice6;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

public class Practice_6 {
    public static void main(String[] args){
        try{
            throw new MyException();
        } catch (MyException e){
        }
        try{
            throw new MyException2();
        } catch(MyException2 e){
        }
    }
}

class MyException extends Exception{
    static Logger logger = Logger.getLogger("MyException");
    public MyException(){
        StringWriter sw = new StringWriter();
        printStackTrace(new PrintWriter(sw));
       logger.warning(sw.toString());
    }
}

class MyException2 extends RuntimeException{
    static Logger logger = Logger.getLogger("MyException2");
    public MyException2(){
        StringWriter sw = new StringWriter();
        printStackTrace(new PrintWriter(sw));
        logger.info(sw.toString());
    }
}

