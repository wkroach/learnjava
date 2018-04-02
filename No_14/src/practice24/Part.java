/**
 * Add Null Objects to RegisteredFactories.java.
 */
/**
 * 标答里单独使用了IPart作为interface, 我觉得这样不好，没有必要为了动态代理多加一个接口
 * 直接将Part作为接口就可以了，注册工厂单独放在Part的子类Creater里，其余与标答类似
 *
 * 除了修改基类和添加Handler类，其他子类的结构均没有改动
 */
package practice24;

import factory.Factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 动态代理必须继承接口而不能是类，因此代理和被代理对象的基类必须是接口
 */
public interface Part{
    /**
     * 注册工厂可以放在内部类中
     */
    class Creator {
        /**
         * 直接使用Class的newInstance创建对象
         * 注意List的泛型参数为CLass<? extends Part>而不是<? extends Part>
         */
        static List<Class<? extends Part>> partClasses = new ArrayList<>();
        /**
         * 使用注册工厂创建对象
         */
        static List<Factory<? extends Part>> partFactories = new ArrayList<>();

        static {
            partFactories.add(new FuelFilter.Factory());
            partFactories.add(new AirFilter.Factory());
            partClasses.add(FuelFilter.class);
            partClasses.add(AirFilter.class);

        }

        private static Random rand = new Random(47);

        public static Part createRandom() {
            int n = rand.nextInt(partFactories.size());
            return partFactories.get(n).create();
        }

        public static Part classCreateRandom() {
            int n = rand.nextInt(partClasses.size());
            try {
                return partClasses.get(n).newInstance();
            } catch (Exception e) {
                throw (RuntimeException) e;
            }
        }

        public static Part createNullPart(){
            return createNullPart(Part.class);
        }

        public static Part createNullPart(Class type){
           return (Part)Proxy.newProxyInstance(
                   Part.class.getClassLoader(),
                   new Class[]{Part.class, Null.class},
                   new NullPartProxyHandler(type)
           );
        }
    }
}

class NullPartProxyHandler implements InvocationHandler{
    private Part nullPart = new NPart();
    private String typeName;

    NullPartProxyHandler(Class type){
        typeName = type.getName();
    }
    class NPart implements Part {
        @Override
        public String toString() {
            return typeName + " nullPart";
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        return method.invoke(nullPart, args);
    }
}

class Filter implements Part {}

class FuelFilter extends Filter {
   public static class Factory implements factory.Factory<FuelFilter>{
       @Override
       public FuelFilter create(){
           return new FuelFilter();
       }
   }
}

class AirFilter extends Filter {
   public static class Factory implements factory.Factory<AirFilter>{
       @Override
       public AirFilter create(){
           return new AirFilter();
       }
   }
}
