/**
 * Create your own exception class using the
 * extends keyword. Write a constructor for this
 * class that takes a String argument and stores
 * it inside the object with a String reference.
 * Write a method that prints out the stored
 * String. Create a try-catch clause to exercise
 * your new exception.
 */
package practice4;

public class Practice_4 {
    public static void main(String[] args){
       try{
           throw new MyException("I want AD");
       } catch (MyException e){
           System.out.println(e.getMessage());
           e.printStackTrace(System.out);
       }
    }
}

class MyException extends Exception{
    private String ss;
    public MyException(){}
    public MyException(String s){
        super(s);
        this.ss = s;
    }

    @Override
    public String getMessage() {
        return ss;
    }
}
