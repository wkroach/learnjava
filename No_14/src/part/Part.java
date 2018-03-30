package part;
import factory.*;
import java.util.*;

public class Part{
    @Override
    public String toString(){
        return getClass().getSimpleName();
    }

    /**
     *直接使用Class的newInstance创建对象
     * 注意List的泛型参数为CLass<? extends Part>而不是<? extends Part>
     */
    static List<Class<? extends Part>> partClasses = new ArrayList<>();
    /**
     *使用注册工厂创建对象
     */
    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partClasses.add(FuelFilter.class);
        partClasses.add(AirFilter.class);

    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
    public static Part classCreateRandom(){
       int n = rand.nextInt(partClasses.size());
       try {
           return partClasses.get(n).newInstance();
       } catch (Exception e){
           throw (RuntimeException)e;
       }
    }
}
class Filter extends Part{}
class FuelFilter extends Filter{
   public static class Factory implements factory.Factory<FuelFilter>{
       @Override
       public FuelFilter create(){
           return new FuelFilter();
       }
   }
}
class AirFilter extends Filter{
   public static class Factory implements factory.Factory<AirFilter>{
       @Override
       public AirFilter create(){
           return new AirFilter();
       }
   }
}
