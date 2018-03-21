/**
 * Repeat the previous exercise, but inside the
 * catch clause, wrap g()'s exception in a
 * RuntimeException
 */

/**
 * RuntimeException, Exception自带了cause初始化，如果想将一个自定义Exception
 * 以RuntimeError形式抛出，可以用RuntimeException包装
 */
package practice11;

public class Practice_11 {
    public static void f() throws MyException{
        throw new MyException();
    }
    public static void g(){
        try{
            f();
        } catch (MyException e){
            e.printStackTrace(System.out);
            //RuntimeException接受其他异常作作为cause初始化
            throw new RuntimeException(new MyException2());
        }
    }
    public static void main(String[] args){
        g();
    }
}

class MyException extends Exception{}
class MyException2 extends Exception{}
