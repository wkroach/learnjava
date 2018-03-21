/**
 * Create a class with a main() that throws an
 * object of class Exception inside a try block.
 * Give the constructor for Exception a String
 * argument. Catch the exception inside a catch
 * clause and print the String argument. Add a
 * finally clause and print a message to prove
 * you were there.
 */
package practice1;

public class Practice_1 {
    public static void main(String[] args){
        try{
            throw new Exception("I want AD");
        } catch (Exception e){
            System.out.println("message: " + e.getMessage());
            e.printStackTrace(System.out);
        } finally {
            System.out.println("finally");
        }
    }
}
