/**
 * Use anonymous inner classes to modify the
 * solution to Exercise 18 from the Interfaces chapter.
 */
/**
 * 用匿名内部类实现工厂模式
 */
package practice16;


public class Practice_16 {
    static public void cycleCosumer(Factory factory){
        System.out.println(factory.getCycle());
    }
    static public void main(String[] args){
        cycleCosumer(Unicycle.factory);
        cycleCosumer(Bicycle.factory);
        cycleCosumer(Tricycle.factory);
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
    static public Factory factory = new Factory(){
        @Override
        public Cycle getCycle(){
           return new Unicycle();
        }
    };
}
class Bicycle implements Cycle{
    @Override
    public String toString(){
        return "Bicycle";
    }
    static public Factory factory = new Factory() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}
class Tricycle implements Cycle{
    @Override
    public String toString(){
        return "Tricycle";
    }
    static public Factory factory = new Factory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}

