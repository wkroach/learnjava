/**
 * Create a class with an inner class that has a
 * non-default constructor (one that takes
 * arguments). Create a second class with an inner
 * class that inherits from the first inner class.
 */
/**
 * 使用内部类继承实现中介者模式
 * 初始化内部类子类时，构造函数参数中必须要有
 * 原外部类的对象，并且在构造函数的第一行要调用super
 */
package practie26;

public class Practice_26 {
    static public void main(String[] args){
        Outer outer = new Outer();
        Outer2.Inner inner = new Outer2().new Inner(outer);
    }
}

class Outer{
    class Inner{
       public Inner(int i){
           System.out.println(i);
       }
    }
}

class Outer2{
    class Inner extends Outer.Inner{
        public Inner(Outer outer){
           outer.super(1);
        }
    }
}

