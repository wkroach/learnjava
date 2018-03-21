/**
 * Modify Exercise 9 by adding a finally clause.
 * Verify that your finally clause is executed, even
 * if a NullPointerException is thrown.
 */

/**
 * finally可以无视try中的Exception抛出，return执行
 * finally可以无视try中的break, continue
 */
package practice13;

public class Practice_13 {
    public static void fun(){
        throw new NullPointerException();
    }
    public static void fun2(){
        try{
            return;
        } finally {
            System.out.println("finally even return");
        }
    }
    public static void main(String[] s){
        fun2();
       try{
           fun();
           throw new MyException();
       } catch (MyException e){
            System.out.println(e);
       } finally {
           System.out.println("finally");
       }

       for(int i = 0; i < 4; ++i){
           try{
               break;
           }finally {
               System.out.println("finally ignore break in try");
           }
       }
       for(int i = 0; i < 4; ++i){
           try{
               continue;
           }finally {
               System.out.println("finally ignore continue in try");
           }
       }
    }
}

class MyException extends Exception{}
class MyException1 extends Exception{}
class MyException2 extends RuntimeException{}
