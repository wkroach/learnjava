/**
 * Create a class containing private, protected and
 * package access methods. Write code to access these
 * methods from outside of the class’s package.
 */
/**
 * 反射虽然牛逼，但是不安全
 */
package practice25;
import java.lang.reflect.*;

class A{
    public void f(){
        System.out.println("f()");
    }
    private void g(){
        System.out.println("g()");
    }
    protected void h(){
        System.out.println("h()");
    }
    void j(){
        System.out.println("j()");
    }
}
public class Practice_25 {
    public static void callHidenMethod(Object obj, String methodName) throws Exception{
       Method method = obj.getClass().getDeclaredMethod(methodName);
       method.setAccessible(true);
       method.invoke(obj);
    }
    public static void main(String[] args){
       A a = new A();
       try {
           callHidenMethod(a, "f");
           callHidenMethod(a, "g");
           callHidenMethod(a, "h");
           callHidenMethod(a, "j");
       }catch (Exception e){
           System.out.println(e);
       }
    }

}
