/**
 *  Create a Cycle interface, with implementations
 *  Unicycle, Bicycle, and Tricycle. Create factories
 *  for each type of Cycle, and code that uses these factories.
 */
/**
 * 工厂模式(factory)
 */
package practice18;


public class Practice_18 {
    static public void cycleCosumer(Factory factory){
        System.out.println(factory.getCycle());
    }
    static public void main(String[] args){
        cycleCosumer(new UnicycleFactory());
        cycleCosumer(new BicycleFactory());
        cycleCosumer(new TricycleFactory());
    }
}

interface Cycle{
    @Override
    String toString();
}
interface Factory{
    Cycle getCycle();
}
class Unicycle implements Cycle{
    @Override
    public String toString() {
        return "Unicycle";
    }
}
class Bicycle implements Cycle{
    @Override
    public String toString(){
        return "Bicycle";
    }
}
class Tricycle implements Cycle{
    @Override
    public String toString(){
        return "Tricycle";
    }
}
class UnicycleFactory implements Factory{
    @Override
    public Cycle getCycle(){
        return new Unicycle();
    }
}
class BicycleFactory implements Factory{
    @Override
    public Cycle getCycle(){
        return new Bicycle();
    }
}
class TricycleFactory implements Factory{
   @Override
    public Cycle getCycle(){
       return new Tricycle();
   }
}
