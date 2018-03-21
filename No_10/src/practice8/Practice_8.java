/**
 * Determine whether an outer class has access to
 * the private elements of its inner class
 */
/**
 * 外部类可以通过创建内部类对象来访问内部内的所有域，但不能直接访问内部内的域
 */
package practice8;

public class Practice_8 {
    static public void main(String[] args){
        Outter outter = new Outter();
        outter.outerFun();
    }
}

class Outter{
    class Inner{
        private int i=0;
        private void innerFun(){
            System.out.println("innerFun()");
        }
    }
    public void outerFun(){
        Inner inner = new Inner();
        System.out.println(inner.i);
        inner.innerFun();
        //!innerFun();
        //!System.out.println(i);
    }

}
