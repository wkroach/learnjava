/**
 * Create a class with two methods, f() and g().
 * In g(), throw an exception of a new type that
 * you define. In f(), call g(), catch its
 * exception and, in the catch clause, throw a
 * different exception (of a second type that you
 * define). Test your code in main().
 */
package practice10;

public class Practice_10 {
    public static void f() throws MyException{
        throw new MyException();
    }
    public static void g() throws MyException2{
        try{
            f();
        } catch (MyException e){
            e.printStackTrace(System.out);
            throw new MyException2();
        }
    }
    public static void main(String[] args){
        try{
            g();
        } catch (MyException2 e){
            e.printStackTrace(System.out);
        }
    }
}

class MyException extends Exception{}
class MyException2 extends Exception{}
