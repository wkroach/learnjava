/**
 * Modify SimpleDynamicProxy.java so that it
 * measures method-call times.
 */
/**
 * 动态代理使用格式：
 *          Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObject));
 * 对动态代理对象proxy的所有调用(包括隐式的toString())，都会间接使用调用处理器InvocationHandler
 * 的invoke方法进行调用
 * 所以：proxy.fun()等同于InvocationProxyHandler.invoke(proxy, fun, args)
 *
 * 获取动态代理proxy的类，调用处理器，等方法全部为Proxy的静态方法
 * Proxy.getInvocationHandler(),
 */
package practice22;
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
    private Map<Method, Integer> methodIntegerMap = new HashMap<>();
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
        Object ans = method.invoke(proxied, args);
        methodIntegerMap.put(method, methodIntegerMap.getOrDefault(method, 0) + 1);
        return ans;
    }

    @Override
    public String toString() {
        return methodIntegerMap.toString();
    }
}

public class SimpleDynamicProxy {
    private static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("I love Rice");
    }
    public static void main(String[] args){
        RealObject realObject = new RealObject();
        consumer(realObject);
        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObject)
        );
        consumer(proxy);
        /**
         * 对动态代理对象proxy的所有调用(包括隐式的toString())，都会间接使用调用处理器InvocationHandler
         * 的invoke方法进行调用
         * 所以：proxy.toString()等同于DynamicProxyHandler.invoke(proxy, toString, args)
         */
        System.out.println(proxy);
        /**
         * 由于所有方法调用实际在DynamicProxyHandler中进行，所以对调用方法次数的统计
         * 也应该在其中，而不是proxy中
         */
        System.out.println(Proxy.getInvocationHandler(proxy));
    }
}
