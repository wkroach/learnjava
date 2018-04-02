/**
 * Inside invoke() in SimpleDynamicProxy.java,
 * try to print the proxy argument and explain
 * what happens.
 */
/**
 * 重要！！！：由于所有对动态代理proxy的调用，全部会重定向到InvocationHandler中调用invoke,
 * 所以一定不能在invoke中再调用proxy的方法，会产生无穷递归
 *
 * 重要！！！： 使用newProxyInstance()和getProxyClass()时使用的ClassLoader，
 * 有一个必要条件：动态代理继承的接口类型必须对此ClassLoader可见
 * 一般使用创建此动态代理的类的ClassLoader
 */
package practice23;
import java.lang.reflect.*;
import java.util.*;
import practice21.*;

interface Interface{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface{
    @Override
    public void doSomething() {
       System.out.println("doSomething");
    }
    @Override
    public void somethingElse(String arg) {
       System.out.println("somethingElse" + " " + arg);
    }
}

class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + " , args: " + args);
        try{
            for(Object arg: args){
                System.out.println(arg);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        /**
         * 禁止在InvocationHandler的invoke函数中调用proxy的方法，会产生无穷递归
         */
        //System.out.println(proxy);
        Object ans = method.invoke(proxied, args);
        return ans;
    }

}

public class SimpleDynamicProxy {
    private static void consumer(Interface iface){
        iface.doSomething();
    }
    public static void main(String[] args){
        RealObject realObject = new RealObject();
        consumer(realObject);
        /**
         * 此处的ClassLoader可以使用Interface.class.getClassLoader()
         * 也可以使用SimpleDynamicProxy.class.getClassLoader()
         */
        Interface proxy = (Interface)Proxy.newProxyInstance(
                SimpleDynamicProxy.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObject)
        );
        consumer(proxy);
    }
}
