/**
 * Create an interface with a nested class
 * and a static method that calls the methods
 * of your interface and displays the results.
 * Implement your interface and pass an instance of
 * your implementation to the method.
 */
package practice21;

public class Practice_21 {
    static public void main(String[] args){
        //匿名内部类可以在能够new的任何地方创建
        I impl = new I(){
            @Override
            public void f(){
                System.out.println("impl f()");
            }
        };
        //由于Inner和fun都是static的，所以可以直接用
        I.Inner.fun(impl);
    }
}

interface I{
    void f();
    class Inner{
        static void fun(I impl){
            impl.f();
        }
    }
}


