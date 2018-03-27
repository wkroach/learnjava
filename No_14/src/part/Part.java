package part;
import factory.*;
import java.util.*;

public class Part{
    @Override
    public String toString(){
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
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
