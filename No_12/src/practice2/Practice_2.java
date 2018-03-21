/**
 * Define an object reference and initialize it
 * to null. Try to call a method through this
 * reference. Now wrap the code in a try-catch
 * clause to catch the exception.
 */
package practice2;

public class Practice_2 {
    public static void main(String[] args){
        A a = new A(42);
        A a2 = null;
        try{
            System.out.println(a.toString());
            System.out.println(a2.toString());
        } catch (Exception e){
            //e的类型为NullPointerException
           e.printStackTrace(System.out);
        }
    }
}

class A{
    private Integer i = 0;
    public A(int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return "A: " + i.toString();
    }
}
