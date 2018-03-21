/**
 * Write a class with a method that throws an
 * exception of the type created in Exercise 4.
 * Try compiling it without an exception
 * specification to see what the compiler says.
 * Add the appropriate exception specification.
 * Try out your class and its exception inside a
 * try-catch clause.
 */

/**
 * 异常说明的作用:
 *      告诉使用此方法的人: 这个方法可能会抛出这些异常
 *      因此除RuntimeException之外，没有预先声明异常说明是不能throw异常的(因为使用者不能预先知道会抛异常)
 *      如果要抛出异常，必须在方法内部handle，不能跳出方法
 */
package practice8;

public class Practice_8 {
    public static void fun(){
       //!throw new MyException();
    }
    public static void fun1() throws MyException{
        throw new MyException();
    }
    public static void main(String[] args){
       //try{
          //fun();
       //} catch (MyException e){
        //   System.out.println(e);
       //}

       try{
           fun1();
       }catch (MyException e){
           System.out.println(e);
       }
    }
}

class MyException extends Exception{}
