/**
 * In ToyTest.java, use reflection to create a
 * Toy object using the nondefault constructor.
 */
/**
 * 反射的getConstructors, 返回Constructor[]
 * Constructor.getParameterTypes可以得到每个constructor对应的parameters的类型列表(Class[])
 * getConstructor的输入参数同样是parameters的类型列表(Class[])，用来查找constructor
 * 由于对应参数列表的constructor可能没有，所以可能抛异常
 * 使用constructor时，参数为Object[]，每个object为对应参数类型的实例
 * 重要！！！！函数参数中的基本类型不等于包装器类型，即int.class不等与Integer.class
 */
package practice19;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
   //public Toy(){}
   public Toy(int i){}
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots {
  public FancyToy(int i){super(i);}
}

public class ToyTest {
    public static void printInfo(Class cc){
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args){
        Class c = null;
        try{
            c = Class.forName("practice19.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try{
            Constructor[] constructors = up.getDeclaredConstructors();
            for(Constructor constructor: constructors){
                Class[] parameterTypes = constructor.getParameterTypes();
                List<Object> parameters = new ArrayList<>();
                for(Class type: parameterTypes){
                    /**
                     * 使用反射的methods和constructors时，函数的参数一定要明确
                     * 参数为基本类型如int, 则与包装器类型Integer的class不匹配
                     * 使用反射判断函数参数类型时，只判断int或Integer可能会漏判(其他基本类型同理)
                     */
                   if(type == Integer.class || type == int.class){
                       parameters.add(Integer.valueOf(1));
                   }else if(type == String.class){
                       parameters.add("I love Rice");
                   }else if(type == Double.class || type == double.class){
                       parameters.add(Double.valueOf(3.14));
                   }
                }
                if(parameters.size() == 1){
                    obj = constructor.newInstance(parameters.toArray());
                    try {
                        /**
                         * getConstructor, getMethod的参数与Method.getParameterType的返回值一样
                         * 都是Class[], 但是使用时需要注意NoSuchMethodException e
                         */
                        System.out.println(c.getDeclaredConstructor(parameterTypes));
                    }catch (NoSuchMethodException e){
                        System.out.println(e);
                    }
                    break;
                }
            }
        } catch (InstantiationException e){
            //如果Toy没有默认构造器，则newInstance时会报InstantiationException
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        } catch (InvocationTargetException e){
            System.out.println(e);
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
