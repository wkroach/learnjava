/**
 * Create a class with a non-default constructor
 * (one with arguments) and no default constructor
 * (no "no-arg" constructor). Create a second class
 * with a method that returns a reference to
 * an object of the first class. Create the object
 * you return by making an anonymous inner
 * class inherit from the first class.
 */
package practice15;

public class Practice_15 {
    static public void main(String[] args){
        NoDefault noDefault = new Base().getNoDefault(1);
        noDefault.fun();
        noDefault = new Base().getNoDefault2(2);
        noDefault.fun();
    }
}

class NoDefault{
    public NoDefault(int i){
        System.out.println(i);
    }
    public void fun(){
        System.out.println("Base1 fun()");
    }
}

class Base{
    public NoDefault getNoDefault(int i){
        return new NoDefault(i){
            @Override
           public void fun(){
               System.out.println("Inner fun()");
           }
        };
    }
    public NoDefault getNoDefault2(int i){
        return new NoDefault(i){
        };
    }
}
