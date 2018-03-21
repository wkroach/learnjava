/**
 * Create a class containing a nested class.
 * In main(), create an instance of the nested
 * class.
 */
/**
 * 区别静态内部类（嵌套类）和普通内部类初始化的不同
 */
package practice18;

public class Practice_18 {
    static public void main(String[] args){
        Outer.Inner inner = new Outer().getInner();
        Outer.Inner inner1 = new Outer().new Inner();
        Outer.InnerStatic innerStatic = new Outer.InnerStatic();
    }
}

class Outer{
    class Inner{
        public Inner(){
            System.out.println("Inner()");
        }
    }

    static class InnerStatic{
        public InnerStatic(){
            System.out.println("InnerStatic()");
        }
    }
    Inner getInner(){
        return new Inner();
    }
   static public void main(String[] args){
        Inner inner = new Outer().getInner();
        Inner inner2 = new Outer().new Inner();
        //不能直接创建Inner对象
        //!Inner inner2 = new Inner();
        InnerStatic innerStatic = new InnerStatic();
        InnerStatic innerStatic1 = new InnerStatic();
   }
}
