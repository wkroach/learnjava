/**
 * Create a class with an inner class. In a
 * separate class, make an instance of the inner
 * class.
 */
/**
 * 定义内部类对象必须先有一个相对应的外部类对象的引用，因为内部内对象和外部类对象是绑定的
 */
package practice5;

public class Practice_5 {
}

class Outer{
    class Inner{
        @Override
        public String toString() {
            return "Inner()";
        }
    }
}

class Outer2{
    Outer.Inner outerInner;
    public Outer2(Outer outer){
       outerInner = outer.new Inner();
       System.out.println(this.outerInner);
    }
    static public void main(String[] args){
        Outer outer = new Outer();
        Outer2 outer2 = new Outer2(outer);
    }
}
