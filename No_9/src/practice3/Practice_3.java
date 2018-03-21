/** Create a base class with an abstract print()
* method that is overridden in a derived class.
* The overridden version of the method prints
* the value of an int variable defined in the
* derived class. Define this variable with a
* nonzero value. Call print() in the
* base-class constructor. Create an object of
* the derived type in main(), then call its
* print() method. Explain the results.
 */
/**
 * 在基类构造函数中调用被子类override的方法会访问未初始化的子类的域，
 * 此时子类的域均为0
 */
package practice3;

public class Practice_3 {
    public static void main(String[] args){
        Inherit inherit = new Inherit();
        inherit.print();
    }
}

abstract class Base{
    abstract public void print();
    public Base(){
        print();
    }
}

class Inherit extends Base{
    private int i = 1;
    @Override
    public void print(){
       System.out.println(i);
    }
}
