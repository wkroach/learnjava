/****************** Exercise 4 ******************
 * Create an abstract class with no methods.
 * Derive a class and add a method.
 * Create a  static method that downcasts a reference from
 * the base class to the derived class and calls
 * the method. Demonstrate that it works in main().
 * * Eliminate the need for the downcast by moving
 * * the abstract declaration to the base class.
 * ***********************************************/
/**
 *在虚基类中加抽象函数声明可以避免基类调用子类函数时需要downcast
 */
package practice4;

public class Practice_4 {
    public static void test(Base base){
        ((Inherit)base).print();
    }
    public static void test1(Base1 base1){
        base1.print();
    }
    public static void main(String[] args){
       Base base = new Inherit();
       test(base);
       Base1 base1 = new Inherit1();
       test1(base1);
    }
}

abstract class Base{
}

class Inherit extends Base{
    public void print(){
        System.out.println("Inherit class");
    }
}

abstract class Base1{
    abstract public void print();
}

class Inherit1 extends Base1{
    @Override
    public void print(){
        System.out.println("Inherit1 class");
    }
}
