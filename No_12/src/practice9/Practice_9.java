/**
 * Create three new types of exceptions. Write a
 * class with a method that throws all three. In
 * main(), call the method but only use a single
 * catch clause that will catch all three types
 * of exceptions.
 */

/**
 * catch一个基类Exception可以handle住它的所有子类Exception
 */
package practice9;

public class Practice_9 {
    public static void main(String[] s){
       try{
           throw new MyException();
       } catch (Exception e){
            System.out.println(e);
       }
       try{
           throw new MyException1();
       } catch (Exception e){
           System.out.println(e);
       }
       try{
           throw new MyException2();
       }catch (Exception e){
           System.out.println(e);
       }
    }
}

class MyException extends Exception{}
class MyException1 extends Exception{}
class MyException2 extends RuntimeException{}
